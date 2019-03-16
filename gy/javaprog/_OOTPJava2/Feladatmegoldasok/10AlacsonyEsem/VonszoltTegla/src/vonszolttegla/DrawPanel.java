/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: VonszoltTegla
 * Csomag: vonszolttegla
 * DrawPanel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Erre a panelre t�glalap alakzatokat lehet tenni eg�rvonszol�ssal.
 * A kezd�pontot az eg�r kezdeti poz�ci�ja, a v�gpontot az eg�r felenged�s�nek
 * a poz�ci�ja adja meg.
 */

package vonszolttegla;
import figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
  private int gridStepX=10, gridStepY=10; // a r�cs s�r�s�ge
  private Color color = Color.black;      // a rajzpanel rajzol�sz�ne

  private Vector figures = new Vector();  // a panelen lev� alakzatok
  private Figure figure;                  // aktu�lis alakzat
  // A rajzpanel eg�rkurzora kereszt alak� lesz:
  private Cursor drawCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);

  // Konstruktor
  public DrawPanel() {
    setBackground(SystemColor.window);
    addMouseListener(this);
    addMouseMotionListener(this);
    setCursor(drawCursor);
  }

  // A r�cs (grid) kirajzol�sa (pontoz�s):
  void drawGrid(Graphics g) {
    g.setColor(Color.black);
    for (int x=0; x<getWidth(); x+=gridStepX)
      for (int y=0; y<getHeight(); y+=gridStepY) {
        g.fillOval(x,y,1,1);
      }
    for (int y=0; y<getHeight(); y+=gridStepY) {
      for (int x=0; x<getWidth(); x+=gridStepX) {
        g.fillOval(x,y,1,1);
      }
    }
  }

  // Az alakzatok kirajzol�sa:
  void drawFigures(Graphics g) {
    for (int i = 0; i < figures.size(); i++) {
      Figure figure = (Figure)figures.get(i);
      figure.draw(g);
    }
  }

  // A rajzpanel kirajzol�sa:
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawGrid(g);
    drawFigures(g);
  }

  public void mouseClicked(MouseEvent e) {
  }

  // Lenyomt�k az egeret. L�trehozzuk az alakzatot:
  public void mousePressed(MouseEvent e) {
    Graphics g = getGraphics();
    figure = new Rect(e.getPoint());
  }

  public void mouseReleased(MouseEvent e) {
    Graphics g = getGraphics();
    g.setColor(color);
    figure.draw(g);
    // A �j alakzat hozz�ad�sa a figures vektorhoz:
    figures.add(figure);
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  // Vonszolj�k az egeret. Az alakzat kialak�t�sa:
  public void mouseDragged(MouseEvent e) {
    Graphics g = getGraphics();
    g.setColor(color);
    // Az el�z� alakzat t�rl�se XOR m�dban (�gy a r�cs megmarad alatta):
    g.setXORMode(getBackground());
    figure.draw(g);
    // Alakzat v�gpontj�nak m�dos�t�sa:
    figure.setEndPoint(e.getPoint());
    // Az alakzat kirajzol�sa XOR m�dban:
    figure.draw(g);
  }

  public void mouseMoved(MouseEvent e) {
  }
}
