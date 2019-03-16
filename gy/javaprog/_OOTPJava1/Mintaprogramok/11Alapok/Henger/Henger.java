/*
 * Mintaprogramok/11. fejezet
 * Henger.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Henger {
  public static void main(String[] args) {
    final float VAS_SURUSEG = 7.8F;  // g/cm3
    final float FA_SURUSEG = 0.7F;   // g/cm3
    double terfogat;
    double sugar, magassag;
    sugar = Console.readDouble("Sugár (cm)? ");
    magassag = Console.readDouble("Magasság (cm)? ");
    terfogat = sugar*sugar*Math.PI*magassag;

    System.out.println("Térfogat : "+Format.right(terfogat,8,2)+" cm3");
    System.out.println("Vashenger: "+Format.right(terfogat*VAS_SURUSEG,8,2)+" g");
    System.out.println("Fahenger : "+Format.right(terfogat*FA_SURUSEG,8,2)+" g");
  }
}
