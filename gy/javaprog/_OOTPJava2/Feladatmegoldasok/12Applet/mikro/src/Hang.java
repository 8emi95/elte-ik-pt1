/*
 * Feladatmegoldások/12. fejezet
 * Projekt: mikro
 * Hang.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.io.File;

/**
 * <p>Egy adott hangot lejátszik, vagy folyamatosan szólaltatja.</p>
 * <p>A hangot le lehet állítani.</p>
 * @author Angster Erzsébet
 * @version 1.0
 */

public class Hang {
  private String absName = null;
  private AudioClip hang = null;

  /** Létrehozza hangot. A hangot a fájl nevével adjuk meg. */
  public Hang(String fNev) {
    absName = new File(fNev).getAbsolutePath();
    try {
      hang = Applet.newAudioClip(new URL("file:///" + absName));
    }
    catch(Exception ex) {
    }
  }

  /** Létrehozza hangot. A hangot a fájl URL-jével adjuk meg. */
  public Hang(URL url) {
    try {
      hang = Applet.newAudioClip(url);
    }
    catch(Exception ex) {
    }
  }

  /** Lejátsza a hangot. */
  public void lejatszik() {
    hang.play();
  }

  /** Folyamatosan szólaltatja a hangot. */
  public void szol(){
    hang.loop();
  }

  /** Elhallgattatja a hangot. */
  public void elhallgat() {
    hang.stop();
  }
}
