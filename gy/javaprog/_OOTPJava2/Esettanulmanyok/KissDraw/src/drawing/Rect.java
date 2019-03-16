/*
 * Csomag: drawing
 * Rect.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package drawing;

import java.awt.*;

// T�glalap:
public class Rect extends Figure {

  public Rect(Point startPoint) {
    this(startPoint,Color.black);
  }

  public Rect(Point startPoint, Color color) {
    super(startPoint,color);
  }

  // Kirajzolja a t�glalapot:
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

  // Megadja, hogy a p pont k�zel van-e a t�glalaphoz:
  public boolean near(Point p) {
    boolean horiz =
      (p.x >= x()) && (p.x <= x()+width()) &&
      (Math.abs(p.y-y()) <= 1 || Math.abs(p.y-y()-height()) <= 1) ;
    if (horiz)
      // a pont valamelyik v�zszintes oldalhoz k�zel van:
      return true;

    boolean vert =
      (p.y >= y()) && (p.y <= y()+height()) &&
      (Math.abs(p.x-x()) <= 1 || Math.abs(p.x-x()-width()) <= 1) ;
    // true, ha a pont valamelyik f�gg�leges oldalhoz k�zel van:
    return vert;
  }
}
