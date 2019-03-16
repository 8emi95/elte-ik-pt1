/*
 * Mintaprogramok/14. fejezet
 * KorKerulet.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class KorKerulet {
  public static void main (String args[]) {
    final int VEGJEL = 0;
    double sugar;
    long kerulet;

    // 1. megoldás:
    sugar = Console.readDouble("Sugár: ") ;
    while (sugar != VEGJEL) {
      kerulet = Math.round(sugar*2*Math.PI);
      System.out.println("Kerület: "+kerulet) ;
      sugar = Console.readDouble("Sugár: ") ;
    }

    // 2. megoldás:
    while ((sugar = Console.readDouble("Sugár: ")) != VEGJEL) {
      kerulet = Math.round(sugar*2*Math.PI);
      System.out.println("Kerület: "+kerulet) ;
    }

    // 3. megoldás:
    while (true) {
      sugar = Console.readDouble("Sugár: ") ;
      if (sugar == VEGJEL)
        break;
      kerulet = Math.round(sugar*2*Math.PI);
      System.out.println("Kerület: "+kerulet) ;
    }
  }
}
