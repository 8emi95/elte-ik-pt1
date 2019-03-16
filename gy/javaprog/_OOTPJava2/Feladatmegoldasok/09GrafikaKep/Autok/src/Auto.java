/*
 * Feladatmegoldások/9. fejezet
 * Projekt: Autok
 * Auto.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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

  // Az autó képe:
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);       // a kerekek feketék
    g.fillOval(8,24,13,13);        // elsô kerék
    g.fillOval(40,24,13,13);       // hátsó kerék
    g.setColor(szin);              // autó színe
    g.fillRect(15,10,45,10);       // felsô test
    g.fillRect(2,20,59,10);        // alsó test
    g.fillOval(0,22,4,4);          // lámpa
    g.drawLine(15,10,30,0);        // antenna
    g.setColor(Color.lightGray);   // az ablak szürke
    g.fillRect(17,13,4,8);         // ablak
  }

}

