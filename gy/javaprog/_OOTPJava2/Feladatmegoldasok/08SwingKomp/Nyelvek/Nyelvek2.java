/*
 * Feladatmegoldások/8. fejezet
 * Nyelvek2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NyelvekFrame extends JFrame implements ActionListener {
  Container cp = getContentPane();
  String[] nyelvek = {"Angol","Magyar","Kínai","Német","Szlovák"};
  ButtonGroup nyelvCsoport = new ButtonGroup();
  JRadioButton[] cbNyelvek;
  JLabel lbNyelvek;

  public NyelvekFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Nyelvek");
    setLocation(200,200);
    cp.add(lbNyelvek = new JLabel(" ",JLabel.CENTER));

    JPanel pnNyelvek = new JPanel();
    cbNyelvek = new JRadioButton[nyelvek.length];
    for (int i=0; i<nyelvek.length; i++) {
      cbNyelvek[i] = new JRadioButton(nyelvek[i]);
      nyelvCsoport.add(cbNyelvek[i]);
      pnNyelvek.add(cbNyelvek[i]);
      cbNyelvek[i].addActionListener(this);
    }
    cp.add(pnNyelvek,"South");

    pack();
    show();
  }

  public void actionPerformed(ActionEvent ev) {
    JRadioButton rb = (JRadioButton)ev.getSource();
    lbNyelvek.setText(rb.getText());
  }
}

public class Nyelvek2 {
  public static void main (String args[]) {
    new NyelvekFrame();
  }
}
