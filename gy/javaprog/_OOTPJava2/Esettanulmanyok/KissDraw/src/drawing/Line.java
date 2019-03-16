/*
 * Csomag: drawing
 * Line.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package drawing;
import java.awt.*;

// Egyenes:
public class Line extends Figure {
  /* Az egyenes egyenlete: y = a*x + b
   * Az egyenes ir�nytangense.
   * ha v�zszintes, tg=0, ha f�gg�leges, tg=v�gtelen -
   * ekkor kell a fuggoleges logikai v�ltozo.
   */
  private double tg = 0;
  private boolean fuggoleges = false;

  public Line(Point startPoint) {
    this(startPoint,Color.black);
  }

  public Line(Point startPoint, Color color) {
    super(startPoint,color);
  }

  /* A v�gpont be�ll�t�s�n�l kisz�m�tjuk az egyenes ir�nytangens�t,
   * hacsak nem f�gg�leges.
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

  /* Megadja, hogy a pont k�zel van-e az egyeneshez.
   * h1 egy v�zszintes szakasz p �s az egyenes k�z�tt.
   * h2 egy f�gg�leges szakasz p �s az egyenes k�z�tt.
   * h1 = (p.x-startPoint.x) - (p.y-startPoint.y)/a;
   * h2 = a * h1
   * A p t�vols�ga az egyenest�l a h1 �s h2 �ltal meghat�rozott
   * h�romsz�g magass�ga:
   * ter�let / �tl� (l�sd a k�dban)
   */
  public boolean near(Point p) {
    if (fuggoleges)
      return (Math.abs(p.x-startPoint.x)<=1);

    if (p.x < x() || p.x > x()+width() ||
        p.y < y() || p.y > y()+height())
      // A pont az egyenes �ltal meghat�rozott t�glalapon k�v�lre esik:
      return false;

    //double h1 = (p.x-startPoint.x) - (p.y-startPoint.y)/tg;
    double h1 = (p.x-startPoint.x) - (p.y-startPoint.y)/tg;
    if (h1 == 0) // p rajta van az egyenesen
      return true;

    double h2 = tg * h1;
    double ter = (h1 * h2) / 2 ;
    double atlo = Math.sqrt(Math.pow(h1,2)+Math.pow(h2,2));
    double tav = ter/atlo;
    return Math.abs(tav) <= 1; // p k�zel van az egyeneshez
  }
}
