/*
 * Feladatmegold�sok/8. fejezet
 * Projekt: SzinKeveres
 * SzinKeveresApp.java (f�oszt�ly)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (A): K�sz�tsen egy sz�nkever� alkalmaz�st! Az RGB sz�neket
 * a keret als� r�sz�n lev� h�rom g�rget�s�v seg�ts�g�vel lehet �ll�tani.
 * A keret fels� r�sz�nek sz�ne mindig a kikevert sz�n legyen!
 */

import java.awt.*;

public class SzinKeveresApp {

  public SzinKeveresApp() {
    SzinKeveresFrame frame = new SzinKeveresFrame();

    // Keret k�z�pre:
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
