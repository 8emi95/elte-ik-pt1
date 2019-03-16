/*
 * Feladatmegoldások/1. fejezet
 * Projekt: CsomapApp2
 * Osztaly3.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 *
 * Szabályok:
 * InterfeszI minden esetben egyetlen metódust definiál:
 * public String interfeszI()
 *    visszaadott értéke: "InterfeszI "
 *
 * toString() képzési szabálya:
 * Saját osztálynév + õs toString() + interfeszI() + kapcsolati objektumok
 *    (ha a megfelelõ összetevõnek van értelme)
 *
 * FIGYELEM!
 * Az Osztaly3 osztály a csomag1 csomagban szerepel
 * (nem a csomag1.csomag11-ben), és ez a fõosztály!
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
