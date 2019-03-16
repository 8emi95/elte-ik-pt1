/*
 * Feladatmegold�sok/14. fejezet
 * Haromszog.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Haromszog {
  public static void main (String args[]) {
    int sorokSzama = Console.readInt("Sorok sz�ma: ");
    for (int sor=1; sor<=sorokSzama; sor++) {
      for (int oszlop=1; oszlop<=sor; oszlop++)
        System.out.print(Format.right(oszlop,3));
      System.out.println();
    }
  }
}
