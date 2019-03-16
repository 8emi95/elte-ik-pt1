/*
 * Feladatmegoldások/8. fejezet
 * Golyok1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Golyok1 extends JFrame implements ActionListener {
  JLabel lbPiros, lbKek, lbSarga;
  JCheckBox cbPiros, cbKek, cbSarga;
  Container cp = this.getContentPane();

  public Golyok1() {
    setBounds(300,200,250,100);
    setTitle("Független golyók");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(3,1));

    JPanel pn;
    cp.add(pn = new JPanel());
    pn.setLayout(new GridLayout(1,2));
    pn.add(lbPiros = new JLabel(new ImageIcon("icons/red-ball.gif")));
    pn.add(cbPiros = new JCheckBox("Piros",true));
    cbPiros.setMnemonic(KeyEvent.VK_P);
    cbPiros.addActionListener(this);

    cp.add(pn = new JPanel());
    pn.setLayout(new GridLayout(1,2));
    pn.add(lbKek = new JLabel(new ImageIcon("icons/blue-ball.gif")));
    pn.add(cbKek = new JCheckBox("Kék",true));
    cbKek.setMnemonic(KeyEvent.VK_K);
    cbKek.addActionListener(this);

    cp.add(pn = new JPanel());
    pn.setLayout(new GridLayout(1,2));
    pn.add(lbSarga = new JLabel(new ImageIcon("icons/yellow-ball.gif")));
    pn.add(cbSarga = new JCheckBox("Sárga",true));
    cbSarga.setMnemonic(KeyEvent.VK_S);
    cbSarga.addActionListener(this);

    show();
  }

  public void actionPerformed(ActionEvent ev) {
    JCheckBox cb = (JCheckBox)ev.getSource();
    lbPiros.setVisible(cbPiros.isSelected());
    lbKek.setVisible(cbKek.isSelected());
    lbSarga.setVisible(cbSarga.isSelected());
  }

  public static void main(String[] args) {
    new Golyok1();
  }
}
