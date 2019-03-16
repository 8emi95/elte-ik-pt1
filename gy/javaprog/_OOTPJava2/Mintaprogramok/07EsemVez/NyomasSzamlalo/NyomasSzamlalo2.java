/*
 * Mintaprogramok/7. fejezet
 * NyomasSzamlalo2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SzamlaloGomb extends JButton implements ActionListener {
  private int szamlalo;

  public SzamlaloGomb() {
    this(0);
  }

  public SzamlaloGomb(int szamlalo) {
    this.szamlalo=szamlalo;
    setText(szamlalo+"");
    addActionListener(this);
  }

  public void actionPerformed(ActionEvent ev) {
    szamlalo++;
    setText(szamlalo+"");
  }
}

public class NyomasSzamlalo2 extends JFrame {
  Container cp=getContentPane();

  public NyomasSzamlalo2() {
    setLocation(200,200);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.setLayout(new GridLayout());
    cp.add(new SzamlaloGomb(0));
    cp.add(new SzamlaloGomb(0));
    pack();
    show();
  }

  public static void main (String args[]) {
    new NyomasSzamlalo2();
  }
}
