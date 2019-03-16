/*
 * Mintaprogramok/7. fejezet
 * PittyegoKeret.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;                                   //1

public class PittyegoKeret extends JFrame
                           implements ActionListener {     //2
  private JButton btPittyeg = new JButton("Pittyeg");

  public PittyegoKeret() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(btPittyeg);                       //3
    btPittyeg.addActionListener(this);                     //4
    pack();
    show();
  }

  public void actionPerformed (ActionEvent ev) {           //5
    Toolkit.getDefaultToolkit().beep();                    //6
  }

  public static void main (String args[]) {
    new PittyegoKeret();
  }
}
