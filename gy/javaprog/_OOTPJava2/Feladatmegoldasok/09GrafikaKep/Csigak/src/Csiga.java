/*
 * Feladatmegoldások/9. fejezet
 * Csiga.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class Csiga extends JPanel {
  private int alfa;
  private double nov;
  private Color color;

  public Csiga(int alfa, double nov, Color color) {
    this.alfa = alfa;
    this.nov = nov;
    this.color = color;
  }

  public void paintComponent(Graphics g) {
    g.translate(getWidth()/2,getHeight()/2);
    g.setColor(color);
    int szog=0;
    double tav=0;
    int x1=0, x2;
    int y1=0, y2;
    for (int i=0; i<1000; i++) {
      szog = szog+alfa;
      tav = tav+nov;
      x2 = (int)(tav*Math.cos(Math.toRadians(szog)));
      y2 = (int)(tav*Math.sin(Math.toRadians(szog)));
      g.drawLine(x1, y1, x2, y2);
      x1 = x2;
      y1 = y2;
    }
  }
}
