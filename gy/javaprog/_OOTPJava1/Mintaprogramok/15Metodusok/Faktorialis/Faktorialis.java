/*
 * Mintaprogramok/15. fejezet
 * Faktorialis.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Faktorialis {

  static long fakt(int n) {
    if (n < 1)
      return 1;
    long f = 1;
    for (int i=1; i<=n; i++)
      f *= i;
    return f;
  }

  static void faktKiir (int a, int b) {
    // a>b esetén a két szám felcserélése:
    if (a>b) {
      int seged=a; a=b; b=seged;
    }
    for (int i=a; i<=b; i++)
      System.out.println(i+" faktoriálisa: "+fakt(i));
  }

  public static void main(String[] args) {
    faktKiir(7,5);
  }
}



