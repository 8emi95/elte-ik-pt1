/*
 * Feladatmegoldások/16. fejezet
 * Kodolas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Kodolas {
  static String kodolt(String str) {
    StringBuffer sb = new StringBuffer(str);
    for (int i=0; i<str.length(); i++)
      //0x0018 == 00000000 00011000 (a 3. és 4. bit egyes)
      // a ^ (kizáró vagy) a bitet megfordítja: nullából egyes lesz és fordítva:
      sb.setCharAt(i,(char)(sb.charAt(i)^0x0018));
    return sb.toString();
  }

  public static void main(String[] args) {
    String szoveg = Console.readLine("A kódolandó szöveg: ");
    szoveg = kodolt(szoveg);
    System.out.println("Kódolva: "+szoveg);
    // A megfejtõ metódus ugyanaz:
    szoveg = kodolt(szoveg);
    System.out.println("Megfejtve: "+szoveg);
  }
}

