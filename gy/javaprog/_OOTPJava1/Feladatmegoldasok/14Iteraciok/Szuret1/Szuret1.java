/*
 * Feladatmegoldások/14. fejezet
 * Szuret1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
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
    System.out.println("Puttonyok száma összesen: "+osszDb);
    System.out.println("Szõlõ súlya összesen: "+osszSuly+" kg");
  }
}
