/*
 * Mintaprogramok/12. fejezet
 * EgyketA.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class EgyketA {
  public static void main(String[] args) {
    boolean vanA;
    vanA = Console.readChar("Írjon be egy betût: ")=='A' ||
      Console.readChar("Még egyet: ")=='A';
    System.out.println("Volt benne A betû: "+vanA);
  }
}
