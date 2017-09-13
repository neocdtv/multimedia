package io.neocdtv.upnp.helpers;

/**
 * Created by xix on 11.09.17.
 */
public class SsdpHelper {
  public final static String MULTICAST_IP = "239.255.255.250";
  public final static int MULTICAST_PORT = 1900;
  public final static String MULTICAST_ADDRESS = MULTICAST_IP + ":" + MULTICAST_PORT;
  public final static String HTTP_HEADER_NAME_UNIQUE_SERVICE_NAME = "USN";
  public final static String NTS_ALIVE = "upnp:alive";
  public final static String MAN_ALIVE = "ssdp:discover";

}
