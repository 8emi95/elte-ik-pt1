/*
 * Feladatmegoldások/13. fejezet
 * Telek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Telek {
  public static void main(String[] args) {
    int szel  = Console.readInt("Telek szélessége(m): ");
    int hossz = Console.readInt("Telek hosszúsága(m): ");

    double ter = szel * hossz / 3.6;
    System.out.println("\nTerület: "+Format.left(ter,0,2)+" négyszögöl");
    if (ter<100)
      System.out.println("A telek túl kicsi!");
  }
}
