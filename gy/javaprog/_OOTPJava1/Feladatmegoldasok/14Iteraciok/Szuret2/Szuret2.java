/*
 * Feladatmegold�sok/14. fejezet
 * Szuret2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class Szuret2 {
  public static void main(String[] args) {
    //Felt�telezz�k, hogy az utols� puttony sz�l� mindig r�f�r m�g a kocsira!
    final int KOCSIADAG = 1000;
    int puttonySuly;
    int osszSuly=0, kocsiSuly=0, osszDb=0;

    puttonySuly=Console.readInt("Puttony (kg): ");
    while (puttonySuly!=0) {
      osszDb++;
      kocsiSuly+=puttonySuly;
      if (kocsiSuly>=KOCSIADAG) {
        System.out.println("Mehet a kocsi!");
        osszSuly+=kocsiSuly;
        kocsiSuly=0;
      }
      puttonySuly=Console.readInt("Puttony (kg): ");
    }
    osszSuly+=kocsiSuly;
    System.out.println("Puttonyok sz�ma �sszesen: "+osszDb);
    System.out.println("Sz�l� s�lya �sszesen: "+osszSuly+" kg");
  }
}
