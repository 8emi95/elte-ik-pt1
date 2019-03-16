/*
 * Feladatmegoldások/18. fejezet
 * Szamok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Szamok {
  public static void main(String[] args) {
    final int HATAR=10;
    int[] szamok = new int[10];

    // A 10 szám bekérése:
    for (int i=0; i<szamok.length; i++)
      szamok[i] = Console.readInt(Format.right(i+1,2)+". szám: ");

    // A 10-nél nagyobb számok kiírása:
    System.out.println(HATAR+"-nél nagyobb számok:");
    for (int i=0; i<szamok.length; i++)
      if (szamok[i] > HATAR)
        System.out.println(szamok[i]);

    // A 10-nél kisebb számok kiírása:
    System.out.println(HATAR+"-nél kisebb számok:");
    for (int i=0; i<szamok.length; i++)
      if (szamok[i] < HATAR)
        System.out.println(szamok[i]);
  }
}
