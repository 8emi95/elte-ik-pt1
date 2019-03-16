/*
 * javalib k�nyvt�r
 *
 * Csomag: extra.frame
 * CloseableFrame.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Ha becsukj�k a keretet, akkor a keretet felszabad�tja.
 * Ha ez volt az utols� keret, akkor megszakad a program.
 */

package extra.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CloseableFrame extends JFrame {
  public CloseableFrame(String title) {
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        // Felszabad�tja az keretet:
        dispose();
        // Ha nincs m�r t�bb keret, akkor megszak�tja a programot:
        if (!vanMegKeret())
          System.exit(0);
      }
    });
  }
  public CloseableFrame() {
    this("");
  }

  // Megvizsg�lja, hogy van-e m�g megjelen�thet� keret az alkalmaz�sban:
  public boolean vanMegKeret() {
    Frame[] frames = JFrame.getFrames();
    boolean vanMegKeret = false;
    for (int i=0; i<frames.length; i++) {
      if (frames[i].isDisplayable()) {
        vanMegKeret = true;
        break;
      }
    }
    return vanMegKeret;
  } // vanMegKeret

}
