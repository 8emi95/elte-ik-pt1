/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: alakzatrajzolo
 * DrawPanel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Rajzpanel. Erre rajzoljuk az alakzatokat.
 */

package alakzatrajzolo;

import figures.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class DrawPanel extends JPanel implements MouseListener {
  // Rajzolási módok. A drawingMode lehetséges értékei:
  public static final int POINT_MODE = 10;
  public static final int LINE_MODE = 20;
  public static final int RECT_MODE = 30;
  public static final int ROUNDEDRECT_MODE = 40;
  public static final int OVAL_MODE = 50;

  public boolean filled;                 // kitöltés van-e
  public int drawingMode = RECT_MODE;    // rajzolási mód
  public Color color = Color.black;      // rajzpanel rajzolószíne

  private Vector figures = new Vector(); // panelen levõ alakzatok
  private Figure figure;                 // aktuális alakzat

  // Konstruktor
  public DrawPanel() {
    setBackground(SystemColor.window);
    addMouseListener(this);
  }

  // A rajzpanel kirajzolása. Kirajzolja a figures elemeit:
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(color);
    for (int i = 0; i < figures.size(); i++) {
      Figure figure = (Figure)figures.get(i);
      figure.draw(g);
    }
  }

  public void mouseClicked(MouseEvent e) {
  }

  // Ha lenyomják az egeret, akkor létrehozunk egy újabb alakzatot
  // az aktuális beállításokkal (filled, color):
  public void mousePressed(MouseEvent e) {
    switch (drawingMode) {
      case POINT_MODE:
        figure = new figures.Point(e.getX(),e.getY());
        break;
      case LINE_MODE:
        figure = new Line(e.getX(),e.getY());
        break;
      case RECT_MODE:
        figure = new Rect(e.getX(),e.getY(),filled);
        break;
      case ROUNDEDRECT_MODE:
        figure = new RoundedRect(e.getX(),e.getY(),filled);
        break;
      case OVAL_MODE:
        figure = new Oval(e.getX(),e.getY(),filled);
        break;
    }
    figure.setColor(color);
    figures.add(figure);
    repaint();
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

}