/*
 * Feladatmegoldások/11. fejezet
 * Hasab.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Hasab {
  public static void main (String args[]) {
    double szel  = Console.readDouble("Szélesség: ");
    double hossz = Console.readDouble("Hosszúság: ");
    double mag   = Console.readDouble("Magasság : ");

    double felszin=2*(szel*hossz+szel*mag+hossz*mag);
    System.out.println("\nFelszín : "+Format.right(felszin,5,2));
    System.out.println("Térfogat: "+Format.right(szel*hossz*mag,5,2));
  }
}
