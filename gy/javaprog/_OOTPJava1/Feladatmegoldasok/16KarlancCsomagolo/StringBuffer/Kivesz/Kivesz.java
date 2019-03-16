/*
 * Feladatmegold�sok/16. fejezet
 * Kivesz.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Kivesz {
  static String kivesz(String str, String delChars) {
    StringBuffer sb = new StringBuffer(str);
    for (int i=0; i<delChars.length(); i++) {
      int poz = sb.toString().indexOf(delChars.charAt(i));
      while (poz >= 0) {
        sb.deleteCharAt(poz);
        poz = sb.toString().indexOf(delChars.charAt(i));
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String szoveg = Console.readLine("Sz�veg= ");
    System.out.println(kivesz(szoveg,".-"));
  }
}
