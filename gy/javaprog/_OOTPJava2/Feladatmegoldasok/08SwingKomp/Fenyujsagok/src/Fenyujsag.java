/*
 * Feladatmegoldások/8. fejezet
 * Projekt: Fenyujsagok
 * Fenyujsag.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * A fényújság egy bekeretezett címke, melyben a szöveg
 * balról jobbra halad. Konstruktorában megadjuk a szöveget,
 * a szöveg színét, valamint a haladás sebességét.
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
    this.szoveg = szoveg + " "; // ne írjon az elõzõ nyakára
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