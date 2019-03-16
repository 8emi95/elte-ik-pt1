/*
 * Feladatmegoldások/17. fejezet
 * Projekt: Fenyujsagok
 * AllithatoFenyujsag.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 *
 * A fényújság egy bekeretezett címke, melyben a szöveg
 * balról jobbra halad. Konstruktorában megadjuk a szöveget,
 * a szöveg színét, valamint a haladás sebességét.
 * A fényújságnak állítható a szövege és a színe, továbá egy
 * görgetõsáv segítségével a fényújság menet közben
 * gyorsítható, illetve lassítható.
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
    pnVezer.add(btSzin = new JButton("Szín"));

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
      fenyujsag.setForeground(JColorChooser.showDialog(this,"A szöveg színe",fenyujsag.getBackground()));
    }

  }
}

