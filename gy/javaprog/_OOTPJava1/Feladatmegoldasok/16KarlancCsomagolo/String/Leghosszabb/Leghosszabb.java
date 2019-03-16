/*
 * Feladatmegold�sok/16. fejezet
 * Leghossszabb.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Leghosszabb {
  static void aFeladat() {
    String szo;
    String leghosszabb = "";
    szo = Console.readLine("Sz�: ");
    while (!szo.equals("")) {
      if (szo.length() > leghosszabb.length())
        leghosszabb = szo;
      szo = Console.readLine("Sz�: ");
    }
    System.out.println("A leghosszabb sz�: "+leghosszabb);
  }

  static void bFeladat() {
    String szo;
    String leghosszabbak = "";
    int maxHossz = -1;
    szo = Console.readLine("Sz�: ");
    while (!szo.equals("")) {
      if (szo.length() > maxHossz) {
        maxHossz = szo.length();
        leghosszabbak = szo;
      }
      else if (szo.length() == maxHossz) {
        leghosszabbak = leghosszabbak + ", " + szo;
      }
      szo = Console.readLine("Sz�: ");
    }
    System.out.println("A leghosszabb szavak: "+leghosszabbak);
  }

  public static void main(String[] args) {
    aFeladat();
    bFeladat();
  }
}
