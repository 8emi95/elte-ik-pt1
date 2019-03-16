/* 
 * Mintaprogramok/15. fejezet
 * Kovetkezo.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Kovetkezo {
  static int kovetkezo(int n) {
    return n+1;
  }
  public static void main (String args[]) {
    System.out.println(kovetkezo(555));  // -> 556
  }
}
