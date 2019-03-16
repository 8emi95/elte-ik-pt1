/*
 * javalib k�nyvt�r
 *
 * Csomag: extra.util
 * Util.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Seg�dmet�dusok
 */

package extra.util;

public class Util {
  // Az oszt�lyb�l nem lehet p�ld�nyt l�trehozni:
  private Util() {
  }

  // ---------------------------------------------------------
  // V�letlen sz�m 0 �s max k�z�tt:
  public static int rnd(int max) {
    return (int)(Math.random()*max);
  }

  // ---------------------------------------------------------
  // V�letlen sz�m min �s max k�z�tt:
  static int rnd(int min, int max) {
    if (min > max) {
      int seged=min; max=min; min=seged;
    }
    return (int)(Math.random()*(max-min+1))+min;
  }

  // ---------------------------------------------------------
  // K�sleltet�s ezredm�sodpercben megadva:
  public static void delay(long sec1000) {
    try {
      Thread.sleep(5);
    }
    catch (InterruptedException ex) {
    }
  }

  // ---------------------------------------------------------
  // K�sleltet�s egy m�sodpercig:
  public static void delay() {
    delay(1000);
  }

}

