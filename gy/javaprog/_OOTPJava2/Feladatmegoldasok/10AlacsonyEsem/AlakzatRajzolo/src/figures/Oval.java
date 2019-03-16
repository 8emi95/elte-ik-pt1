/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Oval.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Ellipszis, mely az (x,y,x+width,y+height) t�glalapba �rhat�.
 * Ha nem adj�k meg a width �s height adatokat, akkor azok alap�rtelmezett
 * �rt�keket vesznek fel.
 */

package figures;
import java.awt.*;

public class Oval extends Figure {
  protected boolean filled;

  public Oval(int x, int y, boolean filled) {
    super(x,y);
    this.filled = filled;
  }

  public Oval(int x, int y, int width, int height, boolean filled) {
    super(x,y,width,height);
    this.filled = filled;
  }

  public void draw(Graphics g) {
    g.setColor(color);
    if (filled)
      g.fillOval(x,y,width,height);
    else
      g.drawOval(x,y,width,height);
  }
}
