/*
 * Feladatmegoldások/14. fejezet
 * SzamlaKifizetes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class SzamlaKifizetes {
  public static void main (String args[]) {
    int hatar = Console.readInt("Mennyi pénzed van? ");
    int osszesen=0;
    int szamlakSzama=0;
    while (true) {
      if (szamlakSzama >= 10) {
        System.out.println("\nA szamlák száma már 10!");
        break;
      }
      int osszeg = Console.readInt("Számla összeg: ");
      if (osszesen + osszeg > hatar) {
        System.out.println("\nErre már nincs pénz!");
        break;
      }
      szamlakSzama++;
      osszesen += osszeg;
    }

    System.out.println("Számlák száma: "+szamlakSzama);
    System.out.println("Fizetendõ összeg: "+osszesen);
  }
}
