/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Rect.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Téglalap: bal felsõ sarka: (x,y), mérete: (width,height)
 * Ha nem adják meg a width és height adatokat, akkor azok alapértelmezett
 * értékeket vesznek fel.
 */

package figures;
import java.awt.*;

public class Rect extends Figure {
  protected boolean filled;

  public Rect(int x, int y, boolean filled) {
    super(x,y);
    this.filled = filled;
  }

  public Rect(int x, int y, int width, int height, boolean filled) {
    super(x,y,width,height);
    this.filled = filled;
  }

  public void draw(Graphics g) {
    g.setColor(color);
    if (filled)
      g.fillRect(x,y,width,height);
    else
      g.drawRect(x,y,width,height);
  }
}
