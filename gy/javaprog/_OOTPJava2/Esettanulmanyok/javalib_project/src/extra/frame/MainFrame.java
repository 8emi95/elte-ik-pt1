/*
 * javalib k�nyvt�r
 *
 * Csomag: extra.frame
 * MainFrame.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Ha becsukj�k a keretet, akkor a megszakad a program.
 */

package extra.frame;

import javax.swing.JFrame;
import java.awt.event.*;

public class MainFrame extends JFrame {
  public MainFrame(String title) {
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
  public MainFrame() {
    this("");
  }
}

