/*
 * Feladatmegoldások/8. fejezet
 * Meretezhetoseg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Meretezhetoseg extends JFrame implements ActionListener {
  Container cp = this.getContentPane();
  JRadioButton rbIgen, rbNem;
  ButtonGroup bg = new ButtonGroup();

  public Meretezhetoseg() {
    setLocation(300,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setLayout(new FlowLayout());

    cp.add(new JLabel("A keret méretezhetõ?"));
    cp.add(rbIgen = new JRadioButton("Igen",true));
    bg.add(rbIgen);
    cp.add(rbNem = new JRadioButton("Nem"));
    bg.add(rbNem);
    rbIgen.addActionListener(this);
    rbNem.addActionListener(this);
    pack();
    show();
  }

  public void actionPerformed(ActionEvent ev) {
    setResizable(ev.getSource()==rbIgen);
  }

  public static void main(String[] args) {
    new Meretezhetoseg();
  }
}

