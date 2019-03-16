/*
 * Feladatmegoldások/14. fejezet
 * KettoKozott.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class KettoKozott {
  public static void main (String args[]) {
    char tol = Console.readChar("Tól: ");
    char ig = Console.readChar("Ig: ");
    if (tol > ig) {
      // tol és ig cseréje:
      char seged = tol; tol = ig; ig = seged;
    }
    for (char kar=tol; kar<=ig; kar++)
      System.out.print(kar+" ");
  }
}
