/*
 * Feladatmegold�sok/14. fejezet
 * NegyzetSzamok1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class NegyzetSzamok1 {
  public static void main (String args[]) {
    final int HATAR = 1000;
    int db=0, negyzet;
    while ((negyzet=db*db) < HATAR) {
      // db. n�gyzetsz�m ki�r�sa:
      db++;
      System.out.print(Format.right(negyzet,6)+" ");
      if (db%5==0)
        System.out.println();
    }
    System.out.println("\n\n"+HATAR+"-n�l kisebb n�gyzetsz�mok sz�ma: "+db);
  }
}
