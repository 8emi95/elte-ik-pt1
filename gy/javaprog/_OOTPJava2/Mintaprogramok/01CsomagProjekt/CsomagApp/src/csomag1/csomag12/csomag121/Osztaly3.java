/*
 * Mintaprogramok/1. fejezet
 * Projekt: CsomapApp
 * Osztaly3.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package csomag1.csomag12.csomag121;
import csomag1.csomag11.Interfesz1;

public class Osztaly3 implements Interfesz1 {
  public String interfesz1() {
    return "Interfesz1 ";
  }
  public String toString() {
    return "Osztaly3 " + interfesz1();
  }
}
