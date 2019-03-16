/*
 * Mintaprogramok/8. fejezet
 * ColorChooserTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooserTest extends JFrame
                              implements ActionListener {
  private JButton btSzin = new JButton("Színválasztás");
  private Color color;

  public ColorChooserTest() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(btSzin);
    btSzin.addActionListener(this);
    color = btSzin.getBackground();

    pack();
    show();
  }

  public void actionPerformed(ActionEvent ev) {
    color = JColorChooser.showDialog(this,"A gomb színe...",color);
    if (color != null)
      btSzin.setBackground(color);
  }

  public static void main(String[] args) {
    new ColorChooserTest();
  }
}
