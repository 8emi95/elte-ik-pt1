/*
 * Feladatmegoldások/10. fejezet
 * Projekt: VonszoltTegla
 * Csomag: figures
 * Rect.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * A téglalap kezdõpontját a konstruktorban adhatjuk meg, a végpontját
 * a setEndPoint metódussal.
 */

package figures;
import java.awt.*;

public class Rect extends Figure {

  public Rect(Point startPoint) {
    super(startPoint);
  }

  // A téglalap kirajzolása:
  public void draw(Graphics g) {
    g.drawRect(x(),y(),width(),height());
  }
}

