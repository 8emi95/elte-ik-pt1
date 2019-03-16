/* 
 * Feladatmegoldások/14. fejezet
 * Primek2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Primek2 {
  public static void main (String args[]) {
    int hatar = Console.readInt("Meddig? ");
    int primekSzama = 0;

    for (int szam=2; szam<hatar; szam++) {
      int oszto;
      for (oszto=2; oszto <= Math.sqrt(szam) && szam%oszto != 0; oszto++) ;
      if (oszto > Math.sqrt(szam)) {
        System.out.println(++primekSzama+". prim: "+szam);
        if (primekSzama%20==0)
          Console.pressEnter();
      }
    } 
  }
}
