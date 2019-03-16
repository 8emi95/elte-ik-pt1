/*
 * Mintaprogramok/18. fejezet
 * Szovegek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Szovegek {
  String[] szovegek = new String[100];   // 100 szöveg fér be
  int nSzoveg = 0;  // aktuális szövegek száma

  // A szövegek bekérése:
  void beker() {
    String szoveg;
    while (true) {
      if (nSzoveg == szovegek.length) {
        System.out.println("Betelt");
        break;
      }
      szoveg = Console.readLine(nSzoveg+1+". szöveg: ");
      if (szoveg.equals(""))
        break;
      szovegek[nSzoveg] = szoveg;
      nSzoveg++;
    }
  }

  // Szövegek kiírása a bekérés sorrendjében:
  void kiirElore() {
    for (int i=0; i<nSzoveg; i++)
      System.out.print(szovegek[i]+" ");
    System.out.println();
  }

  // Szövegek kiírása fordított sorrendben:
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

