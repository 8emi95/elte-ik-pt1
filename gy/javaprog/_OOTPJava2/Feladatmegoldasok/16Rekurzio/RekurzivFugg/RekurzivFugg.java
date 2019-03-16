/*
 * Feladatmegold�sok/16. fejezet
 * RekurzivFugg.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

public class RekurzivFugg {
  // a)
  static int faktorialis(int n) {
    if (n==1)
      return 1;
    else
      return faktorialis(n-1)*n;
  }

  // b)
  static int szorzat(int tol, int ig) {
    if (tol >= ig)
      return tol;
    else
      return szorzat(tol,ig-1)*ig;
  }

  public static void main(String[] args) {
    System.out.println("5! = "+faktorialis(5));
    System.out.println("Szorzat 5..8 = "+szorzat(5,8));
  }
}
