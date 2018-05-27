/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.upnp;

import io.neocdtv.upnp.helpers.UpnpNotifyFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.neocdtv.upnp.helpers.SsdpConstants.MULTICAST_IP;
import static io.neocdtv.upnp.helpers.SsdpConstants.MULTICAST_PORT;
import static io.neocdtv.upnp.helpers.UpnpHelper.LOCATION;
import static io.neocdtv.upnp.helpers.UpnpHelper.SERVER;
import static io.neocdtv.upnp.helpers.UpnpHelper.buildUuid;

/**
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
      InetAddress multicastAddress = InetAddress.getByName(MULTICAST_IP);
      final DatagramSocket msocket = new DatagramSocket();
      msocket.setBroadcast(true);
      msocket.setReuseAddress(true);

      UpnpNotifyFactory upnpNotifyFactory = UpnpNotifyFactory.
          create(buildUuid(), SERVER, LOCATION);

      sendSSDP(multicastAddress, msocket, upnpNotifyFactory.buildRootDeviceNotifyRequest());
      sendSSDP(multicastAddress, msocket, upnpNotifyFactory.buildPlainNotifyRequest());
      sendSSDP(multicastAddress, msocket, upnpNotifyFactory.buildMediaRendererNotifyRequest());
      sendSSDP(multicastAddress, msocket, upnpNotifyFactory.buildConnectionManagerNotifyRequest());
      // is this an error
      sendSSDP(multicastAddress, msocket, upnpNotifyFactory.buildRenderingControlDiscoveryResponse());
      sendSSDP(multicastAddress, msocket, upnpNotifyFactory.buildAVTransportNotifyDiscoveryResponse());

    } catch (UnknownHostException ex) {
      Logger.getLogger(UpnpNotify.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(UpnpNotify.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void sendSSDP(InetAddress multicastAddress, DatagramSocket msocket, String msg) throws IOException {
    byte[] txbuf = msg.getBytes("UTF-8");
    DatagramPacket hi = new DatagramPacket(txbuf, txbuf.length, multicastAddress, MULTICAST_PORT);
    msocket.send(hi);
    LOGGER.log(Level.FINE, "SSDP discover sent:\n" + msg);
  }
}
