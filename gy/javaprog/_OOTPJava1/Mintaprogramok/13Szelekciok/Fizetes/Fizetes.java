/*
 * Mintaprogramok/13. fejezet
 * Fizetes.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Fizetes {
  public static void main(String[] args) {
    int fizetes = Console.readInt("Fizet�s? ");
    if (fizetes < 100000)
      fizetes *= 1.25;
    System.out.println("Az �j fizet�s: "+fizetes+" Ft");
  }
}
