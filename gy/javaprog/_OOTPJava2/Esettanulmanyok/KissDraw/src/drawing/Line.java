/*
 * Csomag: drawing
 * Line.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package drawing;
import java.awt.*;

// Egyenes:
public class Line extends Figure {
  /* Az egyenes egyenlete: y = a*x + b
   * Az egyenes iránytangense.
   * ha vízszintes, tg=0, ha függõleges, tg=végtelen -
   * ekkor kell a fuggoleges logikai változo.
   */
  private double tg = 0;
  private boolean fuggoleges = false;

  public Line(Point startPoint) {
    this(startPoint,Color.black);
  }

  public Line(Point startPoint, Color color) {
    super(startPoint,color);
  }

  /* A végpont beállításánál kiszámítjuk az egyenes iránytangensét,
   * hacsak nem függõleges.
   */
  public void setEndPoint(Point endPoint) {
    super.setEndPoint(endPoint);
    fuggoleges = endPoint.x == startPoint.x;
    if (!fuggoleges)
      tg = (double)(endPoint.y - startPoint.y) / (endPoint.x - startPoint.x);
  }

  public void draw(Graphics g) {
    g.setColor(color);
    g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    if (isSelected()) {
      g.setColor(Color.black);
      g.drawOval(startPoint.x-SEL_RAD, startPoint.y-SEL_RAD, SEL_DIA, SEL_DIA);
      g.drawOval(endPoint.x-SEL_RAD, endPoint.y-SEL_RAD, SEL_DIA, SEL_DIA);
    }
  }

  /* Megadja, hogy a pont közel van-e az egyeneshez.
   * h1 egy vízszintes szakasz p és az egyenes között.
   * h2 egy függõleges szakasz p és az egyenes között.
   * h1 = (p.x-startPoint.x) - (p.y-startPoint.y)/a;
   * h2 = a * h1
   * A p távolsága az egyenestõl a h1 és h2 által meghatározott
   * háromszög magassága:
   * terület / átló (lásd a kódban)
   */
  public boolean near(Point p) {
    if (fuggoleges)
      return (Math.abs(p.x-startPoint.x)<=1);

    if (p.x < x() || p.x > x()+width() ||
        p.y < y() || p.y > y()+height())
      // A pont az egyenes által meghatározott téglalapon kívülre esik:
      return false;

    //double h1 = (p.x-startPoint.x) - (p.y-startPoint.y)/tg;
    double h1 = (p.x-startPoint.x) - (p.y-startPoint.y)/tg;
    if (h1 == 0) // p rajta van az egyenesen
      return true;

    double h2 = tg * h1;
    double ter = (h1 * h2) / 2 ;
    double atlo = Math.sqrt(Math.pow(h1,2)+Math.pow(h2,2));
    double tav = ter/atlo;
    return Math.abs(tav) <= 1; // p közel van az egyeneshez
  }
}
