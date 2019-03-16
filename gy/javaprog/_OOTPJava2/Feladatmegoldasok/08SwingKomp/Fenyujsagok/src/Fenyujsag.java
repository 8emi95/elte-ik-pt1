/*
 * Feladatmegold�sok/8. fejezet
 * Projekt: Fenyujsagok
 * Fenyujsag.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * A f�ny�js�g egy bekeretezett c�mke, melyben a sz�veg
 * balr�l jobbra halad. Konstruktor�ban megadjuk a sz�veget,
 * a sz�veg sz�n�t, valamint a halad�s sebess�g�t.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenyujsag extends JLabel implements ActionListener {
  private Timer timer;
  private String szoveg;

  public Fenyujsag(String szoveg, Color szin, int delay) {
    super(szoveg);
    setBorder(BorderFactory.createLoweredBevelBorder());
    this.szoveg = szoveg + " "; // ne �rjon az el�z� nyak�ra
    setFont(new Font("Arial",Font.PLAIN,20));
    setForeground(szin);
    timer = new Timer(delay,this);
    timer.start();
    timer.setInitialDelay(0);
  }

  public String getSzoveg() {
    return szoveg;
  }

  public void setSzoveg(String szoveg) {
    this.szoveg = szoveg + " ";
  }

  public void setDelay(int delay) {
    timer.setDelay(delay);
  }

  public void actionPerformed(ActionEvent e) {
    szoveg = szoveg.substring(1) + szoveg.charAt(0);
    setText(szoveg);
  }
}