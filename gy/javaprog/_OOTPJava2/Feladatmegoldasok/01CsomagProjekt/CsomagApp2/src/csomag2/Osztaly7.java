/*
 * Feladatmegold�sok/1. fejezet
 * Projekt: CsomapApp2
 * Osztaly7.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package csomag2;
import csomag2.csomag21.Interfesz2;

public class Osztaly7 extends Osztaly4 implements Interfesz2 {
  public String interfesz2() {
    return "Interfesz2 ";
  }
  public String toString() {
    return "Osztaly7 " + super.toString() + interfesz2();
  }
}
