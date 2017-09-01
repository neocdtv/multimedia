/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.simpleplayer.player.upnp;

import io.neocdtv.service.UrlBuilder;
import io.neocdtv.simpleplayer.player.Player;
import io.neocdtv.simpleplayer.player.PlayerException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/**
 *
 * @author xix
 */
public class UpnpPlayer implements Player {

    private final static Logger LOGGER = Logger.getLogger(UpnpPlayer.class.getName());
    private final static List<MediaStatusUpdateListener> listeners = new ArrayList<>();

    static final String ACTION_NAME_SET_URI = "SetAVTransportURI";
    static final String ACTION_NAME_PLAY = "Play";
    static final String ACTION_NAME_PAUSE = "Pause";
    static final String ACTION_NAME_GET_VOLUME = "GetVolume";
    static final String ACTION_NAME_SET_VOLUME = "SetVolume";
    static final String ACTION_NAME_GET_TRANSPORT_INFO = "GetTransportInfo";

    private static String baseUrl;
    private static String avControlUrl;
    private static String renderingControlUrl;

    public UpnpPlayer(String baseUrlParam, String controlUrlParam, String renderingControlUrlParam) {
        baseUrl = baseUrlParam;
        avControlUrl = controlUrlParam;
        renderingControlUrl = renderingControlUrlParam;
        listeners.add(new MediaStatusUpdateHandler());
        new MediaStatusUpdateThread();
    }

    @Override
    public String getPlayerStatus() throws PlayerException {
        String playerStatus = null;
        try {
            playerStatus = sendAndExtractPlayerStatus();
        } catch (IOException | SOAPException | DOMException ex) {
            Logger.getLogger(UpnpPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playerStatus;
    }

    private static class MediaStatusUpdateThread extends TimerTask {

        public MediaStatusUpdateThread() {
            Timer timer = new Timer();
            timer.schedule(this, 0, 1000);
        }

        @Override
        public void run() {
            if (listeners != null) {
                try {
                    String playerStatus = sendAndExtractPlayerStatus();
                    final boolean playing = playerStatus.equals("PLAYING");
                    LOGGER.log(Level.INFO, "mediastatus {0}", playing);
                    for (MediaStatusUpdateListener listener : listeners) {
                        listener.handleEvent(new MediaStatusUpdateEvent(playing));
                    }
                } catch (SOAPException | IOException ex) {
                    Logger.getLogger(UpnpPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private static String sendAndExtractPlayerStatus() throws IOException, SOAPException, DOMException {
        final SOAPMessage response = sendGetTransportInfoRequest();
        final Node firstChild = response.getSOAPBody().getFirstChild().getFirstChild().getFirstChild();
        final String nodeValue = firstChild.getNodeValue();
        return nodeValue;
    }

    @Override
    public void play() throws PlayerException {
        try {
            sendPlayRequest();
        } catch (SOAPException | IOException ex) {
            Logger.getLogger(UpnpPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void play(String url) throws PlayerException {
        final String urlToBePlayed = UrlBuilder.build(url);
        try {
            sendSetUriRequest(urlToBePlayed);
            sendPlayRequest();
        } catch (UnsupportedOperationException | SOAPException | MalformedURLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UpnpPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pause() throws PlayerException {
        try {
            sendPauseRequest();
        } catch (UnsupportedOperationException | SOAPException | MalformedURLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UpnpPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void next() throws PlayerException {

    }

    @Override
    public void volumeUp() throws PlayerException {
        try {
            final int currentVolume = sendGetVolumeRequest();
            if (currentVolume < 100) {
                sendSetVolumeRequest(currentVolume + 10 + "");
            }
        } catch (SOAPException | IOException ex) {
            Logger.getLogger(UpnpPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void volumeDown() throws PlayerException {
        try {
            final int currentVolume = sendGetVolumeRequest();
            if (currentVolume > 0) {
                sendSetVolumeRequest(currentVolume - 10 + "");
            }
        } catch (SOAPException | IOException ex) {
            Logger.getLogger(UpnpPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void shutdown() throws PlayerException {

    }

    private static SOAPMessage sendGetTransportInfoRequest() throws MalformedURLException, SOAPException, IOException {
        SOAPConnection connection = createSoapConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        final String message = SoapMessageBuilder.buildGetTransportInfoMessage();
        LOGGER.log(Level.INFO, "get media info message:\r\n {0}", message);

        final MimeHeaders mimeHeaders = createHeaderForActionName(ACTION_NAME_GET_TRANSPORT_INFO);
        final SOAPMessage soapRequest = messageFactory.createMessage(mimeHeaders, new ByteArrayInputStream(message.getBytes()));
        URL endpoint = new URL(avControlUrl);
        SOAPMessage response = connection.call(soapRequest, endpoint);
        printSoapMessage(response);
        return response;
    }
    
    private void sendPlayRequest() throws MalformedURLException, SOAPException, IOException {
        SOAPConnection connection = createSoapConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        final String message = SoapMessageBuilder.buildPlayMessage();
        LOGGER.log(Level.INFO, "play message:\r\n {0}", message);

        final MimeHeaders mimeHeaders = createHeaderForActionName(ACTION_NAME_PLAY);
        final SOAPMessage soapRequest = messageFactory.createMessage(mimeHeaders, new ByteArrayInputStream(message.getBytes()));
        URL endpoint = new URL(avControlUrl);
        SOAPMessage response = connection.call(soapRequest, endpoint);
        printSoapMessage(response);
    }

    private int sendGetVolumeRequest() throws MalformedURLException, SOAPException, IOException {
        SOAPConnection connection = createSoapConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        final String message = SoapMessageBuilder.buildGetVolumeMessage();
        LOGGER.log(Level.INFO, "setVolume message:\r\n {0}", message);

        final MimeHeaders mimeHeaders = createHeaderForActionName(ACTION_NAME_GET_VOLUME);
        final SOAPMessage soapRequest = messageFactory.createMessage(mimeHeaders, new ByteArrayInputStream(message.getBytes()));
        URL endpoint = new URL(renderingControlUrl);
        SOAPMessage response = connection.call(soapRequest, endpoint);
        printSoapMessage(response);
        final Node firstChild = response.getSOAPBody().getFirstChild().getFirstChild().getFirstChild();
        return Integer.parseInt(firstChild.getNodeValue());
    }

    private void sendSetVolumeRequest(final String volume) throws MalformedURLException, SOAPException, IOException {
        SOAPConnection connection = createSoapConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        final String message = SoapMessageBuilder.buildSetVolumeMessage(volume);
        LOGGER.log(Level.INFO, "setVolume message:\r\n {0}", message);

        final MimeHeaders mimeHeaders = createHeaderForActionName(ACTION_NAME_SET_VOLUME);
        final SOAPMessage soapRequest = messageFactory.createMessage(mimeHeaders, new ByteArrayInputStream(message.getBytes()));
        URL endpoint = new URL(renderingControlUrl);
        SOAPMessage response = connection.call(soapRequest, endpoint);
        printSoapMessage(response);
    }

    private void sendPauseRequest() throws MalformedURLException, SOAPException, IOException {
        SOAPConnection connection = createSoapConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        final String message = SoapMessageBuilder.buildPauseMessage();
        LOGGER.log(Level.INFO, "pause message:\r\n {0}", message);

        final MimeHeaders mimeHeaders = createHeaderForActionName(ACTION_NAME_PAUSE);
        final SOAPMessage soapRequest = messageFactory.createMessage(mimeHeaders, new ByteArrayInputStream(message.getBytes()));
        URL endpoint = new URL(avControlUrl);
        SOAPMessage response = connection.call(soapRequest, endpoint);
        printSoapMessage(response);
    }

    private static SOAPMessage buildSoapRequestSetUriRequest(final String urlToBePlayed) throws SOAPException, IOException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        final String message = SoapMessageBuilder.buildSetUriMessage(urlToBePlayed);
        LOGGER.log(Level.INFO, "set uri message:\r\n {0}", message);

        final MimeHeaders mimeHeaders = createHeaderForActionName(ACTION_NAME_SET_URI);
        return messageFactory.createMessage(mimeHeaders, new ByteArrayInputStream(message.getBytes()));
    }

    private static void sendSetUriRequest(final String urlToBePlayed) throws MalformedURLException, SOAPException, UnsupportedOperationException, IOException {
        SOAPConnection connection = createSoapConnection();

        final SOAPMessage soapRequest = buildSoapRequestSetUriRequest(urlToBePlayed);
        LOGGER.log(Level.INFO, "control url: {0}", avControlUrl);
        URL endpoint = new URL(avControlUrl);
        SOAPMessage response = connection.call(soapRequest, endpoint);
        LOGGER.log(Level.INFO, "response: {0}", response);
    }

    private static SOAPConnection createSoapConnection() throws UnsupportedOperationException, SOAPException {
        SOAPConnectionFactory connectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = connectionFactory.createConnection();
        return connection;
    }

    private static MimeHeaders createHeaderForActionName(final String actionName) {
        final MimeHeaders mimeHeaders = new MimeHeaders();
        mimeHeaders.addHeader("Content-type", "text/xml");
        mimeHeaders.addHeader("SOAPAction", "urn:schemas-upnp-org:service:AVTransport:1#" + actionName);
        return mimeHeaders;
    }

    private static void printSoapMessage(SOAPMessage msg) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            msg.writeTo(out);
            String strMsg = new String(out.toByteArray());
            LOGGER.log(Level.INFO, "soapMessage:\r\n {0}", strMsg);
        } catch (SOAPException | IOException ex) {
            Logger.getLogger(UpnpPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
