/*
 * Feladatmegold�sok/18. fejezet
 * KarStat.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class KarStat {

  static void statisztika(String szoveg) {
    int[] nagyBetuk = new int[26];  // 'A'..'Z', csak a nagybet�k r�sz�re
    int[] betuk = new int[26];      // 'A'..'Z', mindegy, hogy kisbet� vagy nagybet�
    int[] szamjegyek = new int[10]; // '0'..'9'
    int[] ascii = new int[256];     // ASCII karakterek r�sz�re

    // Az �sszes kateg�ria gy�jt�se bet�nk�nt:
    char kar;
    for (int i=0; i<szoveg.length(); i++) {
     // A soronk�vetkez� karakter:
      kar = szoveg.charAt(i);

      // Ha a karakter nagybet�:
      if (Character.isUpperCase(kar))
        nagyBetuk[kar-'A']++;

      // Ha a karakter bet�, mindegy, hogy kicsi vagy nagy:
      char nagyKar = Character.toUpperCase(kar);
      if (nagyKar>='A' && nagyKar<='Z')
        betuk[nagyKar-'A']++;

      // Ha a karakter sz�mjegy:
      if (Character.isDigit(kar))
        szamjegyek[kar-'0']++;

      // Ha a karakter b�rmilyen ASCII karakter:
      ascii[kar]++;
    }

    // Eredm�ny ki�r�sa:
    System.out.println("Nagybet�k");
    for (int i=0; i<nagyBetuk.length; i++) {
      if (nagyBetuk[i] != 0)
        System.out.println((char)(i+'A')+": "+nagyBetuk[i]);
    }

    System.out.println("Bet�k");
    for (int i=0; i<betuk.length; i++) {
      if (betuk[i] != 0)
        System.out.println((char)(i+'A')+": "+betuk[i]);
    }

    System.out.println("Sz�mjegyek");
    for (int i=0; i<szamjegyek.length; i++) {
      if (szamjegyek[i] != 0)
        System.out.println((char)(i+'0')+": "+szamjegyek[i]);
    }

    System.out.println("ASCII karakterek");
    for (int i=0; i<ascii.length; i++) {
      if (ascii[i] != 0)
        System.out.println((char)i+": "+ascii[i]);
    }
  }

  public static void main(String[] args) {
    statisztika(Console.readLine("Sz�veg: "));
  }
}
