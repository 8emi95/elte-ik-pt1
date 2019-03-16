/*
 * Feladatmegold�sok/16. fejezet
 * SzavakSzama.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;
import java.util.StringTokenizer;

public class SzavakSzama {

  // Visszaadja az str-ben el�fordul� szavak sz�m�t:
  static int szavakSzama(String szoveg) {
    StringTokenizer st = new StringTokenizer(szoveg);
    return st.countTokens();
  }

  // main:
  public static void main(String[] args) {
    String szoveg = Console.readLine("Sz�veg: ");
    System.out.println("Szavak sz�ma="+szavakSzama(szoveg));
  }
}

