/*
 * Mintaprogramok/14. fejezet
 * JegyekSzama.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class JegyekSzama {
  public static void main (String args[]) {
    int szam = Console.readInt("Szám: ");
    int seged = szam;
    int jegySzam = 0;
    do {
      seged /= 10;
      jegySzam++;
    } while (seged!=0);
    System.out.println(szam+" jegyeinek száma: "+jegySzam);
  }
}
