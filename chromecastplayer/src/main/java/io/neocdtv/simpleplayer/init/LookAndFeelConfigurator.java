/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.simpleplayer.init;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author xix
 */
public class LookAndFeelConfigurator {

    private final static Logger LOGGER = Logger.getLogger(LookAndFeelConfigurator.class.getName());
    private static final String LOOK_AND_FEEL_CLASS_NAME_GTK = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    private static final String LOOK_AND_FEEL_CLASS_NAME_WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    private static final String LOOK_AND_FEEL_CLASS_NAME_MACINTOSH = "com.sun.java.swing.plaf.mac.MacLookAndFeel";

    private static final List<String> LOOK_AND_FEEL_NATIVE_CLASSES
            = Arrays.asList(LOOK_AND_FEEL_CLASS_NAME_GTK,
                    LOOK_AND_FEEL_CLASS_NAME_WINDOWS,
                    LOOK_AND_FEEL_CLASS_NAME_MACINTOSH);

    public static void configure() {
        LOGGER.log(Level.INFO, "configuring look and feel");
        try {
            UIManager.setLookAndFeel(determineNativeLookAndFeel());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private static String determineNativeLookAndFeel() {
        String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();

        for (UIManager.LookAndFeelInfo installedLookAndFeel : Arrays.asList(UIManager.getInstalledLookAndFeels())) {
            if (LOOK_AND_FEEL_NATIVE_CLASSES.contains(installedLookAndFeel.getClassName())) {
                lookAndFeel = installedLookAndFeel.getClassName();
                break;
            }
        }
        LOGGER.log(Level.INFO, "configured look and feel: {0}", lookAndFeel);
        return lookAndFeel;
    }
}
