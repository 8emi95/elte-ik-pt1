/*
 * Feladatmegold�sok/1. fejezet
 * Projekt: Bank
 * Bank.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.Console;

public class Bank {
  public static void main (String args[]) {
    final int ALOMEGYENLEG = 100000;
    int egyenleg = Console.readInt("Mennyi penzed van? ");

    short honap = 0;
    while (egyenleg < ALOMEGYENLEG) {
      honap++;
      egyenleg *=1.02;   // ft-ra kerekit�s!
    }
    System.out.println("Tartsd bent "+honap+" honapig");
    System.out.println("Utana kivehetsz "+egyenleg+" ft-ot");
  }
}
