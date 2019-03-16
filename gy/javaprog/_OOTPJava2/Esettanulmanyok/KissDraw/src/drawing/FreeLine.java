/*
 * Csomag: drawing
 * FreeLine.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package drawing;
import java.awt.*;
import java.util.Vector;

// Szabadk�zi rajz:
public class FreeLine extends Figure {
  private Polygon freeLine = new Polygon();

  public FreeLine(Point startPoint) {
    this(startPoint,Color.black);
  }

  public FreeLine(Point startPoint, Color color) {
    super(startPoint,color);
    freeLine.addPoint(startPoint.x, startPoint.y);
  }

  // Kirajzolja a szabadk�zi vonalat:
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawPolyline(freeLine.xpoints, freeLine.ypoints, freeLine.npoints);

    // Kijel�l�s:
    if (isSelected()) {
      g.setColor(Color.black);
      // A vonal minden 10. t�rolt pontj�t jel�lj�k meg:
      for (int i = 0; i < freeLine.npoints; i+=10) {
        g.drawOval(freeLine.xpoints[i]-SEL_RAD,freeLine.ypoints[i]-SEL_RAD, SEL_DIA, SEL_DIA);
      }
      // Az utols� pont:
      g.drawOval(endPoint.x-SEL_RAD, endPoint.y-SEL_RAD, SEL_DIA, SEL_DIA);
    }
  }

  public void setEndPoint(Point endPoint) {
    super.setEndPoint(endPoint);
    // Hozz�ad a szabadk�zi vonalhoz egy pontot:
    freeLine.addPoint(endPoint.x, endPoint.y);
  }

  // Megadja, hogy a p pont k�zel van-e a szabadk�zi vonalhoz:
  public boolean near(Point p) {
    for (int i = 0; i < freeLine.npoints; i++) {
      if (near(new Point(freeLine.xpoints[i],freeLine.ypoints[i]),p))
        return true;
    }
    return false;
  }

}
