/*
 * Feladatmegold�sok/18. fejezet
 * Szamok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Szamok {
  public static void main(String[] args) {
    final int HATAR=10;
    int[] szamok = new int[10];

    // A 10 sz�m bek�r�se:
    for (int i=0; i<szamok.length; i++)
      szamok[i] = Console.readInt(Format.right(i+1,2)+". sz�m: ");

    // A 10-n�l nagyobb sz�mok ki�r�sa:
    System.out.println(HATAR+"-n�l nagyobb sz�mok:");
    for (int i=0; i<szamok.length; i++)
      if (szamok[i] > HATAR)
        System.out.println(szamok[i]);

    // A 10-n�l kisebb sz�mok ki�r�sa:
    System.out.println(HATAR+"-n�l kisebb sz�mok:");
    for (int i=0; i<szamok.length; i++)
      if (szamok[i] < HATAR)
        System.out.println(szamok[i]);
  }
}
