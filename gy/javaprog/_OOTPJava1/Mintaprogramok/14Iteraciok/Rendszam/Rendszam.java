/*
 * Mintaprogramok/14. fejezet
 * Rendszam.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Rendszam {
  public static void main (String args[]) {
    char valasz;
    do {
      byte rendszamHossz;
      long ennyiKell = Console.readInt("Hány rendszámtábla kell? ");
      if (ennyiKell<=0)
        System.out.println("Nem kell rendszámtábla.");
      else {
        long ennyiLehet = 36;
        for (rendszamHossz = 1; ennyiLehet < ennyiKell; rendszamHossz++)
          ennyiLehet *= 36;
        System.out.println(rendszamHossz+" hosszú lesz a tábla.");
      }
      valasz = Console.readChar("Folytatod? I/N ");
    } while ((valasz!='N') & (valasz!='n'));
  }
}
