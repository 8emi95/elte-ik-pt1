/*
 * Feladatmegoldások/12. fejezet
 * Projekt: hangtaps
 * HangTaps.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import java.applet.*;
import java.io.*;
import java.net.URL;

public class HangTaps {
  public static void main(String[] args) {
    try {
      AudioClip hang;
      String fName = new File("c:/javaprog/sounds/taps.wav").getAbsolutePath();
      Applet.newAudioClip(new URL("file:///"+fName)).play();
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
