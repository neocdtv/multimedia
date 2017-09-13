package io.neocdtv.upnp.helpers;

/**
 * Created by xix on 11.09.17.
 */
public class UpnpRequestFactory {

  private final String uuid;
  private final String server;
  private final String location;

  public UpnpRequestFactory(final String uuid, final String server, String location) {
    this.uuid = uuid;
    this.server = server;
    this.location = location;
  }

  public static UpnpRequestFactory create(final String uuid, final String server, final String location) {
    return new UpnpRequestFactory(uuid, server, location);
  }

  public String buildRootDeviceRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpHelper.HTTP_HEADER_VALUE_NO_CACHE).
        host(SsdpHelper.MULTICAST_ADDRESS).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.ROOT_DEVICE)).
        location(location).
        server(server).
        nt(UpnpHelper.buildNt(uuid, UpnpHelper.ROOT_DEVICE)).
        nts(SsdpHelper.NTS_ALIVE).
        build();
  }

  public String buildPlainRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpHelper.HTTP_HEADER_VALUE_NO_CACHE).
        host(SsdpHelper.MULTICAST_ADDRESS).
        usn(uuid).
        location(location).
        server(server).
        nt(uuid).
        nts(SsdpHelper.NTS_ALIVE).
        build();
  }

  public String buildMediaRendererRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpHelper.HTTP_HEADER_VALUE_NO_CACHE).
        host(SsdpHelper.MULTICAST_ADDRESS).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.MEDIA_RENDERER)).
        location(location).
        server(server).
        nt(UpnpHelper.MEDIA_RENDERER).
        nts(SsdpHelper.NTS_ALIVE).
        build();
  }

  public String buildConnectionManagerRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpHelper.HTTP_HEADER_VALUE_NO_CACHE).
        host(SsdpHelper.MULTICAST_ADDRESS).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.CONNECTION_MANAGER)).
        location(location).
        server(server).
        nt(UpnpHelper.CONNECTION_MANAGER).
        nts(SsdpHelper.NTS_ALIVE).
        build();
  }

  public String buildRenderingControlRequest() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpHelper.HTTP_HEADER_VALUE_NO_CACHE).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.RENDERING_CONTROL)).
        location(location).
        server(server).
        ext("").
        st(UpnpHelper.RENDERING_CONTROL).
        build();
  }


  public String buildAVTransportRequest() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpHelper.HTTP_HEADER_VALUE_NO_CACHE).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.AV_TRANSPORT)).
        location(location).
        server(server).
        ext("").
        st(UpnpHelper.AV_TRANSPORT).
        build();
  }
}
