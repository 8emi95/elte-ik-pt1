/*
 * Feladatmegoldások/14. fejezet
 * NullaJegyek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class NullaJegyek {
  public static void main (String args[]) {
    long szam = Console.readLong("Szám: ");
    long n = szam;
    int nullakSzama = 0;
    do {
      if (n%10==0)
        nullakSzama++;
      n /= 10;
    } while (n!=0);
    System.out.println(szam+"-ben "+nullakSzama+" nulla van.");
  }
}
