/*
 * Csomag: drawing
 * Rect.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package drawing;

import java.awt.*;

// Téglalap:
public class Rect extends Figure {

  public Rect(Point startPoint) {
    this(startPoint,Color.black);
  }

  public Rect(Point startPoint, Color color) {
    super(startPoint,color);
  }

  // Kirajzolja a téglalapot:
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawRect(x(),y(),width(),height());
    if (isSelected()) {
      g.setColor(Color.black);
      g.drawOval(x()-SEL_RAD,y()-SEL_RAD,SEL_DIA,SEL_DIA);
      g.drawOval(x()-SEL_RAD,y()+height()-SEL_RAD,SEL_DIA,SEL_DIA);
      g.drawOval(x()+width()-SEL_RAD,y()-SEL_RAD,SEL_DIA,SEL_DIA);
      g.drawOval(x()+width()-SEL_RAD,y()+height()-SEL_RAD,SEL_DIA,SEL_DIA);
    }
  }

  // Megadja, hogy a p pont közel van-e a téglalaphoz:
  public boolean near(Point p) {
    boolean horiz =
      (p.x >= x()) && (p.x <= x()+width()) &&
      (Math.abs(p.y-y()) <= 1 || Math.abs(p.y-y()-height()) <= 1) ;
    if (horiz)
      // a pont valamelyik vízszintes oldalhoz közel van:
      return true;

    boolean vert =
      (p.y >= y()) && (p.y <= y()+height()) &&
      (Math.abs(p.x-x()) <= 1 || Math.abs(p.x-x()-width()) <= 1) ;
    // true, ha a pont valamelyik függõleges oldalhoz közel van:
    return vert;
  }
}
