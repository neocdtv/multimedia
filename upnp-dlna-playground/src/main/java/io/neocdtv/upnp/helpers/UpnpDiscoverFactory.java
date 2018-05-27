package io.neocdtv.upnp.helpers;

/**
 * Created by xix on 11.09.17.
 */
public class UpnpDiscoverFactory {

  private final String address;
  private final int port;

  public UpnpDiscoverFactory(final String address, final int port) {
    this.address = address;
    this.port = port;
  }

  public String buildRootDiscoveryRequest() {
    return UpnpRequestBuilder.notifyRequest().
        cacheControl(HttpConstants.HTTP_HEADER_VALUE_NO_CACHE).
        st(UpnpHelper.ROOT_DEVICE).
        mx("3").// TODO: what does the 3 means?
        man(SsdpConstants.SSDP_DISCOVER).
        host(address + ":" + port).
        build();
  }
}
