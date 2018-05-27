package io.neocdtv.upnp.helpers;

/**
 * Created by xix on 11.09.17.
 */
public class UpnpRequestBuilder {

  private final static String NEW_LINE = "\r\n";
  private final StringBuffer response;

  private UpnpRequestBuilder() {
    response = new StringBuffer();
    response.
        append(GenaConstants.HTTP_METHOD_NOTIFY).
        append("* HTTP/1.1").
        append(NEW_LINE);
  }

  public static UpnpRequestBuilder notifyRequest() {
    return new UpnpRequestBuilder();
  }

  public UpnpRequestBuilder usn(final String usn) {
    addHeader(SsdpConstants.HTTP_HEADER_NAME_UNIQUE_SERVICE_NAME, usn);
    return this;
  }

  public UpnpRequestBuilder host(final String host) {
    addHeader(HttpConstants.HTTP_HEADER_NAME_HOST, host);
    return this;
  }

  public UpnpRequestBuilder cacheControl(final String cacheControl) {
    addHeader(HttpConstants.HTTP_HEADER_NAME_CACHE_CONTROL, cacheControl);
    return this;
  }

  public UpnpRequestBuilder location(final String location) {
    addHeader(HttpConstants.HTTP_HEADER_NAME_LOCATION, location);
    return this;
  }

  public UpnpRequestBuilder server(final String server) {
    addHeader(HttpConstants.HTTP_HEADER_NAME_SERVER, server);
    return this;
  }

  public UpnpRequestBuilder nt(final String nt) {
    addHeader(GenaConstants.HTTP_HEADER_NAME_NOTIFICATION_TYPE, nt);
    return this;
  }

  public UpnpRequestBuilder st(final String st) {
    addHeader(UpnpHelper.ST, st);
    return this;
  }

  public UpnpRequestBuilder mx(final String mx) {
    addHeader(UpnpHelper.MX, mx);
    return this;
  }

  public UpnpRequestBuilder man(final String man) {
    addHeader(UpnpHelper.MAN, man);
    return this;
  }

  public UpnpRequestBuilder nts(final String st) {
    addHeader(GenaConstants.HTTP_HEADER_NAME_NOTIFICATION_SUB_TYPE, st);
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
