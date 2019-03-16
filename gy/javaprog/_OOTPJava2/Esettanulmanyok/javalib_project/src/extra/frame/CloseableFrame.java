/*
 * javalib könyvtár
 *
 * Csomag: extra.frame
 * CloseableFrame.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Ha becsukják a keretet, akkor a keretet felszabadítja.
 * Ha ez volt az utolsó keret, akkor megszakad a program.
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
        // Felszabadítja az keretet:
        dispose();
        // Ha nincs már több keret, akkor megszakítja a programot:
        if (!vanMegKeret())
          System.exit(0);
      }
    });
  }
  public CloseableFrame() {
    this("");
  }

  // Megvizsgálja, hogy van-e még megjeleníthetõ keret az alkalmazásban:
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
