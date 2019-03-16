/*
 * Feladatmegoldások/13. fejezet
 * FonokFizetese.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class FonokFizetese {
  public static void main(String[] args) {
    long fizFonok = Console.readLong("Fõnökének fizetése: ");
    long fizSajat = Console.readLong("Ön fizetése: ");
    if (fizFonok > fizSajat)
      System.out.println("A fõnök fizetése nagyobb, ez nem meglepõ!");
    else if (fizFonok < fizSajat)
      System.out.println("Többet keresek, mint a fõnök! Mi van itten?");
    else
      System.out.println("Ugyanannyit keresek, mint a fõnök!");
  }
}
