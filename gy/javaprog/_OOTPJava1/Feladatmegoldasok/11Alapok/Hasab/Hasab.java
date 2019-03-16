/*
 * Feladatmegold�sok/11. fejezet
 * Hasab.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Hasab {
  public static void main (String args[]) {
    double szel  = Console.readDouble("Sz�less�g: ");
    double hossz = Console.readDouble("Hossz�s�g: ");
    double mag   = Console.readDouble("Magass�g : ");

    double felszin=2*(szel*hossz+szel*mag+hossz*mag);
    System.out.println("\nFelsz�n : "+Format.right(felszin,5,2));
    System.out.println("T�rfogat: "+Format.right(szel*hossz*mag,5,2));
  }
}
