/*
 * Feladatmegold�sok/14. fejezet
 * MunkasFelvetel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class MunkasFelvetel {
  public static void main(String[] args) {
    int letszam = Console.readInt("Sz�ks�ges l�tsz�m: ");
    int osszLetszam=0, csopLetszam;
    do {
      csopLetszam = Console.readInt("Csoport l�tsz�m: ");
      osszLetszam += csopLetszam;
    } while(osszLetszam < letszam);

    System.out.println(letszam+" f�. A l�tsz�m betelt!");
    int felesleg = osszLetszam-letszam;
    System.out.println("Az utols� csoportb�l "+(csopLetszam-felesleg)+" f� sz�ks�ges.");
  }
}
