/*
 * Mintaprogramok/1. fejezet
 * Projekt: CsomapApp
 * Osztaly5.java (f�oszt�ly)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 *
 * Szab�lyok:
 * InterfeszI minden esetben egyetlen met�dust defini�l:
 * public String interfeszI()
 *    visszaadott �rt�ke: "InterfeszI "
 *
 * toString() k�pz�si szab�lya:
 * Saj�t oszt�lyn�v + �s toString() + interfeszI() + kapcsolati objektumok
 *    (ha a megfelel� �sszetev�nek van �rtelme)
 */

package csomag2;
import csomag1.csomag12.*;
import csomag1.csomag11.*;
import extra.Console;

public class Osztaly5 {
  Osztaly2 obj2 = new Osztaly2();
  Osztaly4 obj4 = new Osztaly4();

  public String toString() {
    return "Osztaly5 " + obj2 + "" + obj4;
  }

  public static void main(String[] args) {
    System.out.println("CsomagApp fut...");
    System.out.println(new Osztaly5());
    Console.pressEnter();
  }
}
