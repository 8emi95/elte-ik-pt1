/*
 * Feladatmegoldások/14. fejezet
 * NegyzetSzamok2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class NegyzetSzamok2 {
  public static void main (String args[]) {
    final int HATAR = 1000;
    int db, negyzet;
    for (db=0; (negyzet=(int)Math.pow(db,2)) < HATAR; db++) {
      System.out.print(Format.right(negyzet,6)+" ");
      if ((db+1)%5==0)
        System.out.println();
    }
    System.out.println("\n\n"+HATAR+"-nél kisebb négyzetszámok száma: "+db);
  }
}
