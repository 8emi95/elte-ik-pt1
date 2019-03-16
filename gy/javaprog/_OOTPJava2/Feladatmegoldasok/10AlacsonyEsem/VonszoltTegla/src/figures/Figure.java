/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: VonszoltTegla
 * Csomag: figures
 * Figure.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Az alakzatot (s�kidomot) a startPoint �s az endPoint �ltal meghat�rozott t�glalap hat�rolja.
 * startPoint �s endPoint az alakzat ellent�tes sarkai.
 * startPoint r�gz�tett, azt a konstruktorban kell megadni.
 * endPoint v�ltoz� sarok, azt a setEndPoint met�dussal lehet be�ll�tani.
 * A k�t pont tetsz�leges helyen lehet.
 * Az alakzat kirajzol�s�t a lesz�rmazott oszt�lyban kell megadni.
 */

package figures;
import java.awt.*;

public abstract class Figure {
  protected Point startPoint;
  protected Point endPoint;

  // Konstruktor. Kezdetben a kezd�pont �s a v�gpont egybeesik.
  // A v�gpontot majd a setEndPoint met�dussal lehet �ll�tani:
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

  // A k�t pont �ltal meghat�rozott t�glalap bal fels� sark�nak
  // x koordin�t�ja:
  public int x() {
    return Math.min(startPoint.x,endPoint.x);
  }

  // A k�t pont �ltal meghat�rozott t�glalap bal fels� sark�nak
  // y koordin�t�ja:
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

  // Kirajzolja az alakzatot:
  public abstract void draw(Graphics g);

}