/*
 * Projekt: TiliToli
 * Config.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Konfigurációs osztály. A játéknak a felhasználó által beállítható
 * paramétereit tartalmazza.
 */

package play;

import java.io.Serializable;
import java.awt.Rectangle;

public class Config implements Serializable {
  public int playMode = 0; // 3*3-as játék

  // Azon játékosok maximális száma, akik eredményei eltárolásra kerülnek:
  public int[] maxNumberOfResults = {3,10,10};

  /* A játék mérete. A program megjegyzi a felhasználó által átállított
   * ablakméretet:
   */
  public Rectangle bounds = new Rectangle(300,200,300,300);

  public int rows() {
    return playMode+3;
  }

  public int cols() {
    return playMode+3;
  }

  public String toString() {
    return rows() + "*" + cols() + ", " + "(" +
        maxNumberOfResults[0] + "," +
        maxNumberOfResults[1] + "," +
        maxNumberOfResults[2] + ")" +
      ", ("+bounds.getX()+","+bounds.getY()+
      ","+bounds.getWidth()+","+bounds.getHeight()+")";
  }
} // Config
