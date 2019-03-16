/*
 * Mintaprogramok/15. fejezet
 * Sinus.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Sinus {
  static double sin(double fok) {
    // 360 fok = 2PI radian, 1 fok = 2PI/360 radian
    return Math.sin(fok * 2 * Math.PI / 360);
  }

  public static void main(String[] args) {
    System.out.println(sin(90));       // -> 1.0
    System.out.println(sin(60));       // -> 0.866
  }
}
