/* 
 * Mintaprogramok/15. fejezet
 * Osszeg.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Osszeg {
  static int sum(int a,int b) {
    return a+b;
  }

  public static void main(String[] args) {
    int osszeg, a=3;
    osszeg = sum(5,a+3);
    System.out.println(osszeg);  // -> 11
  }
}



