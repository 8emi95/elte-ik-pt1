/*
 * Feladatmegold�sok/5. fejezet
 * CimkeGomb.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class CimkeGomb extends JFrame {
  private Container cp = getContentPane();
  private JLabel lb = new JLabel("C�mke");
  private JButton bt = new JButton("Gomb");

  public CimkeGomb() {
    setLocation (200,200);
    // Ha becsukj�k ezt az ablakot, akkor v�ge lesz a programnak:
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
