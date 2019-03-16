/*
 * Feladatmegold�sok/8. fejezet
 * Projekt: Fenyujsagok
 * GyorsithatoFenyujsag.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * A f�ny�js�g egy bekeretezett c�mke, melyben a sz�veg
 * balr�l jobbra halad. Konstruktor�ban megadjuk a sz�veget,
 * a sz�veg sz�n�t, valamint a halad�s sebess�g�t.
 * Egy g�rget�s�v seg�ts�g�vel a f�ny�js�g menet k�zben
 * gyors�that�, illetve lass�that�.
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
