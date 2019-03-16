/*
 * Feladatmegold�sok/12. fejezet
 * Projekt: mikro
 * Hang.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.io.File;

/**
 * <p>Egy adott hangot lej�tszik, vagy folyamatosan sz�laltatja.</p>
 * <p>A hangot le lehet �ll�tani.</p>
 * @author Angster Erzs�bet
 * @version 1.0
 */

public class Hang {
  private String absName = null;
  private AudioClip hang = null;

  /** L�trehozza hangot. A hangot a f�jl nev�vel adjuk meg. */
  public Hang(String fNev) {
    absName = new File(fNev).getAbsolutePath();
    try {
      hang = Applet.newAudioClip(new URL("file:///" + absName));
    }
    catch(Exception ex) {
    }
  }

  /** L�trehozza hangot. A hangot a f�jl URL-j�vel adjuk meg. */
  public Hang(URL url) {
    try {
      hang = Applet.newAudioClip(url);
    }
    catch(Exception ex) {
    }
  }

  /** Lej�tsza a hangot. */
  public void lejatszik() {
    hang.play();
  }

  /** Folyamatosan sz�laltatja a hangot. */
  public void szol(){
    hang.loop();
  }

  /** Elhallgattatja a hangot. */
  public void elhallgat() {
    hang.stop();
  }
}
