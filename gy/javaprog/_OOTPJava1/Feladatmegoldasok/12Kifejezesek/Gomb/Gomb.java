/*
 * Feladatmegold�sok/12. fejezet
 * Gomb.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Gomb {
  public static void main(String[] args) {
    int sugar=Console.readInt("H�ny centim�ter a g�mb sugara? ");
    double felszin  = 4*Math.pow(sugar,2)*Math.PI;
    double terfogat = 4*Math.pow(sugar,3)*Math.PI/3;
    System.out.println("\nFelsz�n : "+Format.left(felszin,0,2)+" cm2");
    System.out.println("T�rfogat: "+Format.left(terfogat,0,2)+" cm3, vagyis "+
                       Format.left(terfogat/1000,0,5)+" liter");
  }
}
