/*
 * Feladatmegold�sok/14. fejezet
 * SzamSor.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class SzamSor {
  public static void main(String[] args) {
    int hatar = Console.readInt("Meddig? ");
    System.out.println("�sszes eg�sz sz�m:");
    for (int i=0; i<=hatar; i++)
      System.out.print(i+" ");

    System.out.println("\n�sszes p�ros sz�m:");
    for (int i=0; i<=hatar; i+=2)
      System.out.print(i+" ");

    System.out.println("\n�sszes 3-mal oszthat� sz�m:");
    for (int i=0; i<=hatar/3; i++)
      System.out.print(i*3+" ");
  }
}
