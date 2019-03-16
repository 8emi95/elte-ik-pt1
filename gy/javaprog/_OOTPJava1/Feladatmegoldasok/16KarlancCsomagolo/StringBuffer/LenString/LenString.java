/*
 * Feladatmegoldások/16. fejezet
 * LenString.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class LenString {

  public static String lenString(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    sb.setLength(len);                   // a hossz átállítása
    for (int i=str.length(); i<len; i++) // feltöltés szóközökkel
      sb.setCharAt(i,' ');
    return sb.toString();
  }

  public static void main(String[] args) {
    String szoveg = Console.readLine("Szöveg:");
    System.out.println("123456789012345678901234567890");
    System.out.println(lenString(szoveg,15)+"*");
    System.out.println(lenString(szoveg,5)+"*");
  }
}
