/* 
 * Mintaprogramok/13. fejezet
 * KovKarakter.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
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
