/*
 * Mintaprogramok/18. fejezet
 * Szamok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Szamok {
  int[] szamok = new int[10];     //1

  // A 10 db szám bekérése:
  void beker() {
    for (int i=0; i<szamok.length; i++)
      szamok[i] = Console.readInt(i+1+". szám: ");
  }

  // A számok kiírása a bekerés sorrendjében:
  void kiirElore() {
    for (int i=0; i<szamok.length; i++)
      System.out.print(szamok[i]+" ");
    System.out.println();
  }

  // A számok kiírása fordított sorrendben:
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
