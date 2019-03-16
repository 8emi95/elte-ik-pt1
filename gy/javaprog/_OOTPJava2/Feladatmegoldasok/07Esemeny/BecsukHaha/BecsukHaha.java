/*
 * Feladatmegoldások/7. fejezet
 * BecsukHaha.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BecsukHaha extends JFrame implements ActionListener {
  JButton btHa = new JButton("ha");

  public BecsukHaha() {
    setTitle("Haha");
    setBounds(300,200,500,100);
    getContentPane().add(btHa);
    btHa.addActionListener(this);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent ev) {
        System.exit(0);
      }
    });
    show();
  }

  public void actionPerformed(ActionEvent ev) {
    setTitle(getTitle()+"ha");
  }

  public static void main(String[] args) {
    new BecsukHaha();
  }
}
