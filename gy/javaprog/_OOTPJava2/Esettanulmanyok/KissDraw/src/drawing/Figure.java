/*
 * Csomag: drawing
 * Figure.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package drawing;
import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable, Cloneable {
  protected Point startPoint; // az alakzat kezdõpontja (ezt adták meg elõször)
  protected Point endPoint;   // az alakzat végpontja:
  protected Color color;      // az alakzat színe
  protected boolean selected = false; // ki van-e választva
  protected static final int SEL_RAD = 3;        // a kijelölõ köröcske sugara
  protected static final int SEL_DIA = 2*SEL_RAD; // a kijelölõ köröcske átmérõje

  // Konstruktor. Létrehozáskor a kezdõpont és a végpont egybeesik:
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

  /* A két pont által meghatározott téglalap bal felsõ sarkának
   * X koordinátája: */
  public int x() {
    return Math.min(startPoint.x,endPoint.x);
  }

  /* A két pont által meghatározott téglalap bal felsõ sarkának
   * Y koordinátája: */
  public int y() {
    return Math.min(startPoint.y,endPoint.y);
  }

  // A két pont által meghatározott téglalap szélessége:
  public int width() {
    return Math.max(startPoint.x,endPoint.x)-x();
  }

  // A két pont által meghatározott téglalap magassága:
  public int height() {
    return Math.max(startPoint.y,endPoint.y)-y();
  }

  // Absztrakt metódus. Kirajzolja az alakzatot:
  public abstract void draw(Graphics g);

  /* true, ha az alakzat vonala (kerülete) tartalmazza a
   * megadott pontot, illetve közel van hozzá:
   */
  public abstract boolean near(Point p);

  // Megadja, hogy két pont elég közel van-e egymáshoz (legalább 1 pontnyira):
  public static boolean near(Point p1, Point p2) {
    return (Math.abs(p1.x - p2.x) <= 3) &&
           (Math.abs(p1.y - p2.y) <= 3);
  }

  public String toString() {
    return "("+startPoint.x + "," + startPoint.y + "):(" +
        +endPoint.x + "," + endPoint.y + "),"+selected;
  }

  // Az alakzatokat lehet klónozni:
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
