/*
 * Feladatmegoldások/10. fejezet
 * Projekt: VonszoltTegla
 * Csomag: figures
 * Figure.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Az alakzatot (síkidomot) a startPoint és az endPoint által meghatározott téglalap határolja.
 * startPoint és endPoint az alakzat ellentétes sarkai.
 * startPoint rögzített, azt a konstruktorban kell megadni.
 * endPoint változó sarok, azt a setEndPoint metódussal lehet beállítani.
 * A két pont tetszõleges helyen lehet.
 * Az alakzat kirajzolását a leszármazott osztályban kell megadni.
 */

package figures;
import java.awt.*;

public abstract class Figure {
  protected Point startPoint;
  protected Point endPoint;

  // Konstruktor. Kezdetben a kezdõpont és a végpont egybeesik.
  // A végpontot majd a setEndPoint metódussal lehet állítani:
  public Figure(Point startPoint) {
    this.startPoint = startPoint;
    endPoint = startPoint;
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

  // A két pont által meghatározott téglalap bal felsõ sarkának
  // x koordinátája:
  public int x() {
    return Math.min(startPoint.x,endPoint.x);
  }

  // A két pont által meghatározott téglalap bal felsõ sarkának
  // y koordinátája:
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

  // Kirajzolja az alakzatot:
  public abstract void draw(Graphics g);

}