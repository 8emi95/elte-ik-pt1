/*
 * Feladatmegoldások/10. fejezet
 * Projekt: VonszoltTegla
 * Csomag: vonszolttegla
 * DrawPanel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Erre a panelre téglalap alakzatokat lehet tenni egérvonszolással.
 * A kezdõpontot az egér kezdeti pozíciója, a végpontot az egér felengedésének
 * a pozíciója adja meg.
 */

package vonszolttegla;
import figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
  private int gridStepX=10, gridStepY=10; // a rács sûrûsége
  private Color color = Color.black;      // a rajzpanel rajzolószíne

  private Vector figures = new Vector();  // a panelen levõ alakzatok
  private Figure figure;                  // aktuális alakzat
  // A rajzpanel egérkurzora kereszt alakú lesz:
  private Cursor drawCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);

  // Konstruktor
  public DrawPanel() {
    setBackground(SystemColor.window);
    addMouseListener(this);
    addMouseMotionListener(this);
    setCursor(drawCursor);
  }

  // A rács (grid) kirajzolása (pontozás):
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

  // Az alakzatok kirajzolása:
  void drawFigures(Graphics g) {
    for (int i = 0; i < figures.size(); i++) {
      Figure figure = (Figure)figures.get(i);
      figure.draw(g);
    }
  }

  // A rajzpanel kirajzolása:
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawGrid(g);
    drawFigures(g);
  }

  public void mouseClicked(MouseEvent e) {
  }

  // Lenyomták az egeret. Létrehozzuk az alakzatot:
  public void mousePressed(MouseEvent e) {
    Graphics g = getGraphics();
    figure = new Rect(e.getPoint());
  }

  public void mouseReleased(MouseEvent e) {
    Graphics g = getGraphics();
    g.setColor(color);
    figure.draw(g);
    // A új alakzat hozzáadása a figures vektorhoz:
    figures.add(figure);
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  // Vonszolják az egeret. Az alakzat kialakítása:
  public void mouseDragged(MouseEvent e) {
    Graphics g = getGraphics();
    g.setColor(color);
    // Az elõzõ alakzat törlése XOR módban (így a rács megmarad alatta):
    g.setXORMode(getBackground());
    figure.draw(g);
    // Alakzat végpontjának módosítása:
    figure.setEndPoint(e.getPoint());
    // Az alakzat kirajzolása XOR módban:
    figure.draw(g);
  }

  public void mouseMoved(MouseEvent e) {
  }
}
