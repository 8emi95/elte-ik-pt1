/*
 * Feladatmegold�sok/16. fejezet
 * NevAlakit.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class NevAlakit {

  static String titleCase(String s) {
    if (s.length() == 0)
      return s;
    s = s.toLowerCase();
    return Character.toUpperCase(s.charAt(0))+s.substring(1);
  }

  public static void main(String[] args) {
    String nev;
    int p;
    // Addig k�rj�k a nevet, am�g az legal�bb k�t sz�b�l �ll:
    do {
      nev = Console.readLine("N�v: ").trim();
      p = nev.indexOf(' ');
    } while (p == -1);

    StringBuffer ujNev = new StringBuffer("");
    p = nev.indexOf(' ');
    while (p >= 0) {
      ujNev.append(titleCase(nev.substring(0,p))+" ");
      nev = nev.substring(p+1).trim();
      p = nev.indexOf(' ');
    }
    ujNev.append(titleCase(nev));
    System.out.println(ujNev);
  }
}

