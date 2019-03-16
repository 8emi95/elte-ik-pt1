/*
 * Mintaprogramok/12. fejezet
 * Projekt: parametertest
 * ParameterTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;

public class ParameterTest extends JApplet {
  int r, g, b;
  JLabel lbSzoveg = new JLabel();

  public void init() {
    try {
      // Futtatási paraméterek: szoveg, x, y
      lbSzoveg.setText(getParameter("szoveg"));
      r = Integer.parseInt(getParameter("r"));
      g = Integer.parseInt(getParameter("g"));
      b = Integer.parseInt(getParameter("b"));
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,
         "Adja meg a szöveg és a szín (rgb) paramétereket!");
    }
    lbSzoveg.setFont(new Font("Serif",Font.PLAIN,40));
    lbSzoveg.setForeground(new Color(r,g,b));
    getContentPane().add(lbSzoveg);
  }
}
