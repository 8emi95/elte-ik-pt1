/*
 * Feladatmegold�sok/14. fejezet
 * Primek1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class Primek1 {
  public static void main (String args[]) {
    int hatar = Console.readInt("Meddig? ");
    int primekSzama = 0;

    for (int szam=2; szam<hatar; szam++) {
      boolean oszthato = false;
      for (int oszto=2; oszto <= Math.sqrt(szam) && !oszthato; oszto++)
        oszthato = szam%oszto == 0;
      if (!oszthato) {
        System.out.println(++primekSzama+". pr�m: "+szam);
        if (primekSzama%20==0)
          Console.pressEnter();
      }
    }
  }
}
