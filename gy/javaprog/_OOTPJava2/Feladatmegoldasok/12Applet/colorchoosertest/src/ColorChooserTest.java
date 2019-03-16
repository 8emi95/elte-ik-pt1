/*
 * Feladatmegold�sok/12. fejezet
 * Projekt: colorchoosertest
 * ColorChooserTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    btSzin = new JButton("Sz�nv�laszt�s");
    getContentPane().add(btSzin);
    btSzin.setOpaque(true);
    btSzin.addActionListener(this);
    color = btSzin.getBackground();
  }

  public void actionPerformed(ActionEvent ev) {
    color = JColorChooser.showDialog(this,"A gomb sz�ne...",color);
    if (color != null)
      btSzin.setBackground(color);
  }
}
