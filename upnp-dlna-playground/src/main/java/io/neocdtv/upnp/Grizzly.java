/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.upnp;

import io.neocdtv.upnp.helpers.XmlFormatter;
import org.apache.commons.io.IOUtils;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xix
 */
public class Grizzly {

  public static void main(String[] args) {
    start();
  }

  public static void start() {
    HttpServer server = HttpServer.createSimpleServer("/", 8080);
    configureMainRoute(server);
    configureAvTransport(server);
    configureConnectionManager(server);
    configureRenderingControl(server);


    try {
      server.start();
      System.out.println("Press any key to stop the server...");
      System.in.read();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  private static void configureMainRoute(HttpServer server) {
    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = loadFileFromResource("upnp/desc.xml");
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/desc.xml");
  }

  private static void configureAvTransport(HttpServer server) {
    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = loadFileFromResource("upnp/AVTransport/desc.xml");
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/AVTransport/desc.xml");

    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = "<xml></xml>";
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/AVTransport/action");

    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = "<xml>event</xml>";
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/AVTransport/event");
  }

  private static void configureConnectionManager(HttpServer server) {
    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = "<xml></xml>";
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/ConnectionManager/desc.xml");

    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = "<xml></xml>";
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/ConnectionManager/control");

    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = "<xml>event</xml>";
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/ConnectionManager/event");
  }

  private static void configureRenderingControl(HttpServer server) {
    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = "<xml></xml>";
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/ConnectionManager/desc.xml");

    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = "<xml></xml>";
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/RenderingControl/control");

    server.getServerConfiguration().addHttpHandler(
        new HttpHandler() {
          public void service(Request request, Response response) throws Exception {
            logRequest(request);
            response.setContentType("text/xml");
            String body = "<xml>event</xml>";
            response.setContentLength(body.length());
            response.getWriter().write(body);
          }
        },
        "/RenderingControl/event");
  }

  private static void logRequest(Request request) throws IOException {
    String body = IOUtils.toString(request.getInputStream(), "UTF-8");
    if (body.length() > 0) {
      body = XmlFormatter.prettyFormat(body);
    }
    String requestCall = request.getMethod().getMethodString() + " " + request.getRequestURL();
    System.out.println(requestCall + "\r\n" + body);
  }

  private static String loadFileFromResource(final String relativePath) throws IOException {
    InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(relativePath);
    return IOUtils.toString(resourceAsStream, "UTF-8");
  }
}
