/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Line.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Egyenes az (x,y) és az (x+width,y+height) pontok között.
 * Ha nem adják meg a width és height adatokat, akkor azok alapértelmezett
 * értékeket vesznek fel.
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
