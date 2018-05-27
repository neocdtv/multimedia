package io.neocdtv.upnp;

import java.util.logging.Logger;

/**
 * Created by xix on 22.11.17.
 */
public class EventsHandlerDefault implements EventsHandler {

  private final static Logger LOGGER = Logger.getLogger(EventsHandlerDefault.class.getName());

  @Override
  public void onDeviceDiscovery(String address, String name) {
    LOGGER.info("discovered...");
  }
}
