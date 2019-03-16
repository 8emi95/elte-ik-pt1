/*
 * Feladatmegold�sok/1. fejezet
 * Projekt: CsomapApp2
 * Osztaly3.java (f�oszt�ly)
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
 *
 * FIGYELEM!
 * Az Osztaly3 oszt�ly a csomag1 csomagban szerepel
 * (nem a csomag1.csomag11-ben), �s ez a f�oszt�ly!
 */

package csomag1;
import csomag1.csomag11.Osztaly2;
import extra.Console;

public class Osztaly3 extends Osztaly2 {
  Osztaly2 obj2 = new Osztaly2();

  public String toString() {
    return "Osztaly3 " + obj2;
  }
  public static void main(String[] args) {
    System.out.println("CsomagApp2 fut...");
    System.out.println(new Osztaly3());
    Console.pressEnter();
  }
}
