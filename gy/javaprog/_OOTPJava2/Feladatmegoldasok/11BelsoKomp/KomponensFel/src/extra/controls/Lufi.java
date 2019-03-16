/*
 * Feladatmegoldások/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * Lufi.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Felfújható és vonszolható lufi.
 * A szülõ elrendezésmenedzsere null legyen!
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lufi extends JPanel {
  private Color color;       // lufi színe
  private int cx, cy;        // lufi középpontja
  private int radius;        // lufi sugara
  private int beginRadius;

  public Lufi(int cx, int cy, Color color) {
    this.cx =cx;
    this.cy = cy;
    beginRadius = 10;
    radius = beginRadius;
    this.color = color;
    setLufi();
    enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK);
  }

  public void setCenter(int cx, int cy) {
    this.cx = cx;
    this.cy = cy;
    setLufi();
  }

  public void setRadius(int radius) {
    this.radius = radius;
    setLufi();
  }

  private void setLufi() {
    setBounds(cx-radius,cy-radius,radius*2,radius*2);
  }

  public void grow(int rel) {
    radius += rel;
    setLufi();
  }

  public void processMouseEvent(MouseEvent e) {
    if (e.getID() == e.MOUSE_PRESSED) {
      grow(2);
      if (radius > 100)
        setRadius(beginRadius);
    }
    super.processMouseEvent(e);
  }

  public void processMouseMotionEvent(MouseEvent e) {
    if (e.getID() == e.MOUSE_DRAGGED) {
      // Az egér koordinátája a lufi egy pontja:
      setCenter(getX()+e.getX(),getY()+e.getY());
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(color);
    g.fillOval(0,0,2*radius,2*radius);
  }

} // Lufi
