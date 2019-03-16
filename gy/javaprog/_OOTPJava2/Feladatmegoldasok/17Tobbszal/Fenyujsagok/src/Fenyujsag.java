/*
 * Feladatmegoldások/17. fejezet
 * Projekt: Fenyujsagok
 * Fenyujsag.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 *
 * A fényújság egy bekeretezett címke, melyben a szöveg
 * balról jobbra halad. Konstruktorában megadjuk a szöveget,
 * a szöveg színét, valamint a haladás sebességét.
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
    this.szoveg = szoveg + " "; // ne írjon az elõzõ nyakára
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