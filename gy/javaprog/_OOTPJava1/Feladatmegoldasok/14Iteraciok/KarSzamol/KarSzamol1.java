/*
 * Feladatmegold�sok/14. fejezet
 * KarSzamol1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class KarSzamol1 {
  public static void main (String args[]) {
    char VEGJEL = '-';
    int nagy=0, kis=0, szam=0, egyeb=0;
    char kar;
    while ((kar = Console.readChar("Karakter: ")) != VEGJEL) {
      if (kar>='A' && kar<='Z')
        nagy++;
      else if (kar>='a' && kar<='z')
        kis++;
      else if (kar>='0' && kar<='9')
        szam++;
      else
        egyeb++;
    }

    System.out.println("Nagybet�k sz�ma: "+nagy);
    System.out.println("Kisbet�k sz�ma: "+kis);
    System.out.println("Sz�mjegyek sz�ma: "+szam);
    System.out.println("Egy�b karakterek sz�ma: "+egyeb);
  }
}
