/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.ssdp;

/**
 *
 * @author xix
 */
public class SsdpConstants {
  
  public final static String MULTICAST_IP = "239.255.255.250";
  public final static int MULTICAST_PORT = 1900;
  
  public final static String NOTIFY_ONE
          = "NOTIFY * HTTP/1.1\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Host: " + MULTICAST_IP + ":" + MULTICAST_PORT + "\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::upnp:rootdevice" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Nt: upnp:rootdevice\r\n"
          + "Nts: ssdp:alive\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "\r\n";

  public final static String NOTIFY_TWO
          = "NOTIFY * HTTP/1.1\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Host: " + MULTICAST_IP + ":" + MULTICAST_PORT + "\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Nt: uuid:4D454930-0100-1000-8001-20C6EBA660A1" + "\r\n"
          + "Nts: ssdp:alive\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "\r\n";

  public final static String NOTIFY_THREE
          = "NOTIFY * HTTP/1.1\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Host: " + MULTICAST_IP + ":" + MULTICAST_PORT + "\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::urn:schemas-upnp-org:device:MediaRenderer:1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Nt: urn:schemas-upnp-org:device:MediaRenderer:1\r\n"
          + "Nts: ssdp:alive\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "\r\n";

  public final static String NOTIFY_FOUR
          = "NOTIFY * HTTP/1.1\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Host: " + MULTICAST_IP + ":" + MULTICAST_PORT + "\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::urn:schemas-upnp-org:service:ConnectionManager:1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Nt: urn:schemas-upnp-org:service:ConnectionManager:1\r\n"
          + "Nts: ssdp:alive\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "\r\n";

  public final static String NOTIFY_FIVE
          = "NOTIFY * HTTP/1.1\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Host: " + MULTICAST_IP + ":" + MULTICAST_PORT + "\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::urn:schemas-upnp-org:service:RenderingControl:1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Nt: urn:schemas-upnp-org:service:RenderingControl:1\r\n"
          + "Nts: ssdp:alive\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "\r\n";

  public final static String NOTIFY_SIX
          = "NOTIFY * HTTP/1.1\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Host: " + MULTICAST_IP + ":" + MULTICAST_PORT + "\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::urn:schemas-upnp-org:service:AVTransport:1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Nt: urn:schemas-upnp-org:service:AVTransport:1\r\n"
          + "Nts: ssdp:alive\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "\r\n";

  public final static String DISCOVER_RESPONSE_ONE
          = "HTTP/1.1 200 OK\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::upnp:rootdevice" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "Ext: \r\n"
          + "St: upnp:rootdevice\r\n"
          + "\r\n";

  public final static String DISCOVER_RESPONSE_TWO
          = "HTTP/1.1 200 OK\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "Ext: \r\n"
          + "St: uuid:4D454930-0100-1000-8001-20C6EBA660A1" + "\r\n"
          + "\r\n";

  public final static String DISCOVER_RESPONSE_THREE
          = "HTTP/1.1 200 OK\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::urn:schemas-upnp-org:device:MediaRenderer:1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "Ext: \r\n"
          + "St: urn:schemas-upnp-org:device:MediaRenderer:1\r\n"
          + "\r\n";

  public final static String DISCOVER_RESPONSE_FOUR
          = "HTTP/1.1 200 OK\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::urn:schemas-upnp-org:service:ConnectionManager:1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "Ext: \r\n"
          + "St: urn:schemas-upnp-org:service:ConnectionManager:1\r\n"
          + "\r\n";

  public final static String DISCOVER_RESPONSE_FIVE
          = "HTTP/1.1 200 OK\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::urn:schemas-upnp-org:service:RenderingControl:1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "Ext: \r\n"
          + "St: urn:schemas-upnp-org:service:RenderingControl:1\r\n"
          + "\r\n";

  public final static String DISCOVER_RESPONSE_SIX
          = "HTTP/1.1 200 OK\r\n"
          + "Cache-Control: max-age=1800\r\n"
          + "Usn: uuid:4D454930-0100-1000-8001-20C6EBA660A1::urn:schemas-upnp-org:service:AVTransport:1" + "\r\n"
          + "Location: http://192.168.178.132:8080/zenplayer-renderer-mplayer/desc.xml\r\n"
          + "Server: FreeBSD/1.0 UPnP/1.0 zenplayer/0.1\r\n"
          + "Ext: \r\n"
          + "St: urn:schemas-upnp-org:service:AVTransport:1\r\n"
          + "\r\n";

  
}
