/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.upnp;

import io.neocdtv.upnp.helpers.GenaConstants;
import io.neocdtv.upnp.helpers.SsdpConstants;
import io.neocdtv.upnp.helpers.UpnpResponseFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.neocdtv.upnp.helpers.UpnpHelper.*;

/**
 * @author xix
 */
public class UpnpResponseToDiscover extends Thread {

  private final static Logger LOGGER = Logger.getLogger(UpnpResponseToDiscover.class.getName());

  private String address;
  private String playerName;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public static void main(String[] args) throws InterruptedException {
    startIt("192.168.178.23", "Zenplayer");
  }

  public static void startIt(final String address, final String name) {
    final UpnpResponseToDiscover upnpResponseToDiscover = new UpnpResponseToDiscover();
    upnpResponseToDiscover.setAddress(address);
    upnpResponseToDiscover.setPlayerName(name);
    upnpResponseToDiscover.start();
  }

  @Override
  public void run() {
    try {
      MulticastSocket socket = new MulticastSocket(SsdpConstants.MULTICAST_PORT);
      InetAddress group = InetAddress.getByName(SsdpConstants.MULTICAST_IP);

      socket.joinGroup(group);

      UpnpResponseFactory responseBuilder =
          UpnpResponseFactory.
              create(buildUuid(), SERVER, LOCATION);

      while (true) {
        byte[] inbuf = new byte[8192];
        DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);
        socket.receive(packet);

        int numBytesReceived = packet.getLength();
        final String receivedMessage = new String(inbuf, 0, numBytesReceived);

        if (receivedMessage.contains(GenaConstants.HTTP_METHOD_SEARCH)) {
          LOGGER.log(Level.INFO, "SSDP multicast message received: \n" + receivedMessage + "\n");

          if (receivedMessage.contains(ROOT_DEVICE)) {
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildRootDeviceResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildPlainResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildMediaRendererResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildRenderingControlResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildConnectionManagerResponse());
            sendResponse(packet.getAddress(), packet.getPort(), responseBuilder.buildAVTransportResponse());
          }
          if (receivedMessage.contains(MEDIA_RENDERER)) {
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
    LOGGER.log(Level.FINE, "SSDP response to: " + address.getCanonicalHostName() + " and " + port);
    unicastSocket.setReuseAddress(true);


    byte[] txbuf = msg.getBytes(StandardCharsets.UTF_8.displayName());
    DatagramPacket responseToDiscover = new DatagramPacket(txbuf, txbuf.length, address, port);
    LOGGER.log(Level.FINE, "SSDP sent: " + msg);
    unicastSocket.send(responseToDiscover);
  }
}