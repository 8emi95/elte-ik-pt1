/*
 * Projekt: TiliToli
 * Config.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Konfigur�ci�s oszt�ly. A j�t�knak a felhaszn�l� �ltal be�ll�that�
 * param�tereit tartalmazza.
 */

package play;

import java.io.Serializable;
import java.awt.Rectangle;

public class Config implements Serializable {
  public int playMode = 0; // 3*3-as j�t�k

  // Azon j�t�kosok maxim�lis sz�ma, akik eredm�nyei elt�rol�sra ker�lnek:
  public int[] maxNumberOfResults = {3,10,10};

  /* A j�t�k m�rete. A program megjegyzi a felhaszn�l� �ltal �t�ll�tott
   * ablakm�retet:
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
