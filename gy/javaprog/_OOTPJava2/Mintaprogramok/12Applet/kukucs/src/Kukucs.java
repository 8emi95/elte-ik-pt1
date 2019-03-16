/*
 * Mintaprogramok/12. fejezet
 * Projekt: kukucs
 * Kukucs.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Kukucs extends JApplet
                        implements ActionListener {
  java.applet.Applet j;
  JPanel cp = (JPanel)getContentPane();
  JLabel lbKukucs;
  JButton btMutat = new JButton("Elrejt");
  boolean mutat = true;

  public void init() {
    cp.setBorder(BorderFactory.createLineBorder(new Color(60,180,120),20));
    cp.add(new JLabel("Végre applet!"),"North");

    Image img = getImage(getCodeBase(), "asit.gif");
    ImageIcon iiKep = new ImageIcon(img);
    lbKukucs = new JLabel("Kukucs",iiKep,JLabel.CENTER);
    lbKukucs.setFont(new Font("Dialog",Font.PLAIN,15));
    cp.add(lbKukucs);
    cp.add(btMutat,"South");
    btMutat.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ev) {
    mutat = !mutat;
    lbKukucs.setVisible(mutat);
    btMutat.setText(mutat?"Elrejt":"Mutat");
  }
}
