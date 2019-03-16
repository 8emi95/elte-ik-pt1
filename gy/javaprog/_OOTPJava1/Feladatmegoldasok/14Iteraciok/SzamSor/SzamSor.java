/*
 * Feladatmegoldások/14. fejezet
 * SzamSor.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class SzamSor {
  public static void main(String[] args) {
    int hatar = Console.readInt("Meddig? ");
    System.out.println("Összes egész szám:");
    for (int i=0; i<=hatar; i++)
      System.out.print(i+" ");

    System.out.println("\nÖsszes páros szám:");
    for (int i=0; i<=hatar; i+=2)
      System.out.print(i+" ");

    System.out.println("\nÖsszes 3-mal osztható szám:");
    for (int i=0; i<=hatar/3; i++)
      System.out.print(i*3+" ");
  }
}
