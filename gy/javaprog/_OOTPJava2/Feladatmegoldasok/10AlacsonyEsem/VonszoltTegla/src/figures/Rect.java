/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: VonszoltTegla
 * Csomag: figures
 * Rect.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * A t�glalap kezd�pontj�t a konstruktorban adhatjuk meg, a v�gpontj�t
 * a setEndPoint met�dussal.
 */

package figures;
import java.awt.*;

public class Rect extends Figure {

  public Rect(Point startPoint) {
    super(startPoint);
  }

  // A t�glalap kirajzol�sa:
  public void draw(Graphics g) {
    g.drawRect(x(),y(),width(),height());
  }
}

