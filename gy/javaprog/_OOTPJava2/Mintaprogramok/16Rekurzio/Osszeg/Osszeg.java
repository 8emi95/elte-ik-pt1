/*
 * Mintaprogramok/16. fejezet
 * Osszeg.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

public class Osszeg {

  static int osszeg(int n) {
    if (n==1)
      return 1;
    else
      return osszeg(n-1)+n;
  }

  public static void main(String[] args) {
    System.out.println("1+2+3="+osszeg(3));
  }
}