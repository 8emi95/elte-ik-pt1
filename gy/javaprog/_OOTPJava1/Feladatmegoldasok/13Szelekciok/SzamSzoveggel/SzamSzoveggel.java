/*
 * Feladatmegold�sok/13. fejezet
 * SzamSzoveggel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class SzamSzoveggel {
  public static void main(String[] args) {
    int szam = Console.readInt("Egyjegy� nem negat�v sz�m: ");
    if (szam<0 || szam>9)
      System.out.println("Nem egyjegy�, vagy negat�v!");
    else {
      String szoveg = "";
      switch (szam) {
        case 0: szoveg = "nulla"; break;
        case 1: szoveg = "egy"; break;
        case 2: szoveg = "kett�"; break;
        case 3: szoveg = "h�rom"; break;
        case 4: szoveg = "n�gy"; break;
        case 5: szoveg = "�t"; break;
        case 6: szoveg = "hat"; break;
        case 7: szoveg = "h�t"; break;
        case 8: szoveg = "nyolc"; break;
        case 9: szoveg = "kilenc"; break;
      }
      System.out.println(szam+" = "+szoveg);
    }
  }
}
