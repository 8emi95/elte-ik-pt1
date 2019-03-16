/*
 * Feladatmegoldások/16. fejezet
 * Megszamol.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Megszamol {

  // Visszaadja az str-ben elõforduló szóközök számát
  static int szokozokSzama(String str) {
    int n = 0;
    for (int i=0; i<str.length(); i++)
      if (str.charAt(i) == ' ')
        n++;
    return n;
  }

  // Visszaadja az str-ben elõforduló and reszlancok számát:
  static int reszlancokSzama(String str) {
    int n = 0;
    int poz = 0;
    while ((poz = str.indexOf("and",poz)) >= 0) {
      n++;
      poz+="and".length();
    }
    return n;
  }

  // Visszaadja az str-ben elõforduló reszlanc-ok számát
  static int reszlancokSzama(String str, String reszlanc) {
    int n = 0;
    int poz = 0;
    while ( (poz=str.indexOf(reszlanc,poz)) >= 0) {
      n++;
      poz+=reszlanc.length();
    }
    return n;
  }

  // main
  public static void main(String[] args) {
    String szoveg = Console.readLine("Szöveg: ");
    System.out.println("Szóközök száma="+szokozokSzama(szoveg));
    System.out.println("and-ek száma="+reszlancokSzama(szoveg));
    System.out.println("or-ok száma="+reszlancokSzama(szoveg,"or"));
  }
}

