/*
 * Feladatmegoldások/14. fejezet
 * MunkasFelvetel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class MunkasFelvetel {
  public static void main(String[] args) {
    int letszam = Console.readInt("Szükséges létszám: ");
    int osszLetszam=0, csopLetszam;
    do {
      csopLetszam = Console.readInt("Csoport létszám: ");
      osszLetszam += csopLetszam;
    } while(osszLetszam < letszam);

    System.out.println(letszam+" fõ. A létszám betelt!");
    int felesleg = osszLetszam-letszam;
    System.out.println("Az utolsó csoportból "+(csopLetszam-felesleg)+" fõ szükséges.");
  }
}
