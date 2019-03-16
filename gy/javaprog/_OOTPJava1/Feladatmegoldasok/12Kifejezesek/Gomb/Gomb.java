/*
 * Feladatmegoldások/12. fejezet
 * Gomb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Gomb {
  public static void main(String[] args) {
    int sugar=Console.readInt("Hány centiméter a gömb sugara? ");
    double felszin  = 4*Math.pow(sugar,2)*Math.PI;
    double terfogat = 4*Math.pow(sugar,3)*Math.PI/3;
    System.out.println("\nFelszín : "+Format.left(felszin,0,2)+" cm2");
    System.out.println("Térfogat: "+Format.left(terfogat,0,2)+" cm3, vagyis "+
                       Format.left(terfogat/1000,0,5)+" liter");
  }
}
