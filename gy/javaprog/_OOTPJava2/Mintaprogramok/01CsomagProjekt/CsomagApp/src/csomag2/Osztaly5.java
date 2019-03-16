/*
 * Mintaprogramok/1. fejezet
 * Projekt: CsomapApp
 * Osztaly5.java (fõosztály)
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
