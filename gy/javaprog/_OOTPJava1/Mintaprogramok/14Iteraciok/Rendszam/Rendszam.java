/*
 * Mintaprogramok/14. fejezet
 * Rendszam.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class Rendszam {
  public static void main (String args[]) {
    char valasz;
    do {
      byte rendszamHossz;
      long ennyiKell = Console.readInt("H�ny rendsz�mt�bla kell? ");
      if (ennyiKell<=0)
        System.out.println("Nem kell rendsz�mt�bla.");
      else {
        long ennyiLehet = 36;
        for (rendszamHossz = 1; ennyiLehet < ennyiKell; rendszamHossz++)
          ennyiLehet *= 36;
        System.out.println(rendszamHossz+" hossz� lesz a t�bla.");
      }
      valasz = Console.readChar("Folytatod? I/N ");
    } while ((valasz!='N') & (valasz!='n'));
  }
}
