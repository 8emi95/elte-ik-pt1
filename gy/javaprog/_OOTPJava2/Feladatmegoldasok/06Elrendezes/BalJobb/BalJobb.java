/*
 * Feladatmegold�sok/6. fejezet
 * BalJobb.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (B): Tegyen a keretbe egym�s mell� k�t egyforma komponenst:
 * fel�l egy felirat (Bal, illetve Jobb), a t�bbi r�sz egy sz�vegter�let.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/* Sz�vegpanel, fel�l egy c�mk�vel. A c�mke sz�veg�t a panel
 * param�terben kapja meg.
 */
class SzovegPanel extends JPanel {
  private JTextArea taSzoveg = new JTextArea();

  public SzovegPanel(String cimke) {
    // A panel hat�rmenti elrednez�s�:
    setLayout(new BorderLayout());
    add(new JLabel(cimke,SwingConstants.CENTER),"North");
    add(taSzoveg);
    taSzoveg.setBorder(BorderFactory.createLoweredBevelBorder());
  }
}

// A f� keretbe k�r sz�vegpanelt tesz�nk, egym�s mell�:
public class BalJobb extends JFrame {
  private Container cp = getContentPane();

  public BalJobb() {
    setBounds(100,100,400,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.setLayout(new GridLayout(1,2));
    cp.add(new SzovegPanel("Bal"));
    cp.add(new SzovegPanel("Jobb"));

    show();
  }

  public static void main(String[] args) {
    new BalJobb();
  }
}
