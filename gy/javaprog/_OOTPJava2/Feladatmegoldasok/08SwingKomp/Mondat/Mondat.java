/*
 * Feladatmegold�sok/8. fejezet
 * Mondat.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (A): K�sz�tsen egy mondat�ssze�ll�t� alkalmaz�st!
 * Tegyen a keretbe k�t kombin�lt list�t: az els�b�l egy keresztnevet
 * lehet v�lasztani, a m�sodikb�l pedig egy ig�t. Jelenjen meg a
 * k�vetkez� mondat a keretben az aktu�lis kiv�laszt�st�l f�gg�en:
 * <KERESZTN�V>! Menj el sz�pen <IGE>!
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
    cbNev.addItem("Zs�fi");
    cbNev.addItem("Kati");
    cbNev.addActionListener(this);

    cbIge.addItem("enni");
    cbIge.addItem("aludni");
    cbIge.addItem("k�rty�zni");
    cbIge.addItem("dolgozni");
    cbIge.addItem("teniszezni");
    cbIge.addActionListener(this);

    show();
    kiertekel();
  }

  void kiertekel() {
    lbMondat.setText(cbNev.getSelectedItem()+"! Menj el sz�pen "+
                     cbIge.getSelectedItem()+"!");
  }

  public void actionPerformed(ActionEvent ev) {
    kiertekel();
  }

  public static void main(String[] args) {
    new Mondat();
  }
}
