/*
 * Mintaprogramok/17. fejezet
 * Projekt: balls
 * Ball.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

// Egy egyszerû labda, amelyik arrébb tud menni, és a kapott panelre kirajzolja magát.
public class Ball extends Thread {
  JPanel panel; // ezen a panelen pattog a labda
  int x, y;     // középpont
  Color color;
  int dx=1, dy=1;   // irány
  int RADIUS = 10;   // sugar
  boolean active = false;

  public Ball(int x, int y, Color color, JPanel panel) {
    this.x = x;
    this.y = y;
    this.color = color;
    this.panel = panel;
  }

  public void move() {                                   //1
    x += dx;
    if (x < 0 || x > panel.getWidth())
      dx *= -1;
    y += dy;
    if (y < 0 || y > panel.getHeight())
      dy *= -1;
    panel.repaint();
  }

  public synchronized void setActive(boolean active) {   //2
    this.active = active;
    if (active) {
      notify();
    }
  }

  public void run() {                                    //3
    while (true) {
      synchronized(this) {
        try {
          move();
          sleep(5);
          while (!active)
            wait();
        }
        catch (InterruptedException ie) {
        }
      }
    }
  }

  // Kirajzolja magát a kapott panelre:
  public void draw(Graphics gr) {                        //4
    gr.setColor(color);
    gr.fillOval(x,y,RADIUS,RADIUS);
  }
}
