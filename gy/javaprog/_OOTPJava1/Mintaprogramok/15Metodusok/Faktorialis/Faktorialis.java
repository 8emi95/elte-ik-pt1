/*
 * Mintaprogramok/15. fejezet
 * Faktorialis.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
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
    // a>b eset�n a k�t sz�m felcser�l�se:
    if (a>b) {
      int seged=a; a=b; b=seged;
    }
    for (int i=a; i<=b; i++)
      System.out.println(i+" faktori�lisa: "+fakt(i));
  }

  public static void main(String[] args) {
    faktKiir(7,5);
  }
}



