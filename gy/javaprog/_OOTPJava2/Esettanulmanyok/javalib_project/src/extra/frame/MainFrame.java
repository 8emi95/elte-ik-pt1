/*
 * javalib könyvtár
 *
 * Csomag: extra.frame
 * MainFrame.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Ha becsukják a keretet, akkor a megszakad a program.
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

