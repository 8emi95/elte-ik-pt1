/*
 * Mintaprogramok/12. fejezet
 * EgyketA.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class EgyketA {
  public static void main(String[] args) {
    boolean vanA;
    vanA = Console.readChar("�rjon be egy bet�t: ")=='A' ||
      Console.readChar("M�g egyet: ")=='A';
    System.out.println("Volt benne A bet�: "+vanA);
  }
}
