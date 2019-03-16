/*
 * Feladatmegoldások/14. fejezet
 * Haromszog.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Haromszog {
  public static void main (String args[]) {
    int sorokSzama = Console.readInt("Sorok száma: ");
    for (int sor=1; sor<=sorokSzama; sor++) {
      for (int oszlop=1; oszlop<=sor; oszlop++)
        System.out.print(Format.right(oszlop,3));
      System.out.println();
    }
  }
}
