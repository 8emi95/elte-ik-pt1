/*
 * Mintaprogramok/8. fejezet
 * ButtonTest2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SzinesPanel extends JPanel implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Piros"))              //1
      setBackground(Color.RED);
    else if (e.getActionCommand().equals("Feh�r"))
      setBackground(Color.WHITE);
    else if (e.getActionCommand().equals("Z�ld"))
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
    setTitle("Sz�nv�laszt�s");
    cp.add(pnSzin = new SzinesPanel(),"North");
    pnSzin.setBackground(Color.RED);
    lbSzoveg = new JLabel(" V�lassz sz�nt! ",JLabel.CENTER);
    lbSzoveg.setBackground(Color.WHITE);
    lbSzoveg.setOpaque(true);
    lbSzoveg.setBorder(BorderFactory.createRaisedBevelBorder());
    pnSzin.add(lbSzoveg);

    JPanel pnGombok = new JPanel();
    pnGombok.add(btPiros = new JButton("Piros"));
    pnGombok.add(btFeher = new JButton("Feh�r"));
    pnGombok.add(btZold = new JButton("Z�ld"));
    pnGombok.add(btKilep = new JButton("Kil�p"));
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
