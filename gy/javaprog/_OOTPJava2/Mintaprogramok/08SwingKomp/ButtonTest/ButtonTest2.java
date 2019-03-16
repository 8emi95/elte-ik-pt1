/*
 * Mintaprogramok/8. fejezet
 * ButtonTest2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SzinesPanel extends JPanel implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Piros"))              //1
      setBackground(Color.RED);
    else if (e.getActionCommand().equals("Fehér"))
      setBackground(Color.WHITE);
    else if (e.getActionCommand().equals("Zöld"))
      setBackground(Color.GREEN);
  }
}

class SzinvalasztFrame extends JFrame implements ActionListener {
  Container cp = getContentPane();
  JButton btPiros, btFeher, btZold, btKilep;
  SzinesPanel pnSzin;
  JLabel lbSzoveg;

  public SzinvalasztFrame() {
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setTitle("Színválasztás");
    cp.add(pnSzin = new SzinesPanel(),"North");
    pnSzin.setBackground(Color.RED);
    lbSzoveg = new JLabel(" Válassz színt! ",JLabel.CENTER);
    lbSzoveg.setBackground(Color.WHITE);
    lbSzoveg.setOpaque(true);
    lbSzoveg.setBorder(BorderFactory.createRaisedBevelBorder());
    pnSzin.add(lbSzoveg);

    JPanel pnGombok = new JPanel();
    pnGombok.add(btPiros = new JButton("Piros"));
    pnGombok.add(btFeher = new JButton("Fehér"));
    pnGombok.add(btZold = new JButton("Zöld"));
    pnGombok.add(btKilep = new JButton("Kilép"));
    cp.add(pnGombok,"South");

    btPiros.addActionListener(pnSzin);
    btFeher.addActionListener(pnSzin);
    btZold.addActionListener(pnSzin);
    btKilep.addActionListener(this);
    pack();
    show();
  }

  public void actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}

public class ButtonTest2 {
  public static void main(String[] args) {
    new SzinvalasztFrame();
  }
}
