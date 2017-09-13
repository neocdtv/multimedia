package io.neocdtv.upnp.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Logger;

/**
 * Class that controls "slave" MPlayer instances.
 *
 * @author Matt
 */
public class MPlayer implements BasicPlayer {


  /**
   * Log used to display messaes to the console
   */
  private static Logger log = Logger.getLogger(BasicPlayer.class.getName());

  /**
   * Process that is controlling MPlayer
   */
  Process mPlayer = null;

  /**
   * Print Stream for writing commands to MPlayer
   */
  PrintStream mPlayerStream;

  /**
   * Get Stream Response from MPlayer
   */
  BufferedReader mPlayerResponse = null;

  /**
   * Path for the media
   */
  String mediaPath;

  /**
   * Clean up any process we've left behind.
   */
  protected Thread cleanupThread = new Thread() {
    public void run() {
      cleanup();
    }
  };

  /**
   * Simple test method.
   *
   * @param args
   * @throws PlayerException
   * @throws InterruptedException
   */

  public static void main(String[] args) throws PlayerException, InterruptedException {
    MPlayer player = new MPlayer("http://192.168.35.9:5000/webman/3rdparty/AudioStation/webUI/audiotransfer.cgi/b94043b978f2343c2a.flac");
    player.play();
    Thread.sleep(10000);
    player.stop();

  }

  /**
   * Create a new MPlayer
   *
   * @param mediaPath
   * @throws PlayerException
   */
  public MPlayer(String mediaPath) throws PlayerException {
    try {
      mPlayer = Runtime.getRuntime().exec("/usr/bin/mplayer -slave -quiet -idle ");
      mPlayerStream = new PrintStream(mPlayer.getOutputStream());
      mPlayerResponse = new BufferedReader(new InputStreamReader(mPlayer.getInputStream()));
      this.mediaPath = mediaPath;
      Runtime.getRuntime().addShutdownHook(cleanupThread);
      log.info("New MPlayer player ready.");
    } catch (IOException e) {
      log.warning("Unable to create MPlayer instance.");
      throw new PlayerException("Unable to instantiate player.");
    } catch (Exception e) {
      log.severe(e.getMessage());
    }
  }

  /**
   * Clean up any process left over.
   */
  public void cleanup() {
    if (mPlayer != null) {
      mPlayer.destroy();
    }
  }

  /**
   * Send a command to the media player.  See http://www.mplayerhq.hu/DOCS/tech/slave.txt for
   * commadnds available
   *
   * @param command
   */
  private void sendCommand(String command) {
    mPlayerStream.print(command);
    mPlayerStream.print("\n");
    mPlayerStream.flush();

  }

  public void play() throws PlayerException {
    sendCommand("loadfile \"" + mediaPath + "\" 0");
    log.info("MPlayer player: play");


  }

  public void stop() throws PlayerException {
    sendCommand("stop");
    log.info("MPlayer player: stop");
  }

  public void pause() throws PlayerException {
    sendCommand("pause");
    log.info("MPlayer player: pause");

  }

  public void skip(long seconds) throws PlayerException {
    sendCommand("set_property time_pos " + seconds);
    log.info("MPlayer player: skip at " + seconds + "s");

  }

  public long getPosition() {

    sendCommand("get_property time_pos");
    String answer;
    int elapsedTime = -1;
    try {
      while ((answer = mPlayerResponse.readLine()) != null) {
        if (answer.startsWith("ANS_time_pos=")) {
          elapsedTime = Integer.parseInt(answer.substring("ANS_time_pos=".length()));
          log.info("MPlayer elapsed time: " + elapsedTime);
          break;
        }
      }
    } catch (IOException e) {
    }
    return elapsedTime;
  }

  public long getDuration() {

    sendCommand("get_property length");
    String answer;
    int totalTime = -1;
    try {
      while ((answer = mPlayerResponse.readLine()) != null) {
        if (answer.startsWith("ANS_length=")) {
          totalTime = Integer.parseInt(answer.substring("ANS_length=".length()));
          log.info("MPlayer track length: " + totalTime);
          break;
        }
      }
    } catch (IOException e) {
    }
    return totalTime;
  }

  public float getPositionPercentage() {
    sendCommand("get_property percent_pos");
    String answer;
    int percentPos = -1;
    try {
      while ((answer = mPlayerResponse.readLine()) != null) {
        if (answer.startsWith("ANS_percent_pos=")) {
          percentPos = Integer.parseInt(answer.substring("ANS_percent_pos=".length())) / 100;
          log.info("MPlayer position percent : " + percentPos);
          break;
        }
      }
    } catch (IOException e) {
    }
    return percentPos;
  }

  public String getCurrentUri() {
    return mediaPath;
  }

}
