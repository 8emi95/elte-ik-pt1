/*
 * Feladatmegold�sok/14. fejezet
 * Buzaszemek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
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
    System.out.println(oszlop+""+sor+" mez�n "+szemekSzama+" szem b�za");
    System.out.println("-----------------------------------------");

    // b) feladat
    while ((oszlop = Console.readChar("Oszlop (a..h)= "))!='*') {
      sor = Console.readInt("Sor (1..8)= ");
      // Felt�telezz�k, hogy az oszlop 'a' �s 'h', a sor 1 �s 8 k�z�tt van:
      int mezo = (sor-1)*8+oszlop-'a'; // 0..63
      double szemSzam = Math.pow(2,mezo);
      System.out.println(oszlop+""+sor+" mez�n "+Format.left(szemSzam,0,0)+" szem b�za van");
    }
  }
}
