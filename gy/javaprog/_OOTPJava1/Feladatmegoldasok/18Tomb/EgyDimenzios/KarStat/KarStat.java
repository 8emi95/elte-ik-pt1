/*
 * Feladatmegoldások/18. fejezet
 * KarStat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class KarStat {

  static void statisztika(String szoveg) {
    int[] nagyBetuk = new int[26];  // 'A'..'Z', csak a nagybetûk részére
    int[] betuk = new int[26];      // 'A'..'Z', mindegy, hogy kisbetû vagy nagybetû
    int[] szamjegyek = new int[10]; // '0'..'9'
    int[] ascii = new int[256];     // ASCII karakterek részére

    // Az összes kategória gyûjtése betûnként:
    char kar;
    for (int i=0; i<szoveg.length(); i++) {
     // A soronkövetkezõ karakter:
      kar = szoveg.charAt(i);

      // Ha a karakter nagybetû:
      if (Character.isUpperCase(kar))
        nagyBetuk[kar-'A']++;

      // Ha a karakter betû, mindegy, hogy kicsi vagy nagy:
      char nagyKar = Character.toUpperCase(kar);
      if (nagyKar>='A' && nagyKar<='Z')
        betuk[nagyKar-'A']++;

      // Ha a karakter számjegy:
      if (Character.isDigit(kar))
        szamjegyek[kar-'0']++;

      // Ha a karakter bármilyen ASCII karakter:
      ascii[kar]++;
    }

    // Eredmény kiírása:
    System.out.println("Nagybetûk");
    for (int i=0; i<nagyBetuk.length; i++) {
      if (nagyBetuk[i] != 0)
        System.out.println((char)(i+'A')+": "+nagyBetuk[i]);
    }

    System.out.println("Betûk");
    for (int i=0; i<betuk.length; i++) {
      if (betuk[i] != 0)
        System.out.println((char)(i+'A')+": "+betuk[i]);
    }

    System.out.println("Számjegyek");
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
    statisztika(Console.readLine("Szöveg: "));
  }
}
