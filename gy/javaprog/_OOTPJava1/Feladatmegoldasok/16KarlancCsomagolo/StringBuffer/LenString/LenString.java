/*
 * Feladatmegold�sok/16. fejezet
 * LenString.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class LenString {

  public static String lenString(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    sb.setLength(len);                   // a hossz �t�ll�t�sa
    for (int i=str.length(); i<len; i++) // felt�lt�s sz�k�z�kkel
      sb.setCharAt(i,' ');
    return sb.toString();
  }

  public static void main(String[] args) {
    String szoveg = Console.readLine("Sz�veg:");
    System.out.println("123456789012345678901234567890");
    System.out.println(lenString(szoveg,15)+"*");
    System.out.println(lenString(szoveg,5)+"*");
  }
}
