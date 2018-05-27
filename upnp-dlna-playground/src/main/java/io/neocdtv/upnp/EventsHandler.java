package io.neocdtv.upnp;

/**
 * Created by xix on 22.11.17.
 */
public interface EventsHandler {
  void onDeviceDiscovery(final String address, final String name);
}
