/*
 * Feladatmegold�sok/6. fejezet
 * GombokJelolok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;

class GombokJelolok extends JFrame {
  Container cp = getContentPane();

  public GombokJelolok() {
    setTitle("Gombok, jel�l�n�gyzetek");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new FlowLayout(FlowLayout.LEFT));

    Component comp;
    for (char c='A'; c<='F'; c++) {
      cp.add(comp = new JButton(""+c));
      comp.setBackground(Color.orange);
      cp.add(comp = new Checkbox("Elint�zve"));
      comp.setBackground(SystemColor.control);
    }

    pack();
    show();
  }

  public static void main (String args[]) {
    new GombokJelolok();
  }
}

