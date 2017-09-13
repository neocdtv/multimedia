/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.upnp;

import io.neocdtv.upnp.helpers.SsdpHelper;
import io.neocdtv.upnp.helpers.UpnpHelper;
import io.neocdtv.upnp.helpers.UpnpRequestFactory;

import java.io.IOException;
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
public class UpnpNotify extends Thread {

  private final static Logger LOGGER = Logger.getLogger(UpnpNotify.class.getName());

  public static void main(String[] args) throws InterruptedException {
    startIt();
  }

  public static void startIt() {
    new UpnpNotify().start();
  }

  @Override
  public void run() {

    try {
      InetAddress multicastAddress = InetAddress.getByName(SsdpHelper.MULTICAST_IP);
      final DatagramSocket msocket = new DatagramSocket();
      msocket.setBroadcast(true);
      msocket.setReuseAddress(true);

      UpnpRequestFactory upnpRequestFactory = UpnpRequestFactory.
          create(UpnpHelper.buildUuid(), UpnpHelper.SERVER, UpnpHelper.LOCATION);

      sendSSDP(multicastAddress, msocket, upnpRequestFactory.buildRootDeviceRequest());
      sendSSDP(multicastAddress, msocket, upnpRequestFactory.buildPlainRequest());
      sendSSDP(multicastAddress, msocket, upnpRequestFactory.buildMediaRendererRequest());
      sendSSDP(multicastAddress, msocket, upnpRequestFactory.buildConnectionManagerRequest());
      sendSSDP(multicastAddress, msocket, upnpRequestFactory.buildRenderingControlRequest());
      sendSSDP(multicastAddress, msocket, upnpRequestFactory.buildAVTransportRequest());

    } catch (UnknownHostException ex) {
      Logger.getLogger(UpnpNotify.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(UpnpNotify.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void sendSSDP(InetAddress multicastAddress, DatagramSocket msocket, String msg) throws IOException {
    byte[] txbuf = msg.getBytes("UTF-8");
    DatagramPacket hi = new DatagramPacket(txbuf, txbuf.length, multicastAddress, SsdpHelper.MULTICAST_PORT);
    msocket.send(hi);
    LOGGER.info("SSDP discover sent:\n" + msg);
  }
}
