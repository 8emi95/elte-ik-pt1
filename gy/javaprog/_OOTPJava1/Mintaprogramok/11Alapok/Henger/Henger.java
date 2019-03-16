/*
 * Mintaprogramok/11. fejezet
 * Henger.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Henger {
  public static void main(String[] args) {
    final float VAS_SURUSEG = 7.8F;  // g/cm3
    final float FA_SURUSEG = 0.7F;   // g/cm3
    double terfogat;
    double sugar, magassag;
    sugar = Console.readDouble("Sug�r (cm)? ");
    magassag = Console.readDouble("Magass�g (cm)? ");
    terfogat = sugar*sugar*Math.PI*magassag;

    System.out.println("T�rfogat : "+Format.right(terfogat,8,2)+" cm3");
    System.out.println("Vashenger: "+Format.right(terfogat*VAS_SURUSEG,8,2)+" g");
    System.out.println("Fahenger : "+Format.right(terfogat*FA_SURUSEG,8,2)+" g");
  }
}
