/*
 * Mintaprogramok/12. fejezet
 * AudioClipTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.URL;

public class AudioClipTest {
  public static void main(String[] args) {
    try {
      AudioClip hang;
      hang = Applet.newAudioClip(
             new URL("file:///c:/windows/Media/ringout.wav"));
      hang.play();

      // A hang relat�v �tj�b�l abszol�t �tvonalat k�sz�t�nk,
      // �s azzal k�pezz�k az URL-t:
      String fName = new File("sounds/vau.wav").getAbsolutePath();
      Applet.newAudioClip(new URL("file:///"+fName)).play();
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
