package io.neocdtv.upnp.helpers;

/**
 * Created by xix on 11.09.17.
 */
public class UpnpResponseFactory {

  private final String uuid;
  private final String server;
  private final String location;

  public UpnpResponseFactory(final String uuid, final String server, String location) {
    this.uuid = uuid;
    this.server = server;
    this.location = location;
  }

  public static UpnpResponseFactory create(final String uuid, final String server, final String location) {
    String hardcodedUuid = "uuid:4D454930-0100-1000-8001-20C6EBA660A1";
    return new UpnpResponseFactory(hardcodedUuid, server, location);
  }

  public String buildRootDeviceResponse() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.ROOT_DEVICE)).
        location(location).
        server(server).
        ext("").
        st(UpnpHelper.ROOT_DEVICE).
        build();
  }

  public String buildPlainResponse() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        usn(uuid).
        location(location).
        server(server).
        ext("").
        st(uuid).
        build();
  }

  public String buildMediaRendererResponse() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.MEDIA_RENDERER)).
        location(location).
        server(server).
        ext("").
        st(UpnpHelper.MEDIA_RENDERER).
        build();
  }

  public String buildConnectionManagerResponse() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.CONNECTION_MANAGER)).
        location(location).
        server(server).
        ext("").
        st(UpnpHelper.CONNECTION_MANAGER).
        build();
  }

  public String buildRenderingControlResponse() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.RENDERING_CONTROL)).
        location(location).
        server(server).
        ext("").
        st(UpnpHelper.RENDERING_CONTROL).
        build();
  }

  public String buildAVTransportResponse() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.AV_TRANSPORT)).
        location(location).
        server(server).
        ext("").
        st(UpnpHelper.AV_TRANSPORT).
        build();
  }
}
