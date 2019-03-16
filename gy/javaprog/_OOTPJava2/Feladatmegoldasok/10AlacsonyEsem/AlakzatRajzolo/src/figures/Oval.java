/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Oval.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Ellipszis, mely az (x,y,x+width,y+height) téglalapba írható.
 * Ha nem adják meg a width és height adatokat, akkor azok alapértelmezett
 * értékeket vesznek fel.
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
