/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.ssdp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xix
 */
public class SsdpDiscovery extends Thread {

  private final static Logger LOGGER = Logger.getLogger(SsdpDiscovery.class.getName());
  private final static String MULTICAST_IP = "239.255.255.250";
  private final static int PORT = 1900;
  private final static String DISCOVER_REQUEST
          = "M-SEARCH * HTTP/1.1\r\n"
          + "MX: 3\r\n"
          + "MAN: \"ssdp:discover\"\r\n"
          //+ "ST: urn:schemas-upnp-org:device:MediaRenderer:1\r\n"
          + "ST: ssdp:all\r\n"
          + "HOST: " + MULTICAST_IP + ":" + PORT + "\r\n\r\n";

  @Override
  public void run() {

    try {
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
        if (receivedMessage.contains("192.168.178.135")) {
          LOGGER.info("SSDP message received from " + packet.getAddress());
          LOGGER.info("SSDP message received:\n" + receivedMessage);
        }
      }
    } catch (UnknownHostException ex) {
      Logger.getLogger(SsdpDiscovery.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(SsdpDiscovery.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void sendSSDP(InetAddress multicastAddress, DatagramSocket msocket, String msg) throws IOException, UnsupportedEncodingException {
    byte[] txbuf = msg.getBytes("UTF-8");
    DatagramPacket hi = new DatagramPacket(txbuf, txbuf.length, multicastAddress, PORT);
    msocket.send(hi);
    LOGGER.info("SSDP discover sent:\n" + msg);
  }
}
