/*
 * Feladatmegoldások/16. fejezet
 * KarEloszlas1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class KarEloszlas1 {

  public static void main(String[] args) {
    String szoveg = Console.readLine("Szöveg: ");

    int nBetuk=0, nSzamok=0, nSzokozok=0;
    for (int i=0; i<szoveg.length(); i++) {
      if (Character.isLetter(szoveg.charAt(i)))
        nBetuk++;
      else if (Character.isDigit(szoveg.charAt(i)))
        nSzamok++;
      else if (Character.isWhitespace(szoveg.charAt(i)))
        nSzokozok++;
    }

    System.out.println("Betûk száma= "+nBetuk);
    System.out.println("Számok száma= "+nSzamok);
    System.out.println("Fehér szóközök száma= "+nSzokozok);
    System.out.println("Egyéb karakterek száma= "+(szoveg.length()-nBetuk-nSzamok-nSzokozok));
  }
}
