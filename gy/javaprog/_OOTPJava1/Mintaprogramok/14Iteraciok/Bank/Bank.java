/*
 * Mintaprogramok/14. fejezet
 * Bank.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Bank {
  public static void main (String args[]) {
    final int ALOMEGYENLEG = 100000;
    double egyenleg = Console.readInt("Mennyi pénzed van (Ft)? ");

    short honap = 0;
    while (egyenleg < ALOMEGYENLEG) {
      honap++;
      egyenleg *=1.02;
    }
    System.out.println("Tartsd bent "+honap+" hónapig!");
    System.out.println("Utána kivehetsz "+
                       Format.right(egyenleg,0,0)+" Ft-ot.");
  }
}
