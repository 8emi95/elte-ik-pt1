/* 
 * Feladatmegold�sok/2. fejezet
 * Olimpia.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2004.09.15.

 Megjegyz�s: 
 A Java programban az eremFajta �s az ermekSzama egy�tt jelentik 
 az AktHir-t. Az eremFajta adatot el�re bek�rj�k, �s csak akkor 
 k�rj�k hozz� az ermekSzama adatot, ha az t�nylegesen �rem volt.
 Ha az eremFajta adatn�l csup�n az Entert �tik le, akkor a 
 bevitel befejez�dik.
 */

import extra.*;

public class Olimpia {
  public static void main(String[] args) {
    int dbArany = 0;
    int dbEz�st = 0;
    int dbBronz = 0;
    String eremFajta = "";
    int ermekSzama = 0;

    eremFajta = Console.readLine("arany/ez�st/bronz? ");
    while (!eremFajta.equals("")) {
      ermekSzama = Console.readInt("db: ");
      if (eremFajta.equals("arany")) {
        dbArany = dbArany + ermekSzama;
      }
      else if (eremFajta.equals("ez�st")) {
        dbEz�st = dbEz�st + ermekSzama;
      }
      else {
        dbBronz = dbBronz + ermekSzama;
      }
      eremFajta = Console.readLine("arany/ez�st/bronz? ");
    }
    System.out.println("Arany�rmek sz�ma: " + dbArany);
    System.out.println("Ez�st�rmek sz�ma: " + dbEz�st);
    System.out.println("Bronz�rmek sz�ma: " + dbBronz);
  }
}


