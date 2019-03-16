/*
 * Feladatmegoldások/8. fejezet
 * Mondat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (A): Készítsen egy mondatösszeállító alkalmazást!
 * Tegyen a keretbe két kombinált listát: az elsõbõl egy keresztnevet
 * lehet választani, a másodikból pedig egy igét. Jelenjen meg a
 * következõ mondat a keretben az aktuális kiválasztástól függõen:
 * <KERESZTNÉV>! Menj el szépen <IGE>!
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mondat extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private JPanel pnValaszt = new JPanel();
  private JLabel lbMondat = new JLabel("",JLabel.CENTER);

  private JComboBox cbNev = new JComboBox();
  private JComboBox cbIge = new JComboBox();

  public Mondat() {
    setBounds(300,200,400,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));
    cp.add(pnValaszt);
    lbMondat.setFont(new Font("Arial",Font.PLAIN,20));
    cp.add(lbMondat);
    pnValaszt.add(cbNev);
    pnValaszt.add(cbIge);

    cbNev.addItem("Laci");
    cbNev.addItem("Erzsi");
    cbNev.addItem("Zsófi");
    cbNev.addItem("Kati");
    cbNev.addActionListener(this);

    cbIge.addItem("enni");
    cbIge.addItem("aludni");
    cbIge.addItem("kártyázni");
    cbIge.addItem("dolgozni");
    cbIge.addItem("teniszezni");
    cbIge.addActionListener(this);

    show();
    kiertekel();
  }

  void kiertekel() {
    lbMondat.setText(cbNev.getSelectedItem()+"! Menj el szépen "+
                     cbIge.getSelectedItem()+"!");
  }

  public void actionPerformed(ActionEvent ev) {
    kiertekel();
  }

  public static void main(String[] args) {
    new Mondat();
  }
}
