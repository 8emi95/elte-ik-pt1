/*
 * Feladatmegold�sok/16. fejezet
 * Megszamol.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Megszamol {

  // Visszaadja az str-ben el�fordul� sz�k�z�k sz�m�t
  static int szokozokSzama(String str) {
    int n = 0;
    for (int i=0; i<str.length(); i++)
      if (str.charAt(i) == ' ')
        n++;
    return n;
  }

  // Visszaadja az str-ben el�fordul� and reszlancok sz�m�t:
  static int reszlancokSzama(String str) {
    int n = 0;
    int poz = 0;
    while ((poz = str.indexOf("and",poz)) >= 0) {
      n++;
      poz+="and".length();
    }
    return n;
  }

  // Visszaadja az str-ben el�fordul� reszlanc-ok sz�m�t
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
    String szoveg = Console.readLine("Sz�veg: ");
    System.out.println("Sz�k�z�k sz�ma="+szokozokSzama(szoveg));
    System.out.println("and-ek sz�ma="+reszlancokSzama(szoveg));
    System.out.println("or-ok sz�ma="+reszlancokSzama(szoveg,"or"));
  }
}

