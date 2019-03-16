/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Line.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Egyenes az (x,y) �s az (x+width,y+height) pontok k�z�tt.
 * Ha nem adj�k meg a width �s height adatokat, akkor azok alap�rtelmezett
 * �rt�keket vesznek fel.
 */

package figures;
import java.awt.*;

public class Line extends Figure {

  public Line(int x, int y, int width, int height) {
    super(x,y,width,height);
  }

  public Line(int x, int y) {
    super(x,y);
  }

  public void draw(Graphics g) {
    g.setColor(color);
    g.drawLine(x,y,x+width,y+height);
  }
}
