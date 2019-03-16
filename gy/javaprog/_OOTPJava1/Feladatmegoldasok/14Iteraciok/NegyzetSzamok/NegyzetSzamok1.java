/*
 * Feladatmegoldások/14. fejezet
 * NegyzetSzamok1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class NegyzetSzamok1 {
  public static void main (String args[]) {
    final int HATAR = 1000;
    int db=0, negyzet;
    while ((negyzet=db*db) < HATAR) {
      // db. négyzetszám kiírása:
      db++;
      System.out.print(Format.right(negyzet,6)+" ");
      if (db%5==0)
        System.out.println();
    }
    System.out.println("\n\n"+HATAR+"-nél kisebb négyzetszámok száma: "+db);
  }
}
