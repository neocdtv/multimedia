package io.neocdtv.upnp.helpers;

import java.util.UUID;

/**
 * Created by xix on 11.09.17.
 */
public class UpnpHelper {

  public final static String ROOT_DEVICE = "upnp:rootdevice";
  public final static String MEDIA_RENDERER = "urn:schemas-upnp-org:device:MediaRenderer:1";
  public final static String AV_TRANSPORT = "urn:schemas-upnp-org:service:AVTransport:1";
  public final static String RENDERING_CONTROL = "urn:schemas-upnp-org:service:RenderingControl:1";
  public final static String CONNECTION_MANAGER = "urn:schemas-upnp-org:service:ConnectionManager:1";

  public static final String EXT = "EXT";
  public static final String ST = "ST";
  public static final String MX = "MX";
  public static final String MAN = "MAN";

  public final static String UPNP_ALIVE = "upnp:alive";

  public final static String IP_WITH_PORT = "192.168.178.136:8080";
  public final static String LOCATION = "http://" + IP_WITH_PORT + "/desc.xml";
  public final static String SERVER = "UPnP/1.0 zenplayer/0.1";

  private UpnpHelper() {
  }

  public static String buildUsn(final String uuid, final String serviceOrDevice) {
    return uuid + "::" + serviceOrDevice;
  }

  public static String buildNt(final String uuid, final String serviceOrDevice) {
    return uuid + "::" + serviceOrDevice;
  }

  public static String buildUuid() {
    return "uuid:" + UUID.randomUUID();
  }
}
