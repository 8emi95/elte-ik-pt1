/*
 * Feladatmegoldások/5. fejezet
 * CimkeGomb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class CimkeGomb extends JFrame {
  private Container cp = getContentPane();
  private JLabel lb = new JLabel("Címke");
  private JButton bt = new JButton("Gomb");

  public CimkeGomb() {
    setLocation (200,200);
    // Ha becsukják ezt az ablakot, akkor vége lesz a programnak:
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cp.setLayout(new FlowLayout());
    cp.add(lb);
    cp.add(bt);

    pack();
    show();
  }

  public static void main (String args[]) {
    new CimkeGomb();
  }
}
