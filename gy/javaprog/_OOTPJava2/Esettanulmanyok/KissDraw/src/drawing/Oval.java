/*
 * Csomag: drawing
 * Oval.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package drawing;
import java.awt.*;

// Ovális alakzat (ellipszis):
public class Oval extends Figure {

  public Oval(Point startPoint) {
    this(startPoint,Color.black);
  }

  public Oval(Point startPoint, Color color) {
    super(startPoint,color);
  }

  // Kirajzolja az ellipszist:
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawOval(x(),y(),width(),height());
    if (isSelected()) {
      g.setColor(Color.black);
      g.drawOval(x()-SEL_RAD,y()-SEL_RAD,SEL_DIA,SEL_DIA);
      g.drawOval(x()-SEL_RAD,y()+height()-SEL_RAD,SEL_DIA,SEL_DIA);
      g.drawOval(x()+width()-SEL_RAD,y()-SEL_RAD,SEL_DIA,SEL_DIA);
      g.drawOval(x()+width()-SEL_RAD,y()+height()-SEL_RAD,SEL_DIA,SEL_DIA);
    }
  }

  // Megadja, hogy a p pont közel van-e az ellipszishez:
  public boolean near(Point p) {
    double r1 = width()/2.0;
    double r2 = height()/2.0;

    /* Az ellipszis egyenlete, ha (0,0) az ellipszis középpontja:
     *    x*x/r1*r1 + y*y/r2*r2 = 1
     */
    double bal =
      Math.pow(p.x-x()-r1,2)/Math.pow(r1,2) +
      Math.pow(p.y-y()-r2,2)/Math.pow(r2,2);
    return Math.abs(bal - 1) <= 0.1;
  }
}
