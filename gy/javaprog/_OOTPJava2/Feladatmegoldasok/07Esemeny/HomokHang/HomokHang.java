/*
 * Feladatmegoldások/7. fejezet
 * HomokHang.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomokHang extends JFrame {

  class Homok extends MouseAdapter {
    // Az egér a komponens fölé került:
    public void mouseEntered(MouseEvent ev) {
      setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }
  }

  class Hang extends ComponentAdapter {
    // A komponenst elmozdították:
    public void componentMoved(ComponentEvent ev) {
      Toolkit.getDefaultToolkit().beep();
    }
  }

  public HomokHang() {
    setTitle("HomokHang");
    setBounds(300,200,500,100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    addMouseListener(new Homok());
    addComponentListener(new Hang());
    show();
  }

  public static void main(String[] args) {
    new HomokHang();
  }
}
