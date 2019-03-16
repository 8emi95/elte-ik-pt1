/*
 * Mintaprogramok/14. fejezet
 * SzamBeker.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class SzamBeker {
  public static void main (String args[]) {
    int szam;
    boolean ok;
    System.out.println("Szám (1..31)");
    do {
      szam = Console.readInt();
      // A szám vizsgálata:
      ok = szam>=1 && szam<=31;  // a szám vizsgálata
      if (!ok)
        System.out.println("Nem jó, mégegyszer!");
    } while (!ok);
    System.out.println("Jó. Vége.");
  }
}

