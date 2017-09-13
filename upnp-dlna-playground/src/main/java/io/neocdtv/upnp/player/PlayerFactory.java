package io.neocdtv.upnp.player;


import io.neocdtv.upnp.helpers.PropertyHelper;

/**
 * Factory class to create a new player based on the value setup in the properties file
 * 
 * @author Matt
 *
 */
public class PlayerFactory {

	/**
	 * Get an appropriate player type based on the mediaType in the properties file
	 * @return
	 * @throws PlayerException 
	 */
	public static BasicPlayer getPlayer(String mediaPath) throws PlayerException {
		String type;
		try {
			type = PropertyHelper.getInstance().getMediaPlayer().toLowerCase();
		} catch (Exception e) {
			throw new PlayerException("Unable to load media player type from config: " + e.getMessage());
		}
		
		//Java 7 only
		switch (type) {
			case "mplayer":
				return new MPlayer(mediaPath);
			default:
				throw new PlayerException("Unknown media player type");
		}
	}
}
