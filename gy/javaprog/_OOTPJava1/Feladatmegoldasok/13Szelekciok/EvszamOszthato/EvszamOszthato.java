/*
 * Feladatmegoldások/13. fejezet
 * EvszamOszthato.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class EvszamOszthato {
  public static void main(String[] args) {
    int evszam = Console.readInt("Évszám: ");
    if (evszam < 0)
      System.out.println("Negatív, nem jó évszám!");
    else {
      if (evszam%17==0)
        System.out.println(evszam + " osztható 17-tel.");
      else
        System.out.println(evszam + " nem osztható 17-tel.");
    }
  }
}
