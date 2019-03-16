/*
 * Feladatmegold�sok/16. fejezet
 * KarEloszlas1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class KarEloszlas1 {

  public static void main(String[] args) {
    String szoveg = Console.readLine("Sz�veg: ");

    int nBetuk=0, nSzamok=0, nSzokozok=0;
    for (int i=0; i<szoveg.length(); i++) {
      if (Character.isLetter(szoveg.charAt(i)))
        nBetuk++;
      else if (Character.isDigit(szoveg.charAt(i)))
        nSzamok++;
      else if (Character.isWhitespace(szoveg.charAt(i)))
        nSzokozok++;
    }

    System.out.println("Bet�k sz�ma= "+nBetuk);
    System.out.println("Sz�mok sz�ma= "+nSzamok);
    System.out.println("Feh�r sz�k�z�k sz�ma= "+nSzokozok);
    System.out.println("Egy�b karakterek sz�ma= "+(szoveg.length()-nBetuk-nSzamok-nSzokozok));
  }
}
