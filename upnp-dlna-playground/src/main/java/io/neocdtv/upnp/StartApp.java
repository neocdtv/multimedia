package io.neocdtv.upnp;

/**
 * Created by xix on 11.09.17.
 */
public class StartApp {
  public static void main(String[] args) {
    new UpnpResponseToDiscover().start();
    Grizzly.start();
  }
}
