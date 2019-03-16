/*
 * Feladatmegoldások/13. fejezet
 * Udvariassag2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Udvariassag2 {
  public static void main(String[] args) {
    final int AKTEV = 2001;
    int korZsofi = AKTEV-Console.readInt("Zsófi születési éve: ");
    int korKati = AKTEV-Console.readInt("Kati születési éve: ");
    int korJuli = AKTEV-Console.readInt("Juli születési éve: ");

    if (korZsofi >= korKati) {
      if (korZsofi>= korJuli) {
        if (korKati>= korJuli)
          System.out.println("Zsófi, Kati, Juli");
        else
          System.out.println("Zsófi, Juli, Kati");
      }
      else
        System.out.println("Juli, Zsófi, Kati");
    }
    else {
      if (korKati>= korJuli) {
        if (korZsofi>= korJuli)
          System.out.println("Kati, Zsófi, Juli");
        else
          System.out.println("Kati, Juli, Zsófi");
      }
      else
        System.out.println("Juli, Kati, Zsófi");
    }
  }
}
