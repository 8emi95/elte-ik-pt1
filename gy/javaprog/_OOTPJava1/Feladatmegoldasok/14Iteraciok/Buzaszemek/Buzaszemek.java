/*
 * Feladatmegoldások/14. fejezet
 * Buzaszemek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Buzaszemek {
  public static void main (String args[]) {
    // a) feladat
    int sor=1;
    char oszlop='A';
    long szemekSzama=1;
    while (szemekSzama < 1E6) {
      oszlop++;
      if (oszlop>'H') {
        oszlop='A';
        sor++;
      }
      szemekSzama *= 2;
    }
    System.out.println(oszlop+""+sor+" mezõn "+szemekSzama+" szem búza");
    System.out.println("-----------------------------------------");

    // b) feladat
    while ((oszlop = Console.readChar("Oszlop (a..h)= "))!='*') {
      sor = Console.readInt("Sor (1..8)= ");
      // Feltételezzük, hogy az oszlop 'a' és 'h', a sor 1 és 8 között van:
      int mezo = (sor-1)*8+oszlop-'a'; // 0..63
      double szemSzam = Math.pow(2,mezo);
      System.out.println(oszlop+""+sor+" mezõn "+Format.left(szemSzam,0,0)+" szem búza van");
    }
  }
}
