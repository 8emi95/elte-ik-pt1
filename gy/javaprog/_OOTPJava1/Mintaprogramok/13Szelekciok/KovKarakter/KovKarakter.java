/* 
 * Mintaprogramok/13. fejezet
 * KovKarakter.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class KovKarakter {
  public static void main(String[] args) {
    char karakter = Console.readChar("Karakter? ");
    if (karakter >= 'A' && karakter <= 'Z') {
      karakter++;
      System.out.println(karakter);
    }
  }
}
