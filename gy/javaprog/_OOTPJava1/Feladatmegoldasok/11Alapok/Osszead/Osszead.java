/*
 * Feladatmegold�sok/11. fejezet
 * Osszead.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Osszead {
  public static void main(String[] args) {
    double a=Console.readDouble("Els� sz�m: ");
    double b=Console.readDouble("M�sodik sz�m: ");
    System.out.println("\n "+Format.right(a,10,2));
    System.out.println("+"+Format.right(b,10,2));
    System.out.println("-----------");
    System.out.println(" "+Format.right(a+b,10,2));
  }
}
