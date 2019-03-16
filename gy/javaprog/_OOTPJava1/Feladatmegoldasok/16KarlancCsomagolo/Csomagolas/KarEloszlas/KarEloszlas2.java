/*
 * Feladatmegoldások/16. fejezet
 * KarEloszlas2.java (Második megoldás)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
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
    String szoveg = Console.readLine("Szöveg: ");

    int nBetuk=0, nSzamok=0, nSzokozok=0;
    System.out.println("Betûk száma= "+(nBetuk=hanyBetu(szoveg)));
    System.out.println("Számok száma= "+(nSzamok=hanySzam(szoveg)));
    System.out.println("Fehér szóközök száma= "+(nSzokozok=hanyFeherszokoz(szoveg)));
    System.out.println("Egyéb karakterek száma= "+(szoveg.length()-nBetuk-nSzamok-nSzokozok));
  }
}
