package io.neocdtv.upnp;

import io.neocdtv.upnp.helpers.HttpConstants;
import io.neocdtv.upnp.helpers.SsdpConstants;
import io.neocdtv.upnp.helpers.UpnpDiscoverFactory;
import io.neocdtv.upnp.helpers.UpnpNotifyFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.neocdtv.upnp.helpers.SsdpConstants.*;
import static io.neocdtv.upnp.helpers.SsdpConstants.MULTICAST_IP;

/**
 * @author xix
 */
public class UpnpDiscover extends Thread {

  private EventsHandler eventsHandler;

  public static void main(String[] args) throws InterruptedException {
    startIt(new EventsHandlerDefault());
  }

  public static void startIt(final EventsHandler eventsHandler) {
    UpnpDiscover upnpDiscover = new UpnpDiscover();
    upnpDiscover.setEventsHandler(eventsHandler);
    upnpDiscover.start();
  }

  private final static Logger LOGGER = Logger.getLogger(UpnpDiscover.class.getName());

  @Override
  public void run() {

    try {
      InetAddress multicastAddress = InetAddress.getByName(MULTICAST_IP);
      final DatagramSocket msocket = new DatagramSocket();
      msocket.setBroadcast(true);
      msocket.setReuseAddress(true);

      UpnpDiscoverFactory upnpDiscoverFactory = new UpnpDiscoverFactory(SsdpConstants.MULTICAST_IP, SsdpConstants.MULTICAST_PORT);
      sendSSDP(multicastAddress, msocket, upnpDiscoverFactory.buildRootDiscoveryRequest());

      while (true) {
        byte[] inbuf = new byte[8192];
        DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);
        msocket.receive(packet);
        int numBytesReceived = packet.getLength();
        final String receivedMessage = new String(inbuf, 0, numBytesReceived);
        LOGGER.info("SSDP message received from " + packet.getAddress());
        LOGGER.info("SSDP message received:\n==========================================================\n" + receivedMessage);
        // check if receivedMessage is for a device of your interest
        final String address = extractAddress(receivedMessage);
        final String name = extractName(receivedMessage);
        eventsHandler.onDeviceDiscovery(address, name);
        // get device description - currently only required for device name
        // alternatively also the device name could be taken from the http headers
      }
    } catch (UnknownHostException ex) {
      Logger.getLogger(UpnpDiscover.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(UpnpDiscover.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private String extractAddress(String receivedMessage) {
    return "192.168.178.129:8080";
  }

  private String extractName(String receivedMessage) {
    return "Zenplayer - hardcoded";
  }

  private static void sendSSDP(InetAddress multicastAddress, DatagramSocket msocket, String msg) throws IOException, UnsupportedEncodingException {
    byte[] txbuf = msg.getBytes("UTF-8");
    DatagramPacket hi = new DatagramPacket(txbuf, txbuf.length, multicastAddress, MULTICAST_PORT);
    msocket.send(hi);
    LOGGER.info("SSDP discover sent:\n" + msg);
  }

  public void setEventsHandler(EventsHandler eventsHandler) {
    this.eventsHandler = eventsHandler;
  }
}
