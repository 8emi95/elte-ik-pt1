/*
 * Feladatmegold�sok/7. fejezet
 * Haha.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Haha extends JFrame implements ActionListener {
  private JButton btHa = new JButton("ha");

  public Haha() {
    setTitle("Haha");
    setBounds(300,200,500,100);
    getContentPane().add(btHa);
    btHa.addActionListener(this);
    show();
  }

  public void actionPerformed(ActionEvent ev) {
    setTitle(getTitle()+"ha");
  }

  public static void main(String[] args) {
    new Haha();
  }
}
