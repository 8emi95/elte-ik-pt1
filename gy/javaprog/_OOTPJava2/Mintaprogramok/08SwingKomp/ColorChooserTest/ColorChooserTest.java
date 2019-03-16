/*
 * Mintaprogramok/8. fejezet
 * ColorChooserTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooserTest extends JFrame
                              implements ActionListener {
  private JButton btSzin = new JButton("Sz�nv�laszt�s");
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
    color = JColorChooser.showDialog(this,"A gomb sz�ne...",color);
    if (color != null)
      btSzin.setBackground(color);
  }

  public static void main(String[] args) {
    new ColorChooserTest();
  }
}
