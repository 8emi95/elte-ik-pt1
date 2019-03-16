/*
 * Feladatmegoldások/16. fejezet
 * SzavakSzama.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.StringTokenizer;

public class SzavakSzama {

  // Visszaadja az str-ben elõforduló szavak számát:
  static int szavakSzama(String szoveg) {
    StringTokenizer st = new StringTokenizer(szoveg);
    return st.countTokens();
  }

  // main:
  public static void main(String[] args) {
    String szoveg = Console.readLine("Szöveg: ");
    System.out.println("Szavak száma="+szavakSzama(szoveg));
  }
}

