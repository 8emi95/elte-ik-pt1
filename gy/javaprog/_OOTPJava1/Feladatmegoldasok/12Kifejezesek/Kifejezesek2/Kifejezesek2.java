/*
 * Feladatmegold�sok/12. fejezet
 * Kifejezesek2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Kifejezesek2 {
  public static void main(String[] args) {
    int a = Console.readInt("a = ");
    int b = Console.readInt("b = ");
    System.out.println();

    // a) feladat:
    boolean min1paros = a%2==1 || b%2==1 ;
    System.out.println("a �s b k�z�l legfeljebb az egyik p�ros: "+min1paros);

    // b) feladat:
    boolean pontosan1paros = a%2==0 ^ b%2==0 ;
    System.out.println("a �s b k�z�l pontosan az egyik p�ros: "+pontosan1paros);
  }
}
