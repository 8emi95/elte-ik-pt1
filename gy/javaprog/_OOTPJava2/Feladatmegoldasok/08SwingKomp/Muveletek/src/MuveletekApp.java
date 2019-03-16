/*
 * Feladatmegold�sok/8. fejezet
 * Projekt: Muveletek.jpx
 * MuveletekApp.java (f�oszt�ly)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (B): K�sz�tsen egy programot, melyben el lehet v�gezni
 * k�t sz�m k�z�tti tetsz�leges m�veletet. A 4 alapm�velet k�z�l
 * egy leny�l� list�b�l lehet v�lasztani. Ha a m�velet nem v�gezhet�
 * el, akkor az eredm�nymez�ben a "Hiba!" sz�veg jelenjen meg!
 * A keretet pontosan a k�perny� k�zep�n helyezze el, a k�perny�
 * felbont�s�t�l f�ggetlen�l!
 */

import java.awt.*;

public class MuveletekApp {

  public MuveletekApp() {
    MuveletekFrame frame = new MuveletekFrame();
    frame.pack();

    // Keret k�z�pre:
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    frame.setLocation((screenSize.width - frameSize.width) / 2,
                    (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new MuveletekApp();
  }
}
