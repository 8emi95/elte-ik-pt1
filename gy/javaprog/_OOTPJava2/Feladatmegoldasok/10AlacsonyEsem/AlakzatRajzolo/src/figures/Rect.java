/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Rect.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * T�glalap: bal fels� sarka: (x,y), m�rete: (width,height)
 * Ha nem adj�k meg a width �s height adatokat, akkor azok alap�rtelmezett
 * �rt�keket vesznek fel.
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
