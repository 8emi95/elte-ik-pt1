/*
 * Mintaprogramok/12. fejezet
 * Projekt: parametertest
 * ParameterTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;

public class ParameterTest extends JApplet {
  int r, g, b;
  JLabel lbSzoveg = new JLabel();

  public void init() {
    try {
      // Futtat�si param�terek: szoveg, x, y
      lbSzoveg.setText(getParameter("szoveg"));
      r = Integer.parseInt(getParameter("r"));
      g = Integer.parseInt(getParameter("g"));
      b = Integer.parseInt(getParameter("b"));
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,
         "Adja meg a sz�veg �s a sz�n (rgb) param�tereket!");
    }
    lbSzoveg.setFont(new Font("Serif",Font.PLAIN,40));
    lbSzoveg.setForeground(new Color(r,g,b));
    getContentPane().add(lbSzoveg);
  }
}
