/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Point.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Pont az (x,y) pozíción.
 */

package figures;
import java.awt.*;

public class Point extends Figure {

  public Point(int x, int y) {
    super(x,y,3,3);
  }

  public void draw(Graphics g) {
    g.setColor(color);
    g.fillOval(x,y,3,3);
  }
}
