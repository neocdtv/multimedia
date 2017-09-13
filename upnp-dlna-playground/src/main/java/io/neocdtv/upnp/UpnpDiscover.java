/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.upnp;

import io.neocdtv.upnp.helpers.UpnpHelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author xix
 */
public class UpnpDiscover extends Thread {

  public static void main(String[] args) throws InterruptedException {
    startIt();
  }

  public static void startIt() {
    new UpnpDiscover().start();
  }

  private final static Logger LOGGER = Logger.getLogger(UpnpDiscover.class.getName());
  private final static String MULTICAST_IP = "239.255.255.250";
  private final static int PORT = 1900;
  private final static String DISCOVER_REQUEST
      = "M-SEARCH * HTTP/1.1\r\n"
      + "MX: 3\r\n"
      + "MAN: \"ssdp:discover\"\r\n"
      //+ "ST: upnp:all\r\n"
      + "ST: " + UpnpHelper.MEDIA_RENDERER + "\r\n"
      //+ "ST: " + UpnpHelper.ROOT_DEVICE + "\r\n"
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
        LOGGER.info("SSDP message received from " + packet.getAddress());
        LOGGER.info("SSDP message received:\n==========================================================\n" + receivedMessage);
      }
    } catch (UnknownHostException ex) {
      Logger.getLogger(UpnpDiscover.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(UpnpDiscover.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void sendSSDP(InetAddress multicastAddress, DatagramSocket msocket, String msg) throws IOException, UnsupportedEncodingException {
    byte[] txbuf = msg.getBytes("UTF-8");
    DatagramPacket hi = new DatagramPacket(txbuf, txbuf.length, multicastAddress, PORT);
    msocket.send(hi);
    LOGGER.info("SSDP discover sent:\n" + msg);
  }
}
