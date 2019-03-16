/*
 * Feladatmegold�sok/17. fejezet
 * Projekt: Fenyujsagok
 * Fenyujsag.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 *
 * A f�ny�js�g egy bekeretezett c�mke, melyben a sz�veg
 * balr�l jobbra halad. Konstruktor�ban megadjuk a sz�veget,
 * a sz�veg sz�n�t, valamint a halad�s sebess�g�t.
 */

import java.awt.*;
import javax.swing.*;

class Fenyujsag extends JLabel implements Runnable {
  private Thread timer;
  private int delay;
  private String szoveg;

  public Fenyujsag(String szoveg, Color szin, int delay) {
    super(szoveg);
    this.delay = delay;
    setBorder(BorderFactory.createLoweredBevelBorder());
    this.szoveg = szoveg + " "; // ne �rjon az el�z� nyak�ra
    setFont(new Font("Arial",Font.PLAIN,20));
    setForeground(szin);
    timer = new Thread(this);
    timer.start();
  }

  public String getSzoveg() {
    return szoveg;
  }

  public void setSzoveg(String szoveg) {
    this.szoveg = szoveg + " ";
  }

  public void setDelay(int delay) {
    this.delay = delay;
  }

  public void run() {
    while(true) {
      szoveg = szoveg.substring(1) + szoveg.charAt(0);
      setText(szoveg);
      try {
        timer.sleep(delay);
      }
      catch (InterruptedException ie) {
      }
    }
  }
}