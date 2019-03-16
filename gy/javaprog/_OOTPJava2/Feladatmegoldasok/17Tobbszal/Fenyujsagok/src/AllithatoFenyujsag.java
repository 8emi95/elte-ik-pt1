/*
 * Feladatmegold�sok/17. fejezet
 * Projekt: Fenyujsagok
 * AllithatoFenyujsag.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 *
 * A f�ny�js�g egy bekeretezett c�mke, melyben a sz�veg
 * balr�l jobbra halad. Konstruktor�ban megadjuk a sz�veget,
 * a sz�veg sz�n�t, valamint a halad�s sebess�g�t.
 * A f�ny�js�gnak �ll�that� a sz�vege �s a sz�ne, tov�b� egy
 * g�rget�s�v seg�ts�g�vel a f�ny�js�g menet k�zben
 * gyors�that�, illetve lass�that�.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AllithatoFenyujsag extends JPanel implements AdjustmentListener, ActionListener {
  private Fenyujsag fenyujsag;
  private JScrollBar sbDelay;
  private JLabel lbDelay;
  private JTextField tfSzoveg;
  private JButton btSzin;

  public AllithatoFenyujsag(String szoveg,Color szin,int delay) {
    setBorder(BorderFactory.createLineBorder(Color.lightGray,20));
    setLayout(new BorderLayout());
    add(fenyujsag = new Fenyujsag(szoveg,szin,delay));
    JPanel pnVezer = new JPanel();
    pnVezer.setLayout(new GridLayout(1,0));
    add(pnVezer,"South");
    pnVezer.add(sbDelay = new JScrollBar(
        JScrollBar.HORIZONTAL,delay,2,0,2000));
    pnVezer.add(lbDelay = new JLabel(""+delay,JLabel.CENTER));
    sbDelay.setUnitIncrement(10);
    sbDelay.setBlockIncrement(100);
    pnVezer.add(tfSzoveg = new JTextField(10));
    pnVezer.add(btSzin = new JButton("Sz�n"));

    sbDelay.addAdjustmentListener(this);
    tfSzoveg.addActionListener(this);
    btSzin.addActionListener(this);
  }

  public void adjustmentValueChanged(AdjustmentEvent e) {
    int delay = sbDelay.getValue();
    fenyujsag.setDelay(delay);
    lbDelay.setText(""+delay);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==tfSzoveg)
      fenyujsag.setSzoveg(tfSzoveg.getText());
    else if (e.getSource()==btSzin) {
      fenyujsag.setForeground(JColorChooser.showDialog(this,"A sz�veg sz�ne",fenyujsag.getBackground()));
    }

  }
}

