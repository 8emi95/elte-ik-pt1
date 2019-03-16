/*
 * Feladatmegold�sok/14. fejezet
 * SzamlaKifizetes.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class SzamlaKifizetes {
  public static void main (String args[]) {
    int hatar = Console.readInt("Mennyi p�nzed van? ");
    int osszesen=0;
    int szamlakSzama=0;
    while (true) {
      if (szamlakSzama >= 10) {
        System.out.println("\nA szaml�k sz�ma m�r 10!");
        break;
      }
      int osszeg = Console.readInt("Sz�mla �sszeg: ");
      if (osszesen + osszeg > hatar) {
        System.out.println("\nErre m�r nincs p�nz!");
        break;
      }
      szamlakSzama++;
      osszesen += osszeg;
    }

    System.out.println("Sz�ml�k sz�ma: "+szamlakSzama);
    System.out.println("Fizetend� �sszeg: "+osszesen);
  }
}
