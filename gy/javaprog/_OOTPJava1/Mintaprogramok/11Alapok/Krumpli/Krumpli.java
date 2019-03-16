/*
 * Mintaprogramok/11. fejezet
 * Krumpli.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.

 * A program a cserkésztábor konyhafõnöke részére készült.
 * A program bekéri a létszámot, majd kiírja a krumpli
 * szükséges mennyiségét.
 */

import extra.*; // az extra egy saját csomag, nem API

public class Krumpli {
  public static void main(String[] args) {
    int letszam;
    double fejadag=0.4, osszesen;

    // A letszam változó bekérése konzolról:
    letszam = Console.readInt("Létszám? ");

    // A szükséges mennyiség kiszámítása és kiírása:
    osszesen = fejadag*letszam;
    System.out.print("A szükséges mennyiség: ");
    System.out.println(letszam+" * "+fejadag+" kg = "
      +Format.left(osszesen,0,2)+" kg");
  }
}
