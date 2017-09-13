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
        append(GenaHelper.HTTP_METHOD_NOTIFY).
        append("* HTTP/1.1").
        append(NEW_LINE);
  }

  public static UpnpRequestBuilder notifyRequest() {
    return new UpnpRequestBuilder();
  }

  public UpnpRequestBuilder usn(final String usn) {
    addHeader(SsdpHelper.HTTP_HEADER_NAME_UNIQUE_SERVICE_NAME, usn);
    return this;
  }

  public UpnpRequestBuilder host(final String host) {
    addHeader(SsdpHelper.HTTP_HEADER_NAME_UNIQUE_SERVICE_NAME, host);
    return this;
  }

  public UpnpRequestBuilder cacheControl(final String cacheControl) {
    addHeader(HttpHelper.HTTP_HEADER_NAME_CACHE_CONTROL, cacheControl);
    return this;
  }

  public UpnpRequestBuilder location(final String location) {
    addHeader(HttpHelper.HTTP_HEADER_NAME_LOCATION, location);
    return this;
  }

  public UpnpRequestBuilder server(final String server) {
    addHeader(HttpHelper.HTTP_HEADER_NAME_SERVER, server);
    return this;
  }

  public UpnpRequestBuilder nt(final String ext) {
    addHeader(GenaHelper.HTTP_HEADER_NAME_NOTIFICATION_TYPE, ext);
    return this;
  }

  public UpnpRequestBuilder nts(final String st) {
    addHeader(GenaHelper.HTTP_HEADER_NAME_NOTIFICATION_SUB_TYPE, st);
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
