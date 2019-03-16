/*
 * Feladatmegoldások/8. fejezet
 * Projekt: Fenyujsagok
 * GyorsithatoFenyujsag.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * A fényújság egy bekeretezett címke, melyben a szöveg
 * balról jobbra halad. Konstruktorában megadjuk a szöveget,
 * a szöveg színét, valamint a haladás sebességét.
 * Egy görgetõsáv segítségével a fényújság menet közben
 * gyorsítható, illetve lassítható.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GyorsithatoFenyujsag extends JPanel implements AdjustmentListener {
  private Fenyujsag fenyujsag;
  private JScrollBar sbDelay;
  private JLabel lbDelay;

  public GyorsithatoFenyujsag(String szoveg,Color szin,int delay) {
    setBorder(BorderFactory.createLineBorder(Color.lightGray,20));
    setLayout(new BorderLayout());
    add(fenyujsag = new Fenyujsag(szoveg,szin,delay));
    JPanel pnVezer = new JPanel();
    pnVezer.setLayout(new GridLayout(1,2));
    add(pnVezer,"South");
    pnVezer.add(sbDelay = new JScrollBar(
        JScrollBar.HORIZONTAL,delay,2,0,2000));
    pnVezer.add(lbDelay = new JLabel(""+delay,JLabel.CENTER));
    sbDelay.setUnitIncrement(10);
    sbDelay.setBlockIncrement(100);
    sbDelay.addAdjustmentListener(this);
  }

  public void adjustmentValueChanged(AdjustmentEvent e) {
    int delay = sbDelay.getValue();
    fenyujsag.setDelay(delay);
    lbDelay.setText(""+delay);
  }
}
