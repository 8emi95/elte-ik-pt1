/* 
 * Feladatmegoldások/2. fejezet
 * Olimpia.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2004.09.15.

 Megjegyzés: 
 A Java programban az eremFajta és az ermekSzama együtt jelentik 
 az AktHir-t. Az eremFajta adatot elõre bekérjük, és csak akkor 
 kérjük hozzá az ermekSzama adatot, ha az ténylegesen érem volt.
 Ha az eremFajta adatnál csupán az Entert ütik le, akkor a 
 bevitel befejezõdik.
 */

import extra.*;

public class Olimpia {
  public static void main(String[] args) {
    int dbArany = 0;
    int dbEzüst = 0;
    int dbBronz = 0;
    String eremFajta = "";
    int ermekSzama = 0;

    eremFajta = Console.readLine("arany/ezüst/bronz? ");
    while (!eremFajta.equals("")) {
      ermekSzama = Console.readInt("db: ");
      if (eremFajta.equals("arany")) {
        dbArany = dbArany + ermekSzama;
      }
      else if (eremFajta.equals("ezüst")) {
        dbEzüst = dbEzüst + ermekSzama;
      }
      else {
        dbBronz = dbBronz + ermekSzama;
      }
      eremFajta = Console.readLine("arany/ezüst/bronz? ");
    }
    System.out.println("Aranyérmek száma: " + dbArany);
    System.out.println("Ezüstérmek száma: " + dbEzüst);
    System.out.println("Bronzérmek száma: " + dbBronz);
  }
}


