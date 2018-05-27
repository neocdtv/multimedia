package io.neocdtv.upnp.helpers;

/**
 * Created by xix on 11.09.17.
 */
public class UpnpNotifyFactory {

  private final String uuid;
  private final String server;
  private final String location;

  public UpnpNotifyFactory(final String uuid, final String server, String location) {
    this.uuid = uuid;
    this.server = server;
    this.location = location;
  }

  public static UpnpNotifyFactory create(final String uuid, final String server, final String location) {
    return new UpnpNotifyFactory(uuid, server, location);
  }

  public String buildRootDeviceNotifyRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        host(SsdpConstants.MULTICAST_ADDRESS).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.ROOT_DEVICE)).
        location(location).
        server(server).
        nt(UpnpHelper.buildNt(uuid, UpnpHelper.ROOT_DEVICE)).
        nts(UpnpHelper.UPNP_ALIVE).
        build();
  }

  public String buildPlainNotifyRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        host(SsdpConstants.MULTICAST_ADDRESS).
        usn(uuid).
        location(location).
        server(server).
        nt(uuid).
        nts(UpnpHelper.UPNP_ALIVE).
        build();
  }

  public String buildMediaRendererNotifyRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        host(SsdpConstants.MULTICAST_ADDRESS).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.MEDIA_RENDERER)).
        location(location).
        server(server).
        nt(UpnpHelper.MEDIA_RENDERER).
        nts(UpnpHelper.UPNP_ALIVE).
        build();
  }

  public String buildConnectionManagerNotifyRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        host(SsdpConstants.MULTICAST_ADDRESS).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.CONNECTION_MANAGER)).
        location(location).
        server(server).
        nt(UpnpHelper.CONNECTION_MANAGER).
        nts(UpnpHelper.UPNP_ALIVE).
        build();
  }

  public String buildRenderingControlDiscoveryResponse() {
    return UpnpResponseBuilder.ok().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        usn(UpnpHelper.buildUsn(uuid, UpnpHelper.RENDERING_CONTROL)).
        location(location).
        server(server).
        ext("").
        st(UpnpHelper.RENDERING_CONTROL).
        build();
  }

  public String buildAVTransportNotifyDiscoveryResponse() {
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
