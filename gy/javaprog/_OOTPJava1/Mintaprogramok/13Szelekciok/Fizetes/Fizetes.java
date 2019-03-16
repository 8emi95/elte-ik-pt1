/*
 * Mintaprogramok/13. fejezet
 * Fizetes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Fizetes {
  public static void main(String[] args) {
    int fizetes = Console.readInt("Fizetés? ");
    if (fizetes < 100000)
      fizetes *= 1.25;
    System.out.println("Az új fizetés: "+fizetes+" Ft");
  }
}
