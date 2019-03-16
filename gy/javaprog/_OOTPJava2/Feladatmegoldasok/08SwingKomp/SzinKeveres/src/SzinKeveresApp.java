/*
 * Feladatmegoldások/8. fejezet
 * Projekt: SzinKeveres
 * SzinKeveresApp.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (A): Készítsen egy színkeverõ alkalmazást! Az RGB színeket
 * a keret alsó részén levõ három görgetõsáv segítségével lehet állítani.
 * A keret felsõ részének színe mindig a kikevert szín legyen!
 */

import java.awt.*;

public class SzinKeveresApp {

  public SzinKeveresApp() {
    SzinKeveresFrame frame = new SzinKeveresFrame();

    // Keret középre:
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new SzinKeveresApp();
  }
}
