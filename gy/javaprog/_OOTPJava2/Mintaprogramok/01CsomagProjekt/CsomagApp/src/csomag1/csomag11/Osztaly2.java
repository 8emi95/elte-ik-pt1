/*
 * Mintaprogramok/1. fejezet
 * Projekt: CsomapApp
 * Osztaly2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package csomag1.csomag11;

class Osztaly1 implements Interfesz1 {
  public String interfesz1() {
    return "Interfesz1 ";
  }

  public String toString() {
    return "Osztaly1 " + interfesz1();
  }
}

public class Osztaly2 extends Osztaly1 {
  public String toString() {
    return "Osztaly2 " + super.toString();
  }
}
