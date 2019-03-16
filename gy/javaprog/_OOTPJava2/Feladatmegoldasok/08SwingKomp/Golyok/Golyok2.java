/*
 * Feladatmegoldások/8. fejezet
 * Golyok2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Golyok2 extends JFrame implements ActionListener {
  JLabel lbPiros, lbKek, lbSarga;
  JRadioButton cbPiros, cbKek, cbSarga;
  ButtonGroup bg = new ButtonGroup();
  Container cp = this.getContentPane();

  public Golyok2() {
    setBounds(300,200,250,100);
    setTitle("Egymástól függõ golyók");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(3,1));

    JPanel pn;
    cp.add(pn = new JPanel());
    pn.setLayout(new GridLayout(1,2));
    pn.add(lbPiros = new JLabel(new ImageIcon("icons/red-ball.gif")));
    pn.add(cbPiros = new JRadioButton("Piros",true));
    cbPiros.setMnemonic(KeyEvent.VK_P);
    bg.add(cbPiros);
    cbPiros.addActionListener(this);

    cp.add(pn = new JPanel());
    pn.setLayout(new GridLayout(1,2));
    pn.add(lbKek = new JLabel(new ImageIcon("icons/blue-ball.gif")));
    pn.add(cbKek = new JRadioButton("Kék",false));
    cbKek.setMnemonic(KeyEvent.VK_K);
    bg.add(cbKek);
    cbKek.addActionListener(this);

    cp.add(pn = new JPanel());
    pn.setLayout(new GridLayout(1,2));
    pn.add(lbSarga = new JLabel(new ImageIcon("icons/yellow-ball.gif")));
    pn.add(cbSarga = new JRadioButton("Sárga",false));
    cbSarga.setMnemonic(KeyEvent.VK_S);
    bg.add(cbSarga);
    cbSarga.addActionListener(this);
    // A cimkék láthatóságának beállítása:
    actionPerformed(new ActionEvent(cbPiros,ActionEvent.ACTION_PERFORMED,""));

    show();
  }

  public void actionPerformed(ActionEvent ev) {
    lbPiros.setVisible(cbPiros.isSelected());
    lbKek.setVisible(cbKek.isSelected());
    lbSarga.setVisible(cbSarga.isSelected());
  }

  public static void main(String[] args) {
    new Golyok2();
  }
}
