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
public class SsdpNotify extends Thread {

  private final static Logger LOGGER = Logger.getLogger(SsdpNotify.class.getName());

  @Override
  public void run() {

    try {
      InetAddress multicastAddress = InetAddress.getByName(SsdpConstants.MULTICAST_IP);
      final DatagramSocket msocket = new DatagramSocket();
      msocket.setBroadcast(true);
      msocket.setReuseAddress(true);

      sendSSDP(multicastAddress, msocket, SsdpConstants.NOTIFY_ONE);
      sendSSDP(multicastAddress, msocket, SsdpConstants.NOTIFY_TWO);
      sendSSDP(multicastAddress, msocket, SsdpConstants.NOTIFY_THREE);
      sendSSDP(multicastAddress, msocket, SsdpConstants.NOTIFY_FOUR);
      sendSSDP(multicastAddress, msocket, SsdpConstants.NOTIFY_FIVE);
      sendSSDP(multicastAddress, msocket, SsdpConstants.NOTIFY_SIX);

    } catch (UnknownHostException ex) {
      Logger.getLogger(SsdpNotify.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(SsdpNotify.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void sendSSDP(InetAddress multicastAddress, DatagramSocket msocket, String msg) throws IOException, UnsupportedEncodingException {
    byte[] txbuf = msg.getBytes("UTF-8");
    DatagramPacket hi = new DatagramPacket(txbuf, txbuf.length, multicastAddress, SsdpConstants.MULTICAST_PORT);
    msocket.send(hi);
    LOGGER.info("SSDP discover sent:\n" + msg);
  }
}
