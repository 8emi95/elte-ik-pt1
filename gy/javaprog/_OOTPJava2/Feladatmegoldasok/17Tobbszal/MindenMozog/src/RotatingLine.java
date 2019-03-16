/*
 * Feladatmegoldások/17. fejezet
 * Projekt: MindenMozog
 * RotatingLine.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;

public class RotatingLine extends JPanel implements Runnable {
  private int speed = 5;
  private Thread th;
  private int szog = 0;
  private int r = 100;

  public RotatingLine(int speed) {
    this.speed = speed;
    setBorder(BorderFactory.createLoweredBevelBorder());
    setBackground(new Color(210,220,200));
    th = new Thread(this);
    th.start();
  }

  protected void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    int kx = getWidth()/2;
    int ky = getHeight()/2;
    int x = (int) (r * Math.cos(Math.toRadians(szog)));
    int y = (int) (r * Math.sin(Math.toRadians(szog)));
    gr.setColor(Color.black);
    gr.drawLine(kx-x, ky-y, kx+x, ky+y);
  }

  // A run-nak folyamatosan futnia kell.
  // A Thread biztosítja, hogy a run megkapja a vezérlést.
  public void run() {
    while (true) {
      szog += 1;
      repaint();
      // speed ezredmp-ig alszik a szál.
      // A sleep InterruptedException kivételt ejthet, amit kezelni kell.
      // Ha nem aludna, akkor a forgás olyan gyors lenne, amilyent "bír" a processzor.
      // Persze a sok forgó egyenes egymást lassítja.
      try {
        th.sleep(speed);
      }
      catch (InterruptedException ex) {
      }
    }
  }
}
