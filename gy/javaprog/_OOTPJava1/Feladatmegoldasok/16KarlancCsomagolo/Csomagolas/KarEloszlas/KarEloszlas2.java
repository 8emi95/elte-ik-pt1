/*
 * Feladatmegold�sok/16. fejezet
 * KarEloszlas2.java (M�sodik megold�s)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class KarEloszlas2 {

  static int hanyBetu(String szoveg) {
    int n = 0;
    for (int i=0; i<szoveg.length(); i++)
      if (Character.isLetter(szoveg.charAt(i)))
        n++;
    return n;
  }

  static int hanySzam(String szoveg) {
    int n = 0;
    for (int i=0; i<szoveg.length(); i++)
      if (Character.isDigit(szoveg.charAt(i)))
        n++;
    return n;
  }

  static int hanyFeherszokoz(String szoveg) {
    int n = 0;
    for (int i=0; i<szoveg.length(); i++)
      if (Character.isWhitespace(szoveg.charAt(i)))
        n++;
    return n;
  }

  public static void main(String[] args) {
    String szoveg = Console.readLine("Sz�veg: ");

    int nBetuk=0, nSzamok=0, nSzokozok=0;
    System.out.println("Bet�k sz�ma= "+(nBetuk=hanyBetu(szoveg)));
    System.out.println("Sz�mok sz�ma= "+(nSzamok=hanySzam(szoveg)));
    System.out.println("Feh�r sz�k�z�k sz�ma= "+(nSzokozok=hanyFeherszokoz(szoveg)));
    System.out.println("Egy�b karakterek sz�ma= "+(szoveg.length()-nBetuk-nSzamok-nSzokozok));
  }
}
