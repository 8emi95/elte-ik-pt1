/*
 * Feladatmegoldások/16. fejezet
 * Leghossszabb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Leghosszabb {
  static void aFeladat() {
    String szo;
    String leghosszabb = "";
    szo = Console.readLine("Szó: ");
    while (!szo.equals("")) {
      if (szo.length() > leghosszabb.length())
        leghosszabb = szo;
      szo = Console.readLine("Szó: ");
    }
    System.out.println("A leghosszabb szó: "+leghosszabb);
  }

  static void bFeladat() {
    String szo;
    String leghosszabbak = "";
    int maxHossz = -1;
    szo = Console.readLine("Szó: ");
    while (!szo.equals("")) {
      if (szo.length() > maxHossz) {
        maxHossz = szo.length();
        leghosszabbak = szo;
      }
      else if (szo.length() == maxHossz) {
        leghosszabbak = leghosszabbak + ", " + szo;
      }
      szo = Console.readLine("Szó: ");
    }
    System.out.println("A leghosszabb szavak: "+leghosszabbak);
  }

  public static void main(String[] args) {
    aFeladat();
    bFeladat();
  }
}
