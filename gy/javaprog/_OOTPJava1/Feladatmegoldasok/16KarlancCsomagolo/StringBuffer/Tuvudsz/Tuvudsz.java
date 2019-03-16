/*
 * Feladatmegold�sok/16. fejezet
 * Tuvudsz.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Tuvudsz {

  static boolean maganhangzo(char c) {
    final String MH = "a�e�i�o���u���";  // mag�nhangz�k
    return MH.indexOf(Character.toLowerCase(c))>=0;
  }

  static String tuvudsz(String s) {
    StringBuffer sb = new StringBuffer("");
    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      sb.append(c);
      if (maganhangzo(c))
        sb.append((Character.isLowerCase(c)?"v":"V")+c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String mondat = Console.readLine("Mondj valamit: ");
    System.out.println(tuvudsz(mondat));
  }
}
