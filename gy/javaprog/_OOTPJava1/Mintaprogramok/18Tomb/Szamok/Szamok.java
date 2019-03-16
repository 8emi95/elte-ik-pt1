/*
 * Mintaprogramok/18. fejezet
 * Szamok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Szamok {
  int[] szamok = new int[10];     //1

  // A 10 db sz�m bek�r�se:
  void beker() {
    for (int i=0; i<szamok.length; i++)
      szamok[i] = Console.readInt(i+1+". sz�m: ");
  }

  // A sz�mok ki�r�sa a beker�s sorrendj�ben:
  void kiirElore() {
    for (int i=0; i<szamok.length; i++)
      System.out.print(szamok[i]+" ");
    System.out.println();
  }

  // A sz�mok ki�r�sa ford�tott sorrendben:
  void kiirVissza() {
    for (int i=szamok.length-1; i>=0; i--)
      System.out.print(szamok[i]+" ");
    System.out.println();
  }

  public static void main(String[] args) {
    Szamok szamok = new Szamok();
    szamok.beker();
    szamok.kiirElore();
    szamok.kiirVissza();
  }
}
