/*
 * Mintaprogramok/14. fejezet
 * KorKerulet.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class KorKerulet {
  public static void main (String args[]) {
    final int VEGJEL = 0;
    double sugar;
    long kerulet;

    // 1. megold�s:
    sugar = Console.readDouble("Sug�r: ") ;
    while (sugar != VEGJEL) {
      kerulet = Math.round(sugar*2*Math.PI);
      System.out.println("Ker�let: "+kerulet) ;
      sugar = Console.readDouble("Sug�r: ") ;
    }

    // 2. megold�s:
    while ((sugar = Console.readDouble("Sug�r: ")) != VEGJEL) {
      kerulet = Math.round(sugar*2*Math.PI);
      System.out.println("Ker�let: "+kerulet) ;
    }

    // 3. megold�s:
    while (true) {
      sugar = Console.readDouble("Sug�r: ") ;
      if (sugar == VEGJEL)
        break;
      kerulet = Math.round(sugar*2*Math.PI);
      System.out.println("Ker�let: "+kerulet) ;
    }
  }
}
