/*
 * Feladatmegold�sok/14. fejezet
 * KettoKozott.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class KettoKozott {
  public static void main (String args[]) {
    char tol = Console.readChar("T�l: ");
    char ig = Console.readChar("Ig: ");
    if (tol > ig) {
      // tol �s ig cser�je:
      char seged = tol; tol = ig; ig = seged;
    }
    for (char kar=tol; kar<=ig; kar++)
      System.out.print(kar+" ");
  }
}
