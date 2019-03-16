/*
 * Feladatmegoldások/11. fejezet
 * Osszead.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Osszead {
  public static void main(String[] args) {
    double a=Console.readDouble("Elsõ szám: ");
    double b=Console.readDouble("Második szám: ");
    System.out.println("\n "+Format.right(a,10,2));
    System.out.println("+"+Format.right(b,10,2));
    System.out.println("-----------");
    System.out.println(" "+Format.right(a+b,10,2));
  }
}
