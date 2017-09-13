package io.neocdtv.upnp.helpers;

/**
 * Created by xix on 11.09.17.
 */
public class UpnpResponseBuilder {

  private final static String NEW_LINE = "\r\n";
  private final StringBuffer response;

  private UpnpResponseBuilder() {
    response = new StringBuffer();
    response.
        append("HTTP/1.1 200 OK").
        append(NEW_LINE);
  }

  public static UpnpResponseBuilder ok() {
    return new UpnpResponseBuilder();
  }

  public UpnpResponseBuilder usn(final String usn) {
    addHeader(SsdpHelper.HTTP_HEADER_NAME_UNIQUE_SERVICE_NAME, usn);
    return this;
  }

  public UpnpResponseBuilder cacheControl(final String cacheControl) {
    addHeader(HttpHelper.HTTP_HEADER_NAME_CACHE_CONTROL, cacheControl);
    return this;
  }

  public UpnpResponseBuilder location(final String location) {
    addHeader(HttpHelper.HTTP_HEADER_NAME_LOCATION, location);
    return this;
  }

  public UpnpResponseBuilder server(final String server) {
    addHeader(HttpHelper.HTTP_HEADER_NAME_SERVER, server);
    return this;
  }

  public UpnpResponseBuilder ext(final String ext) {
    addHeader(UpnpHelper.EXT, ext);
    return this;
  }

  public UpnpResponseBuilder st(final String st) {
    addHeader(UpnpHelper.ST, st);
    return this;
  }


  public String build() {
    return response.
        append(NEW_LINE).
        toString();
  }

  public void addHeader(final String name, final String value) {
    response.
        append(name).
        append(": ").
        append(value).
        append(NEW_LINE);
  }
}
