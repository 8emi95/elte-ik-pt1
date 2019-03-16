/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * RoundedRect.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Lekerekített téglalap: bal felsõ sarka: (x,y), mérete: (width,height)
 * A kerekítés sugara: 15
 * Ha nem adják meg a width és height adatokat, akkor azok alapértelmezett
 * értékeket vesznek fel.
 */

package figures;
import java.awt.*;

public class RoundedRect extends Rect {
  private int rad = 15;

  public RoundedRect(int x, int y, boolean filled) {
    super(x,y,filled);
  }

  public RoundedRect(int x, int y, int width, int height, boolean filled) {
    super(x,y,width,height,filled);
  }

  public void draw(Graphics g) {
    g.setColor(color);
    if (filled)
      g.fillRoundRect(x,y,width,height,rad,rad);
    else
      g.drawRoundRect(x,y,width,height,rad,rad);
  }
}
