/*
 * Feladatmegold�sok/13. fejezet
 * FonokFizetese.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class FonokFizetese {
  public static void main(String[] args) {
    long fizFonok = Console.readLong("F�n�k�nek fizet�se: ");
    long fizSajat = Console.readLong("�n fizet�se: ");
    if (fizFonok > fizSajat)
      System.out.println("A f�n�k fizet�se nagyobb, ez nem meglep�!");
    else if (fizFonok < fizSajat)
      System.out.println("T�bbet keresek, mint a f�n�k! Mi van itten?");
    else
      System.out.println("Ugyanannyit keresek, mint a f�n�k!");
  }
}
