/*
 * Mintaprogramok/14. fejezet
 * Bank.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Bank {
  public static void main (String args[]) {
    final int ALOMEGYENLEG = 100000;
    double egyenleg = Console.readInt("Mennyi p�nzed van (Ft)? ");

    short honap = 0;
    while (egyenleg < ALOMEGYENLEG) {
      honap++;
      egyenleg *=1.02;
    }
    System.out.println("Tartsd bent "+honap+" h�napig!");
    System.out.println("Ut�na kivehetsz "+
                       Format.right(egyenleg,0,0)+" Ft-ot.");
  }
}
