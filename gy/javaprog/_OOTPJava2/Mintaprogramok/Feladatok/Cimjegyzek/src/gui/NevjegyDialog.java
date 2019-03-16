/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: gui
 * NevjegyDialog.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class NevjegyDialog extends JDialog implements ActionListener {
  Container cp = getContentPane();

  NevjegyDialog(JFrame parent) {
    super(parent,"Névjegy",true);
    setLocation(parent.getX()+100,parent.getY()+100);
    JPanel pnInfo = new JPanel();
    pnInfo.setLayout(new GridLayout(3,1));
    pnInfo.setBorder(BorderFactory.createRaisedBevelBorder());

    JLabel lbProgram = new JLabel();
    lbProgram.setHorizontalAlignment(SwingConstants.CENTER);
    lbProgram.setText("    Címjegyzék    ");
    pnInfo.add(lbProgram);

    JLabel lbKeszito = new JLabel();
    lbKeszito.setHorizontalAlignment(SwingConstants.CENTER);
    lbKeszito.setText("    Copyright \u00a9 2002 Angster Erzsébet    ");
    pnInfo.add(lbKeszito);

    JLabel lbIcon = new JLabel();
    lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
    lbIcon.setIcon(new ImageIcon("icons/fox.gif"));
    pnInfo.add(lbIcon);

    JPanel pnOk = new JPanel();
    pnOk.setBorder(BorderFactory.createRaisedBevelBorder());
    JButton btOk = new JButton();
    btOk.setText("  OK  ");
    btOk.addActionListener(this);
    pnOk.add(btOk);

    cp.add(pnInfo,"Center");
    cp.add(pnOk,"South");
    pack();
  }

  public void actionPerformed(ActionEvent e) {
    setVisible(false);
  }
}
