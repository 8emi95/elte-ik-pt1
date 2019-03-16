/*
 * Feladatmegoldások/13. fejezet
 * Dolgozat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Dolgozat {
  public static void main(String[] args) {
    int pontszam = Console.readInt("Pontszám (0..55): ");
    if (pontszam<0 || pontszam>55)
      System.out.println("Ez nem valódi pontszám!");
    else if (pontszam>=0 && pontszam<=29)
      System.out.println("Osztályzat: elégtelen (1)");
    else if (pontszam>=30 && pontszam<=37)
      System.out.println("Osztályzat: elégséges (2)");
    else if (pontszam>=38 && pontszam<=43)
      System.out.println("Osztályzat: közepes (3)");
    else if (pontszam>=44 && pontszam<=49)
      System.out.println("Osztályzat: jó (4)");
    else //if (pontszam>=50 && pontszam<=55)
      System.out.println("Osztályzat: jeles (5)");
  }
}
