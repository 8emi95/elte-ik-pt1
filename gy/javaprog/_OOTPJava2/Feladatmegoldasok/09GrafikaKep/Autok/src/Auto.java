/*
 * Feladatmegold�sok/9. fejezet
 * Projekt: Autok
 * Auto.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class Auto extends JPanel {
  private Color szin;

  public Auto(Color szin) {
    this.szin = szin;
    setSize(60,38);
  }

  // Az aut� k�pe:
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);       // a kerekek feket�k
    g.fillOval(8,24,13,13);        // els� ker�k
    g.fillOval(40,24,13,13);       // h�ts� ker�k
    g.setColor(szin);              // aut� sz�ne
    g.fillRect(15,10,45,10);       // fels� test
    g.fillRect(2,20,59,10);        // als� test
    g.fillOval(0,22,4,4);          // l�mpa
    g.drawLine(15,10,30,0);        // antenna
    g.setColor(Color.lightGray);   // az ablak sz�rke
    g.fillRect(17,13,4,8);         // ablak
  }

}

