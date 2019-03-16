/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: figures
 * Figure.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Minden alakzat absztrakt õse. Megadható a bal felsõ sarka, mérete és a színe.
 * A konkrét alakzatnak meg kell írni a draw metódustát.
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
