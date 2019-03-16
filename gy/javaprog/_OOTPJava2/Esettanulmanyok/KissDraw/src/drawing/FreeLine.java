/*
 * Csomag: drawing
 * FreeLine.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package drawing;
import java.awt.*;
import java.util.Vector;

// Szabadkézi rajz:
public class FreeLine extends Figure {
  private Polygon freeLine = new Polygon();

  public FreeLine(Point startPoint) {
    this(startPoint,Color.black);
  }

  public FreeLine(Point startPoint, Color color) {
    super(startPoint,color);
    freeLine.addPoint(startPoint.x, startPoint.y);
  }

  // Kirajzolja a szabadkézi vonalat:
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawPolyline(freeLine.xpoints, freeLine.ypoints, freeLine.npoints);

    // Kijelölés:
    if (isSelected()) {
      g.setColor(Color.black);
      // A vonal minden 10. tárolt pontját jelöljük meg:
      for (int i = 0; i < freeLine.npoints; i+=10) {
        g.drawOval(freeLine.xpoints[i]-SEL_RAD,freeLine.ypoints[i]-SEL_RAD, SEL_DIA, SEL_DIA);
      }
      // Az utolsó pont:
      g.drawOval(endPoint.x-SEL_RAD, endPoint.y-SEL_RAD, SEL_DIA, SEL_DIA);
    }
  }

  public void setEndPoint(Point endPoint) {
    super.setEndPoint(endPoint);
    // Hozzáad a szabadkézi vonalhoz egy pontot:
    freeLine.addPoint(endPoint.x, endPoint.y);
  }

  // Megadja, hogy a p pont közel van-e a szabadkézi vonalhoz:
  public boolean near(Point p) {
    for (int i = 0; i < freeLine.npoints; i++) {
      if (near(new Point(freeLine.xpoints[i],freeLine.ypoints[i]),p))
        return true;
    }
    return false;
  }

}
