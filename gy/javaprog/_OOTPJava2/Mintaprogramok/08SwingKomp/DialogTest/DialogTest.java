/*
 * Mintaprogramok/8. fejezet
 * DialogTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NevjegyDialog extends JDialog implements ActionListener {
  Container cp = getContentPane();
  JButton btOk;

  NevjegyDialog(JFrame owner) {
    super(owner,"Névjegy",true);
    setLocation(getParent().getX()+60,getParent().getY()+40);
    setResizable(false);
    cp.setBackground(SystemColor.controlHighlight);
    cp.setLayout(new GridLayout(3,1));
    cp.add(new JLabel("Tulajdonos: Okos Tóbiás",JLabel.CENTER));
    cp.add(new JLabel("Minden jog fenntartva",JLabel.CENTER));
    JPanel pnOk = new JPanel();
    cp.add(pnOk);
    pnOk.add(btOk = new JButton("OK"));
    btOk.addActionListener(this);
    pack();
    show();
  }

  public void actionPerformed(ActionEvent e) {
    dispose();
  }
}

class TestFrame extends JFrame implements ActionListener {
  Container cp = getContentPane();
  JButton btNevjegy, btKilep;

  public TestFrame() {
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setBounds(300,200,300,200);
    cp.add(new JTextArea("Ha lenyomod a Névjegy gombot, \n"+
      "akkor le kell nyomnod az OK-t.\nNincs mese..."));

    JPanel pn = new JPanel();
    pn.add(btNevjegy = new JButton("Névjegy"));
    pn.add(btKilep = new JButton("Kilép"));
    cp.add(pn,"South");

    btNevjegy.addActionListener(this);
    btKilep.addActionListener(this);
    show();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btNevjegy)
      new NevjegyDialog(this);
    else if (e.getSource() == btKilep)
      System.exit(0);
  }
}

public class DialogTest {
  public static void main (String args[]) {
    new TestFrame();
  } // main
} // DialogTest
