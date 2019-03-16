/*
 * Mintaprogramok/11. fejezet
 * AblakBecsuk.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.JFrame;
import java.awt.event.*;

public class AblakBecsuk extends JFrame {
  public AblakBecsuk() {
    setBounds(100,100,300,200);
    enableEvents(WindowEvent.WINDOW_CLOSING);
    show();
  }

  public void processWindowEvent(WindowEvent e) {
    if (e.getID()==WindowEvent.WINDOW_CLOSING)
      System.exit(0);
    super.processWindowEvent(e);
  }

  public static void main(String[] args) {
    new AblakBecsuk();
  }
} // AblakBecsuk
