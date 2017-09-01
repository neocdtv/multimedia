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
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xix
 */
public class SsdpResponseToDiscover extends Thread {

  private final static Logger LOGGER = Logger.getLogger(SsdpResponseToDiscover.class.getName());
  
  @Override
  public void run() {

    try {

      MulticastSocket socket = new MulticastSocket(1900);
      InetAddress group = InetAddress.getByName(SsdpConstants.MULTICAST_IP);

      socket.joinGroup(group);

      while (true) {
        byte[] inbuf = new byte[8192];
        DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);
        socket.receive(packet);

        int numBytesReceived = packet.getLength();
        final String receivedMessage = new String(inbuf, 0, numBytesReceived);
        LOGGER.info("SSDP multicast message received: \n" + receivedMessage + "\n");
        

        if (receivedMessage.contains("M-SEARCH")) {
          for (int i = 0; i < 4; i++) {
            sendResponse(packet.getAddress(), packet.getPort(), SsdpConstants.DISCOVER_RESPONSE_ONE);
            sendResponse(packet.getAddress(), packet.getPort(), SsdpConstants.DISCOVER_RESPONSE_TWO);
            sendResponse(packet.getAddress(), packet.getPort(), SsdpConstants.DISCOVER_RESPONSE_THREE);
            sendResponse(packet.getAddress(), packet.getPort(), SsdpConstants.DISCOVER_RESPONSE_FOUR);
            sendResponse(packet.getAddress(), packet.getPort(), SsdpConstants.DISCOVER_RESPONSE_FIVE);
            sendResponse(packet.getAddress(), packet.getPort(), SsdpConstants.DISCOVER_RESPONSE_SIX);
            Thread.sleep(3000);
          }
        }
      }
    } catch (UnknownHostException ex) {
      Logger.getLogger(SsdpResponseToDiscover.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(SsdpResponseToDiscover.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InterruptedException ex) {
      Logger.getLogger(SsdpResponseToDiscover.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void sendResponse(InetAddress address, int port, String msg) throws IOException, UnsupportedEncodingException {
    final DatagramSocket unicastSocket = new DatagramSocket();
    LOGGER.info("SSDP response to: " + address.getCanonicalHostName() + " and " + port);
    unicastSocket.setReuseAddress(true);

    byte[] txbuf = msg.getBytes("UTF-8");
    DatagramPacket responseToDiscover = new DatagramPacket(txbuf, txbuf.length, address, port);
    unicastSocket.send(responseToDiscover);
    LOGGER.info("SSDP response sent: \n" + msg + "\n");
  }
}