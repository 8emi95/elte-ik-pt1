/*
 * Mintaprogramok/18. fejezet
 * Szovegek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Szovegek {
  String[] szovegek = new String[100];   // 100 sz�veg f�r be
  int nSzoveg = 0;  // aktu�lis sz�vegek sz�ma

  // A sz�vegek bek�r�se:
  void beker() {
    String szoveg;
    while (true) {
      if (nSzoveg == szovegek.length) {
        System.out.println("Betelt");
        break;
      }
      szoveg = Console.readLine(nSzoveg+1+". sz�veg: ");
      if (szoveg.equals(""))
        break;
      szovegek[nSzoveg] = szoveg;
      nSzoveg++;
    }
  }

  // Sz�vegek ki�r�sa a bek�r�s sorrendj�ben:
  void kiirElore() {
    for (int i=0; i<nSzoveg; i++)
      System.out.print(szovegek[i]+" ");
    System.out.println();
  }

  // Sz�vegek ki�r�sa ford�tott sorrendben:
  void kiirVissza() {
    for (int i=nSzoveg-1; i>=0; i--)
      System.out.print(szovegek[i]+" ");
    System.out.println();
  }

  public static void main(String[] args) {
    Szovegek szovegek = new Szovegek();
    szovegek.beker();
    szovegek.kiirElore();
    szovegek.kiirVissza();
  }
}

