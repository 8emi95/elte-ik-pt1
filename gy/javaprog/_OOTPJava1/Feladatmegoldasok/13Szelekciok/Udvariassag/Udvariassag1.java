/*
 * Feladatmegold�sok/13. fejezet
 * Udvariassag1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Udvariassag1 {
  public static void main(String[] args) {
    final int AKTEV = 2001;
    int korZsofi = AKTEV-Console.readInt("Zs�fi sz�let�si �ve: ");
    int korKati = AKTEV-Console.readInt("Kati sz�let�si �ve: ");
    int korJuli = AKTEV-Console.readInt("Juli sz�let�si �ve: ");

    if (korZsofi >= korKati && korKati >= korJuli)
      System.out.println("Zs�fi, Kati, Juli");
    else if (korZsofi >= korJuli && korJuli >= korKati)
      System.out.println("Zs�fi, Juli, Kati");
    else if (korKati >= korZsofi && korZsofi >= korJuli)
      System.out.println("Kati, Zs�fi, Juli");
    else if (korKati >= korJuli && korJuli >= korZsofi)
      System.out.println("Kati, Juli, Zs�fi");
    else if (korJuli >= korZsofi && korZsofi >= korKati)
      System.out.println("Juli, Zs�fi, Kati");
    else //(korJuli >= korKati && korKati >= korZsofi)
      System.out.println("Juli, Kati, Zs�fi");
  }
}
