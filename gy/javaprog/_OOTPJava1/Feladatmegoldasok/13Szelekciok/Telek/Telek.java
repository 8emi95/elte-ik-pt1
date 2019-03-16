/*
 * Feladatmegold�sok/13. fejezet
 * Telek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Telek {
  public static void main(String[] args) {
    int szel  = Console.readInt("Telek sz�less�ge(m): ");
    int hossz = Console.readInt("Telek hossz�s�ga(m): ");

    double ter = szel * hossz / 3.6;
    System.out.println("\nTer�let: "+Format.left(ter,0,2)+" n�gysz�g�l");
    if (ter<100)
      System.out.println("A telek t�l kicsi!");
  }
}
