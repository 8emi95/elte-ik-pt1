/*
 * Feladatmegold�sok/16. fejezet
 * Kodolas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Kodolas {
  static String kodolt(String str) {
    StringBuffer sb = new StringBuffer(str);
    for (int i=0; i<str.length(); i++)
      //0x0018 == 00000000 00011000 (a 3. �s 4. bit egyes)
      // a ^ (kiz�r� vagy) a bitet megford�tja: null�b�l egyes lesz �s ford�tva:
      sb.setCharAt(i,(char)(sb.charAt(i)^0x0018));
    return sb.toString();
  }

  public static void main(String[] args) {
    String szoveg = Console.readLine("A k�doland� sz�veg: ");
    szoveg = kodolt(szoveg);
    System.out.println("K�dolva: "+szoveg);
    // A megfejt� met�dus ugyanaz:
    szoveg = kodolt(szoveg);
    System.out.println("Megfejtve: "+szoveg);
  }
}

