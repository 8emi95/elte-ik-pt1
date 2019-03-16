/*
 * Feladatmegoldások/8. fejezet
 * Projekt: Muveletek.jpx
 * MuveletekApp.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (B): Készítsen egy programot, melyben el lehet végezni
 * két szám közötti tetszõleges mûveletet. A 4 alapmûvelet közül
 * egy lenyíló listából lehet választani. Ha a mûvelet nem végezhetõ
 * el, akkor az eredménymezõben a "Hiba!" szöveg jelenjen meg!
 * A keretet pontosan a képernyõ közepén helyezze el, a képernyõ
 * felbontásától függetlenül!
 */

import java.awt.*;

public class MuveletekApp {

  public MuveletekApp() {
    MuveletekFrame frame = new MuveletekFrame();
    frame.pack();

    // Keret középre:
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
