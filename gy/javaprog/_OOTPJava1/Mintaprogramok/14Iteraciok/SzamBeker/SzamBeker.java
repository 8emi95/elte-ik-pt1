/*
 * Mintaprogramok/14. fejezet
 * SzamBeker.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class SzamBeker {
  public static void main (String args[]) {
    int szam;
    boolean ok;
    System.out.println("Sz�m (1..31)");
    do {
      szam = Console.readInt();
      // A sz�m vizsg�lata:
      ok = szam>=1 && szam<=31;  // a sz�m vizsg�lata
      if (!ok)
        System.out.println("Nem j�, m�gegyszer!");
    } while (!ok);
    System.out.println("J�. V�ge.");
  }
}

