/*
 * Feladatmegold�sok/14. fejezet
 * Szuret1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class Szuret1 {
  public static void main(String[] args) {
    int puttonySuly;
    int osszSuly=0, osszDb=0;

    puttonySuly=Console.readInt("Puttony (kg): ");
    while (puttonySuly!=0) {
      osszDb++;
      osszSuly+=puttonySuly;
      puttonySuly=Console.readInt("Puttony (kg): ");
    }
    System.out.println("Puttonyok sz�ma �sszesen: "+osszDb);
    System.out.println("Sz�l� s�lya �sszesen: "+osszSuly+" kg");
  }
}
