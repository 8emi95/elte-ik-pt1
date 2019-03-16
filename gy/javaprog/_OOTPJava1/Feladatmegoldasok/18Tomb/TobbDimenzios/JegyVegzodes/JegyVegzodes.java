/*
 * Feladatmegold�sok/18. fejezet
 * JegyVegzodes.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class SzamStat {
  // Egy long sz�m jegyeinek a sz�ma 1 �s 10 k�z�tt van:
  public static final byte MAXJEGY = 10;

  // Jegyek sz�ma = 1..MAXJEGY, jegyv�gz�d�s = 0..9:
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

    // Sz�mok bevitele:
    for (int i=0; i<5; i++)
      szamStat.hozzaad(Console.readInt("Sz�m: "));

    // Kimutat�sok:
    // a) �sszesen h�ny egyjegy�, k�tjegy� stb. sz�m van; azon bel�l h�ny v�gz�dik 0-ra, 1-re, 2-re stb.;
    for (int i=1; i<=SzamStat.MAXJEGY; i++) {
      int osszesen = szamStat.adottJegyuSzamokSzama(i);
      if (osszesen == 0)
        continue;
      System.out.println(i+" jegy� sz�mok:");
      for (int j=0; j<10; j++)
        System.out.print(Format.right(j,6));
      System.out.println(" (v�gz�d�s)");
      for (int j=0; j<10; j++)
        System.out.print(Format.right(szamStat.adottJegyuEsVegzodesuSzamokSzama(i,j),6));
      System.out.println(" (darab)");
      System.out.println("�sszesen: "+osszesen);
    }

    // b) �sszesen h�ny sz�m v�gz�dik 0-ra, 1-re, 2-re stb.; azon bel�l h�ny egyjegy�, k�tjegy� stb. sz�m van.

    // c) h�ny olyan sz�m van, melyben a jegyek sz�ma �s a v�gz�d�s a megadott;
    System.out.println(szamStat.adottJegyuEsVegzodesuSzamokSzama(
      Console.readInt("Jegyek sz�ma: "),
      Console.readInt("V�gz�d�s: "))+" db");

    // d) h�ny olyan sz�m van, melyben a jegyek sz�ma a megadott;
    System.out.println(szamStat.adottJegyuSzamokSzama(Console.readInt("Jegyek sz�ma: "))+" db");

    // e) h�ny olyan sz�m van, melyben a v�gz�d�s a megadott;
    System.out.println(szamStat.adottVegzodesuSzamokSzama(Console.readInt("V�gz�d�s: "))+" db");
  }
}
