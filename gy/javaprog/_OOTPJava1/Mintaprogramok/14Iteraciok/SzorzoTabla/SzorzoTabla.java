/*
 * Mintaprogramok/14. fejezet
 * SzorzoTabla.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Format;

public class SzorzoTabla {
  public static void main (String args[]) {
    System.out.println("        Szorzótábla");
    System.out.println("-------------------------------");

    for (int i=1; i<=9; i++) {
      // Egy sor írása:
      System.out.print(i+" |");
      for (int j=1; j<=9; j++)
        System.out.print(Format.right(i*j,3)); // igazitva irunk
      System.out.println();
    }
  }
}

