/*
 * Mintaprogramok/14. fejezet
 * JegyekSzama.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class JegyekSzama {
  public static void main (String args[]) {
    int szam = Console.readInt("Sz�m: ");
    int seged = szam;
    int jegySzam = 0;
    do {
      seged /= 10;
      jegySzam++;
    } while (seged!=0);
    System.out.println(szam+" jegyeinek sz�ma: "+jegySzam);
  }
}
