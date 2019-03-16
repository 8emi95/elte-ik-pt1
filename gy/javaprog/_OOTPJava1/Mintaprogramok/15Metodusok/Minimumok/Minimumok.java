/*
 * Mintaprogramok/15. fejezet
 * Minimumok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Minimumok {
  static int min(int a, int b) {
    return (a<b)? a:b;
  }

  static double min(double a, double b) {
    return (a<b)? a:b;
  }

  static long min(long a, long b) {
    return (a<b)? a:b;
  }

  public static void main(String[] args) {
    int i = 53;
    double d = 66.4666;
    System.out.println(min(i,5));     //1    -> 5
    System.out.println(min(5.0,d));   //2    -> 5.0
    System.out.println(min(292,d));   //3    -> 66.4666
    System.out.println(min(i,5000000000L)); //4  -> 53
  }
}
