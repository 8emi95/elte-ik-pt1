/*
 * Feladatmegoldások/16. fejezet
 * MegjegyzesKivesz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class MegjegyzesKivesz {

  // Elsõ megoldás
  static StringBuffer noRemark(StringBuffer sb) {
    int poz;
    while ((poz=sb.toString().indexOf('(')) != -1) {
      while (sb.charAt(poz) != ')')
        sb.deleteCharAt(poz);
      sb.deleteCharAt(poz);
    }
    return sb;
  }

  // Második megoldás
  static StringBuffer noRemark2(StringBuffer sb) {
    int kezd, veg;
    while ((kezd=sb.toString().indexOf('(')) >= 0) {
      veg=sb.toString().indexOf(')');
      sb.delete(kezd,veg+1);
    }
    return sb;
  }

  public static void main(String[] args) {
    StringBuffer szoveg = new StringBuffer(Console.readLine("Szöveg: "));
    noRemark(szoveg);
    System.out.println(szoveg);
  }
}

