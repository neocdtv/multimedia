/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.upnp;

import io.neocdtv.upnp.helpers.GenaHelper;
import io.neocdtv.upnp.helpers.SsdpHelper;
import io.neocdtv.upnp.helpers.UpnpHelper;
import io.neocdtv.upnp.helpers.UpnpResponseFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author xix
 */
public class UpnpResponseToDiscover extends Thread {

  private final static Logger LOGGER = Logger.getLogger(UpnpResponseToDiscover.class.getName());

  public static void main(String[] args) throws InterruptedException {
    startIt();
  }

  public static void startIt() {
    new UpnpResponseToDiscover().start();
  }

  @Override
  public void run() {

    try {

      MulticastSocket socket = new MulticastSocket(SsdpHelper.MULTICAST_PORT);
      InetAddress group = InetAddress.getByName(SsdpHelper.MULTICAST_IP);

      socket.joinGroup(group);

      UpnpResponseFactory responseBuilder =
          UpnpResponseFactory.
              create(UpnpHelper.buildUuid(), UpnpHelper.SERVER, UpnpHelper.LOCATION);

      while (true) {
        byte[] inbuf = new byte[8192];
        DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);
        socket.receive(packet);

        int numBytesReceived = packet.getLength();
        final String receivedMessage = new String(inbuf, 0, numBytesReceived);

        if (receivedMessage.contains(GenaHelper.HTTP_METHOD_SEARCH)) {
          LOGGER.info("SSDP multicast message received: \n" + receivedMessage + "\n");

          // TODO: if a device requests for ROOT_DEVICE, is it possible to answer only with MEDIA_RENDERER?
          if (receivedMessage.contains(UpnpHelper.ROOT_DEVICE)) {
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildRootDeviceResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildPlainResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildMediaRendererResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildRenderingControlResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildConnectionManagerResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildAVTransportResponse());
          }
          if (receivedMessage.contains(UpnpHelper.MEDIA_RENDERER)) {
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildMediaRendererResponse());
          }
        }
      }
    } catch (UnknownHostException ex) {
      Logger.getLogger(UpnpResponseToDiscover.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(UpnpResponseToDiscover.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void sendResponse(InetAddress address, int port, String msg) throws IOException {
    final DatagramSocket unicastSocket = new DatagramSocket();
    LOGGER.info("SSDP response to: " + address.getCanonicalHostName() + " and " + port);
    unicastSocket.setReuseAddress(true);

    byte[] txbuf = msg.getBytes("UTF-8");
    DatagramPacket responseToDiscover = new DatagramPacket(txbuf, txbuf.length, address, port);
    LOGGER.info("SSDP sent: " + msg);
    unicastSocket.send(responseToDiscover);
  }
}