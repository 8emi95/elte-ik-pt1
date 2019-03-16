/*
 * Mintaprogramok/16. fejezet
 * Osszegzes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Osszegzes {
  public static void main(String[] args) {
    String osszegStr = Console.readLine
      ("Írjon be egy összeget 9.9+9.9+9.9 formában:\n");
    // Így könnyebb lesz feldolgozni az utolsó számjegyet:
    osszegStr = osszegStr+"+";
    double osszeg = 0, szam;
    int kezd = 0;
    int p = osszegStr.indexOf('+');
    while (p >= 0) {
      szam = Double.parseDouble(osszegStr.substring(kezd,p));
      System.out.println(Format.right(szam,8,2));
      osszeg += szam;
      kezd = p+1;
      p = osszegStr.indexOf('+',kezd);
    }
    System.out.println("--------");
    System.out.println(Format.right(osszeg,8,2));
  }
}
