/*
 * Feladatmegoldások/13. fejezet
 * Udvariassag1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Udvariassag1 {
  public static void main(String[] args) {
    final int AKTEV = 2001;
    int korZsofi = AKTEV-Console.readInt("Zsófi születési éve: ");
    int korKati = AKTEV-Console.readInt("Kati születési éve: ");
    int korJuli = AKTEV-Console.readInt("Juli születési éve: ");

    if (korZsofi >= korKati && korKati >= korJuli)
      System.out.println("Zsófi, Kati, Juli");
    else if (korZsofi >= korJuli && korJuli >= korKati)
      System.out.println("Zsófi, Juli, Kati");
    else if (korKati >= korZsofi && korZsofi >= korJuli)
      System.out.println("Kati, Zsófi, Juli");
    else if (korKati >= korJuli && korJuli >= korZsofi)
      System.out.println("Kati, Juli, Zsófi");
    else if (korJuli >= korZsofi && korZsofi >= korKati)
      System.out.println("Juli, Zsófi, Kati");
    else //(korJuli >= korKati && korKati >= korZsofi)
      System.out.println("Juli, Kati, Zsófi");
  }
}
