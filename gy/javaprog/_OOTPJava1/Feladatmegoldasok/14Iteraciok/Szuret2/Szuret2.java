/*
 * Feladatmegoldások/14. fejezet
 * Szuret2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class Szuret2 {
  public static void main(String[] args) {
    //Feltételezzük, hogy az utolsó puttony szõlõ mindig ráfér még a kocsira!
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
    System.out.println("Puttonyok száma összesen: "+osszDb);
    System.out.println("Szõlõ súlya összesen: "+osszSuly+" kg");
  }
}
