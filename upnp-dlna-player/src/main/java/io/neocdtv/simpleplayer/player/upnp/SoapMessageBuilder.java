/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.simpleplayer.player.upnp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 *
 * @author xix
 */
public class SoapMessageBuilder {

    private static boolean velocityInitialized = false;

    public static String buildSetUriMessage(final String uri) {
        final String templateFile = "soap/SetAVTransportURI.xml";
        initilizeVelocity();

        VelocityContext context = new VelocityContext();
        context.put("uri", uri);

        final StringWriter stringWriter = new StringWriter();

        try {
            Template template = Velocity.getTemplate(templateFile);
            try (BufferedWriter writer = new BufferedWriter(
                    stringWriter)) {
                if (template != null) {
                    template.merge(context, writer);
                }
                writer.flush();
            }
        } catch (ResourceNotFoundException rnfe) {
            System.out.println("Example : error : cannot find template " + templateFile);
        } catch (ParseErrorException pee) {
            System.out.println("Example : Syntax error in template " + templateFile + ":" + pee);
        } catch (IOException ex) {
            Logger.getLogger(SoapMessageBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringWriter.toString();
    }

    public static String buildPlayMessage() {
        return buildMessage("Play.xml");
    }

    public static String buildPauseMessage() {
        return buildMessage("Pause.xml");
    }

    public static String buildGetVolumeMessage() {
        return buildMessage("GetVolume.xml");
    }
    
    public static String buildGetTransportInfoMessage() {
        return buildMessage("GetTransportInfo.xml");
    }

    public static String buildSetVolumeMessage(final String volume) {
        final String templateFile = "soap/SetVolume.xml";
        initilizeVelocity();

        VelocityContext context = new VelocityContext();
        context.put("volume", volume);

        final StringWriter stringWriter = new StringWriter();

        try {
            Template template = Velocity.getTemplate(templateFile);
            try (BufferedWriter writer = new BufferedWriter(
                    stringWriter)) {
                if (template != null) {
                    template.merge(context, writer);
                }
                writer.flush();
            }
        } catch (ResourceNotFoundException rnfe) {
            System.out.println("Example : error : cannot find template " + templateFile);
        } catch (ParseErrorException pee) {
            System.out.println("Example : Syntax error in template " + templateFile + ":" + pee);
        } catch (IOException ex) {
            Logger.getLogger(SoapMessageBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringWriter.toString();
    }

    private static void initilizeVelocity() {
        if (!velocityInitialized) {
            java.util.Properties props = new java.util.Properties();
            props.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            props.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            props.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS, NullLogChute.class.getName());
            Velocity.init(props);
            velocityInitialized = true;
        }
    }

    private static String buildMessage(final String soapFile) {
        final String templateFile = "soap/" + soapFile;
        final InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(templateFile);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        final StringBuffer buffer = new StringBuffer();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(SoapMessageBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buffer.toString();
    }
}
