/*
 * Feladatmegoldások/6. fejezet
 * GombokJelolok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;

class GombokJelolok extends JFrame {
  Container cp = getContentPane();

  public GombokJelolok() {
    setTitle("Gombok, jelölõnégyzetek");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new FlowLayout(FlowLayout.LEFT));

    Component comp;
    for (char c='A'; c<='F'; c++) {
      cp.add(comp = new JButton(""+c));
      comp.setBackground(Color.orange);
      cp.add(comp = new Checkbox("Elintézve"));
      comp.setBackground(SystemColor.control);
    }

    pack();
    show();
  }

  public static void main (String args[]) {
    new GombokJelolok();
  }
}

