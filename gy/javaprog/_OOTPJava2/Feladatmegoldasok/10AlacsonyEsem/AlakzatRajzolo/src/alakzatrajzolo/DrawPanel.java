/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: alakzatrajzolo
 * DrawPanel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
  // Rajzol�si m�dok. A drawingMode lehets�ges �rt�kei:
  public static final int POINT_MODE = 10;
  public static final int LINE_MODE = 20;
  public static final int RECT_MODE = 30;
  public static final int ROUNDEDRECT_MODE = 40;
  public static final int OVAL_MODE = 50;

  public boolean filled;                 // kit�lt�s van-e
  public int drawingMode = RECT_MODE;    // rajzol�si m�d
  public Color color = Color.black;      // rajzpanel rajzol�sz�ne

  private Vector figures = new Vector(); // panelen lev� alakzatok
  private Figure figure;                 // aktu�lis alakzat

  // Konstruktor
  public DrawPanel() {
    setBackground(SystemColor.window);
    addMouseListener(this);
  }

  // A rajzpanel kirajzol�sa. Kirajzolja a figures elemeit:
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

  // Ha lenyomj�k az egeret, akkor l�trehozunk egy �jabb alakzatot
  // az aktu�lis be�ll�t�sokkal (filled, color):
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