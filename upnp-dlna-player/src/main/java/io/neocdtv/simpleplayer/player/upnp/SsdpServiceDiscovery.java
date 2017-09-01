/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.simpleplayer.player.upnp;

import io.neocdtv.simpleplayer.player.upnp.device.Root;
import io.neocdtv.simpleplayer.player.upnp.device.ServiceListType;
import io.neocdtv.simpleplayer.player.upnp.device.ServiceListType.Service;
import io.neocdtv.simpleplayer.player.upnp.service.Scpd;
import io.neocdtv.simpleplayer.ui.ComboBoxFactory;
import io.neocdtv.simpleplayer.ui.CombolistEntry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.ws.rs.client.ClientBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author xix
 */
public class SsdpServiceDiscovery extends Thread {

    private final static Logger LOGGER = Logger.getLogger(SsdpServiceDiscovery.class.getName());
    private final static String MULTICAST_IP = "239.255.255.250";
    private final static int PORT = 1900;
    private final static String DISCOVER_REQUEST
            = "M-SEARCH * HTTP/1.1\r\n"
            + "MX: 3\r\n"
            + "MAN: \"ssdp:discover\"\r\n"
            + "ST: urn:schemas-upnp-org:device:MediaRenderer:1\r\n"
            + "HOST: " + MULTICAST_IP + ":" + PORT + "\r\n\r\n";

    @Override
    public void run() {
        try {
            final DefaultComboBoxModel<CombolistEntry> comboBoxModel = ComboBoxFactory.instance();
                        
            InetAddress multicastAddress = InetAddress.getByName(MULTICAST_IP);
            final DatagramSocket msocket = new DatagramSocket();
            msocket.setBroadcast(true);
            msocket.setReuseAddress(true);

            sendSSDP(multicastAddress, msocket, DISCOVER_REQUEST);

            while (true) {
                byte[] inbuf = new byte[8192];
                DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);
                msocket.receive(packet);
                int numBytesReceived = packet.getLength();
                final String receivedMessage = new String(inbuf, 0, numBytesReceived);
                System.out.println("SSDP receceived response to discover:\n" + receivedMessage);
                final String serviceDescriptionLocation = extractLocation(receivedMessage);
                final URL url = new URL(serviceDescriptionLocation);
                final String baseUrl = url.getProtocol() + "://" + url.getHost() + ":" + url.getPort();
                
                String responseEntity = get(serviceDescriptionLocation);

                JAXBContext jaxbContext = JAXBContext.newInstance(Root.class, Scpd.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                Root rootDeviceDescription = (Root) jaxbUnmarshaller.unmarshal(new StringReader(responseEntity));
                final String upnpDeviceName = rootDeviceDescription.getDevice().getFriendlyName();
                LOGGER.log(Level.INFO, "found upnp device {0} -> adding to list", upnpDeviceName);

                final String serviceTypeAV = "urn:schemas-upnp-org:service:AVTransport:1";
                final Service avService = findByServiceType(rootDeviceDescription.getDevice().getServiceList(), serviceTypeAV);
                final String serviceTypeRendering = "urn:schemas-upnp-org:service:RenderingControl:1";
                final Service renderingService = findByServiceType(rootDeviceDescription.getDevice().getServiceList(), serviceTypeRendering);
                
                LOGGER.log(Level.INFO, "found upnp device {0} -> adding to list", upnpDeviceName);
                final String avControlUrl = baseUrl + avService.getControlURL();
                final String renderingServiceUrl = baseUrl + renderingService.getControlURL();
                
                comboBoxModel.addElement(new CombolistEntry(upnpDeviceName, new UpnpPlayer(baseUrl, avControlUrl, renderingServiceUrl)));
            }
        } catch (IOException | JAXBException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private String get(final String host) {
        LOGGER.log(Level.INFO, "getting content from url: {0}");
        String responseEntity = ClientBuilder.newClient()
                .target(host)
                .request().get(String.class);
        return responseEntity;
    }

    private static void sendSSDP(InetAddress multicastAddress, DatagramSocket msocket, String msg) throws IOException, UnsupportedEncodingException {
        byte[] txbuf = msg.getBytes("UTF-8");
        DatagramPacket hi = new DatagramPacket(txbuf, txbuf.length,
                multicastAddress, PORT);
        msocket.send(hi);
        System.out.println("SSDP discover sent");
    }

    private String extractLocation(String receivedMessage) throws IOException {
        String locationValue = null;
        final BufferedReader bufferedReader = new BufferedReader(new StringReader(receivedMessage));
        String line;
        final String locationHeader = "location:";
        while ((line = bufferedReader.readLine()) != null) {
            final String lowerCaseLine = line.toLowerCase();
            if (lowerCaseLine.matches(locationHeader + ".*")) {
                locationValue = lowerCaseLine.replaceAll(locationHeader, "").trim();
            }
        }
        LOGGER.log(Level.INFO, "extracted location: {0}", locationValue);
        return locationValue;
    }

    private Service findByServiceType(ServiceListType serviceList, String serviceTypeAV) {
        Service foundService = null;
        for (Service service : serviceList.getService()) {
            if (service.getServiceType().equals(serviceTypeAV)) {
                foundService = service;
                break;
            }
        }
        return foundService;
    }
}
