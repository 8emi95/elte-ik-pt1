/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Figure.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Minden alakzat absztrakt �se. Megadhat� a bal fels� sarka, m�rete �s a sz�ne.
 * A konkr�t alakzatnak meg kell �rni a draw met�dust�t.
 */

package figures;
import java.awt.*;

public abstract class Figure {
  protected int x, y;
  protected int width, height;
  protected Color color;

  public Figure(int x, int y) {
    this(x,y,30,20);
  }

  public Figure(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    color = Color.black;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color=color;
  }

  public abstract void draw(Graphics g);
}
