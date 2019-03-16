/*
 * Feladatmegoldások/8. fejezet
 * HanyszorNyomtak.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.event.*;
import extra.frame.CloseableFrame;

public class HanyszorNyomtak extends CloseableFrame implements ActionListener {
  JButton btGomb = new JButton("0");

  public HanyszorNyomtak() {
    setLocation(200,100);
    this.getContentPane().add(btGomb);
    btGomb.addActionListener(this);
    pack();
    show();
  }

  public void actionPerformed(ActionEvent ev) {
    int n = Integer.parseInt(btGomb.getText());
    n++;
    btGomb.setText(""+n);
  }

  public static void main(String[] args) {
    new HanyszorNyomtak();
  }
}

