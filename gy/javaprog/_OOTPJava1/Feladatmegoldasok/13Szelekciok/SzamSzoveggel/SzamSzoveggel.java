/*
 * Feladatmegoldások/13. fejezet
 * SzamSzoveggel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class SzamSzoveggel {
  public static void main(String[] args) {
    int szam = Console.readInt("Egyjegyû nem negatív szám: ");
    if (szam<0 || szam>9)
      System.out.println("Nem egyjegyû, vagy negatív!");
    else {
      String szoveg = "";
      switch (szam) {
        case 0: szoveg = "nulla"; break;
        case 1: szoveg = "egy"; break;
        case 2: szoveg = "kettõ"; break;
        case 3: szoveg = "három"; break;
        case 4: szoveg = "négy"; break;
        case 5: szoveg = "öt"; break;
        case 6: szoveg = "hat"; break;
        case 7: szoveg = "hét"; break;
        case 8: szoveg = "nyolc"; break;
        case 9: szoveg = "kilenc"; break;
      }
      System.out.println(szam+" = "+szoveg);
    }
  }
}
