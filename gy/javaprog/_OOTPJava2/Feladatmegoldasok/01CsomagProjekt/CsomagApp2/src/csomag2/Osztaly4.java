/*
 * Feladatmegoldások/1. fejezet
 * Projekt: CsomapApp2
 * Osztaly4.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package csomag2;
import csomag2.csomag21.*;

public class Osztaly4 implements Interfesz1 {
  public String interfesz1() {
    return "Interfesz1 ";
  }
  public String toString() {
    return "Osztaly4 " + interfesz1();
  }
}
