/*
 * Feladatmegoldások/12. fejezet
 * Projekt: colorchoosertest
 * ColorChooserTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooserTest extends JApplet
                              implements ActionListener {
  private JButton btSzin;
  private Color color;

  public ColorChooserTest() {
    btSzin = new JButton("Színválasztás");
    getContentPane().add(btSzin);
    btSzin.setOpaque(true);
    btSzin.addActionListener(this);
    color = btSzin.getBackground();
  }

  public void actionPerformed(ActionEvent ev) {
    color = JColorChooser.showDialog(this,"A gomb színe...",color);
    if (color != null)
      btSzin.setBackground(color);
  }
}
