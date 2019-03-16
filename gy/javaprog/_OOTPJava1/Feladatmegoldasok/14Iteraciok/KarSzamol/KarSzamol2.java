/*
 * Feladatmegold�sok/14. fejezet
 * KarSzamol2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class KarSzamol2 {
  public static void main (String args[]) {
    // megold�s a Character csomagol� oszt�llyal, l�sd 16. fejezet
    char VEGJEL = '-';
    int nagy=0, kis=0, szam=0, egyeb=0;
    char kar;
    while ((kar = Console.readChar("Karakter: ")) != VEGJEL) {
      if (Character.isUpperCase(kar))
        nagy++;
      else if (Character.isLowerCase(kar))
        kis++;
      else if (Character.isDigit(kar))
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
