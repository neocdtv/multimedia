/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.simpleplayer.player.upnp;

import io.neocdtv.simpleplayer.player.PlayerState;
import io.neocdtv.simpleplayer.worker.PlayNextWorker;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xix
 */
public class MediaStatusUpdateHandler implements MediaStatusUpdateListener {

    private final static Logger LOGGER = Logger.getLogger(MediaStatusUpdateHandler.class.getName());

    @Override
    public void handleEvent(MediaStatusUpdateEvent mediaStatusUpdateEvent) {
        LOGGER.log(Level.INFO, "handling media status update event...");
        if (PlayerState.getInstance().isInStatePlaying() && !mediaStatusUpdateEvent.isPlaying()) {
            new PlayNextWorker().execute();
        }
    }

}
