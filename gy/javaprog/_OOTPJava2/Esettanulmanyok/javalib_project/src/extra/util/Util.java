/*
 * javalib könyvtár
 *
 * Csomag: extra.util
 * Util.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Segédmetódusok
 */

package extra.util;

public class Util {
  // Az osztályból nem lehet példányt létrehozni:
  private Util() {
  }

  // ---------------------------------------------------------
  // Véletlen szám 0 és max között:
  public static int rnd(int max) {
    return (int)(Math.random()*max);
  }

  // ---------------------------------------------------------
  // Véletlen szám min és max között:
  static int rnd(int min, int max) {
    if (min > max) {
      int seged=min; max=min; min=seged;
    }
    return (int)(Math.random()*(max-min+1))+min;
  }

  // ---------------------------------------------------------
  // Késleltetés ezredmásodpercben megadva:
  public static void delay(long sec1000) {
    try {
      Thread.sleep(5);
    }
    catch (InterruptedException ex) {
    }
  }

  // ---------------------------------------------------------
  // Késleltetés egy másodpercig:
  public static void delay() {
    delay(1000);
  }

}

