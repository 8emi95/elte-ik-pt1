/*
 * Mintaprogramok/7. fejezet
 * PittyegKiir.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Kiiro implements ActionListener {                    //1
  public void actionPerformed (ActionEvent ev) {           //2
    System.out.println("Lenyomták a gombot.");
  }
}

public class PittyegKiir extends JFrame
                         implements ActionListener {       //3
  private JButton btPittyeg;

  public PittyegKiir() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(btPittyeg = new JButton("Pittyeg"));
    btPittyeg.addActionListener(this);                     //4
    btPittyeg.addActionListener(new Kiiro());              //5
    pack();
    show();
  }

  public void actionPerformed (ActionEvent ev) {           //6
    Toolkit.getDefaultToolkit().beep();                    //7
  }

  public static void main (String args[]) {
    new PittyegKiir();
  }
}
