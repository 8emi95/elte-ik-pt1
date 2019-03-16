/*
 * Feladatmegoldások/18. fejezet
 * JegyVegzodes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class SzamStat {
  // Egy long szám jegyeinek a száma 1 és 10 között van:
  public static final byte MAXJEGY = 10;

  // Jegyek száma = 1..MAXJEGY, jegyvégzõdés = 0..9:
  private int[][] stat = new int[MAXJEGY+1][10];

  public static int jegyekSzama(int szam) {
    return (szam+"").length();
  }

  public void hozzaad(int szam) {
    stat[jegyekSzama(szam)][(int)(szam%10)]++;
  }

  public int adottJegyuEsVegzodesuSzamokSzama(int jegy, int vegz) {
    return stat[jegy][vegz];
  }

  public int adottVegzodesuSzamokSzama(int vegz) {
    int n=0;
    for (int i=0; i<stat.length; i++)
      n += stat[i][vegz];
    return n;
  }

  public int adottJegyuSzamokSzama(int jegySzam) {
    int n=0;
    for (int j=0; j<stat[jegySzam].length; j++)
      n += stat[jegySzam][j];
    return n;
  }
}

public class JegyVegzodes {
  public static void main(String[] args) {
    SzamStat szamStat = new SzamStat();

    // Számok bevitele:
    for (int i=0; i<5; i++)
      szamStat.hozzaad(Console.readInt("Szám: "));

    // Kimutatások:
    // a) összesen hány egyjegyû, kétjegyû stb. szám van; azon belül hány végzõdik 0-ra, 1-re, 2-re stb.;
    for (int i=1; i<=SzamStat.MAXJEGY; i++) {
      int osszesen = szamStat.adottJegyuSzamokSzama(i);
      if (osszesen == 0)
        continue;
      System.out.println(i+" jegyû számok:");
      for (int j=0; j<10; j++)
        System.out.print(Format.right(j,6));
      System.out.println(" (végzõdés)");
      for (int j=0; j<10; j++)
        System.out.print(Format.right(szamStat.adottJegyuEsVegzodesuSzamokSzama(i,j),6));
      System.out.println(" (darab)");
      System.out.println("Összesen: "+osszesen);
    }

    // b) összesen hány szám végzõdik 0-ra, 1-re, 2-re stb.; azon belül hány egyjegyû, kétjegyû stb. szám van.

    // c) hány olyan szám van, melyben a jegyek száma és a végzõdés a megadott;
    System.out.println(szamStat.adottJegyuEsVegzodesuSzamokSzama(
      Console.readInt("Jegyek száma: "),
      Console.readInt("Végzõdés: "))+" db");

    // d) hány olyan szám van, melyben a jegyek száma a megadott;
    System.out.println(szamStat.adottJegyuSzamokSzama(Console.readInt("Jegyek száma: "))+" db");

    // e) hány olyan szám van, melyben a végzõdés a megadott;
    System.out.println(szamStat.adottVegzodesuSzamokSzama(Console.readInt("Végzõdés: "))+" db");
  }
}
