/*
 * Mintaprogramok/19. fejezet
 * Projekt: Megfigyeles
 * Csomag: gui
 * BetukSzamaKijelzo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package gui;
import db.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class BetukSzamaKijelzo extends JPanel implements Observer {
  private JLabel[] lbAdatok = new JLabel[26];

  public BetukSzamaKijelzo() {
    setLayout(new GridLayout(2,1));
    JPanel pn = new JPanel();
    pn.setLayout(new GridLayout(1,26));
    for (char c = 'A'; c <= 'Z'; c++)
      pn.add(new JLabel(c+"",JLabel.CENTER));
    add(pn);
    pn = new JPanel();
    pn.setLayout(new GridLayout(1,26));
    for (char c = 'A'; c <= 'Z'; c++) {
      pn.add(lbAdatok[c-'A'] = new JLabel(" 0 ",JLabel.CENTER));
      lbAdatok[c-'A'].setFont(new Font("Monospaced",Font.PLAIN,15));
      lbAdatok[c-'A'].setBorder(BorderFactory.createEtchedBorder());
    }
    add(pn);
  }

  public void update(Observable obj, Object arg) {
    if (!(obj instanceof BetuStatisztika))
      return;
    BetuStatisztika bs = (BetuStatisztika)obj;
    for (char c = 'A'; c <= 'Z'; c++)
      lbAdatok[c-'A'].setText(bs.hany(c)+"");
  }
}
