/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * RoundedRect.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Lekerek�tett t�glalap: bal fels� sarka: (x,y), m�rete: (width,height)
 * A kerek�t�s sugara: 15
 * Ha nem adj�k meg a width �s height adatokat, akkor azok alap�rtelmezett
 * �rt�keket vesznek fel.
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
