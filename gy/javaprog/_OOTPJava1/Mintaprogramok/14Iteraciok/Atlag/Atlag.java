/*
 * Mintaprogramok/14. fejezet
 * Atlag.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Atlag {
  public static void main (String args[]) {
    final int VEGJEL = 0;
    long osszeg = 0;
    int db = 0, szam;
    while ((szam = Console.readInt("Sz�m: "))!= VEGJEL) {
      db++;
      osszeg += szam;
    }

    if (db!=0) {
      System.out.println("�sszeg= "+osszeg);
      System.out.println("Darab = "+db);
      System.out.println("�tlag = "+Format.right(osszeg*1.0/db,0,2));
    }
    else
      System.out.println("Nincs beolvasott sz�m!");
  }
}

