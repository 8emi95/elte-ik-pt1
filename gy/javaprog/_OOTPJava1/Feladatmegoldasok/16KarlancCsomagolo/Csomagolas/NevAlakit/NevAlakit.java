/*
 * Feladatmegoldások/16. fejezet
 * NevAlakit.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
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
    // Addig kérjük a nevet, amíg az legalább két szóból áll:
    do {
      nev = Console.readLine("Név: ").trim();
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

