/*
 * Csomag: drawing
 * Figure.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package drawing;
import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable, Cloneable {
  protected Point startPoint; // az alakzat kezd�pontja (ezt adt�k meg el�sz�r)
  protected Point endPoint;   // az alakzat v�gpontja:
  protected Color color;      // az alakzat sz�ne
  protected boolean selected = false; // ki van-e v�lasztva
  protected static final int SEL_RAD = 3;        // a kijel�l� k�r�cske sugara
  protected static final int SEL_DIA = 2*SEL_RAD; // a kijel�l� k�r�cske �tm�r�je

  // Konstruktor. L�trehoz�skor a kezd�pont �s a v�gpont egybeesik:
  public Figure(Point startPoint, Color color) {
    this.startPoint = startPoint;
    endPoint = startPoint;
    this.color = color;
  }

  public Point getStartPoint() {
    return startPoint;
  }

  public Point getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(Point endPoint) {
    this.endPoint = endPoint;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public boolean isSelected() {
    return selected;
  }

  public void select() {
    selected = true;
  }

  public void deSelect() {
    selected = false;
  }

  /* A k�t pont �ltal meghat�rozott t�glalap bal fels� sark�nak
   * X koordin�t�ja: */
  public int x() {
    return Math.min(startPoint.x,endPoint.x);
  }

  /* A k�t pont �ltal meghat�rozott t�glalap bal fels� sark�nak
   * Y koordin�t�ja: */
  public int y() {
    return Math.min(startPoint.y,endPoint.y);
  }

  // A k�t pont �ltal meghat�rozott t�glalap sz�less�ge:
  public int width() {
    return Math.max(startPoint.x,endPoint.x)-x();
  }

  // A k�t pont �ltal meghat�rozott t�glalap magass�ga:
  public int height() {
    return Math.max(startPoint.y,endPoint.y)-y();
  }

  // Absztrakt met�dus. Kirajzolja az alakzatot:
  public abstract void draw(Graphics g);

  /* true, ha az alakzat vonala (ker�lete) tartalmazza a
   * megadott pontot, illetve k�zel van hozz�:
   */
  public abstract boolean near(Point p);

  // Megadja, hogy k�t pont el�g k�zel van-e egym�shoz (legal�bb 1 pontnyira):
  public static boolean near(Point p1, Point p2) {
    return (Math.abs(p1.x - p2.x) <= 3) &&
           (Math.abs(p1.y - p2.y) <= 3);
  }

  public String toString() {
    return "("+startPoint.x + "," + startPoint.y + "):(" +
        +endPoint.x + "," + endPoint.y + "),"+selected;
  }

  // Az alakzatokat lehet kl�nozni:
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
