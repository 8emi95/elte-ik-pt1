/*
 * Feladatmegold�sok/13. fejezet
 * Udvariassag2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Udvariassag2 {
  public static void main(String[] args) {
    final int AKTEV = 2001;
    int korZsofi = AKTEV-Console.readInt("Zs�fi sz�let�si �ve: ");
    int korKati = AKTEV-Console.readInt("Kati sz�let�si �ve: ");
    int korJuli = AKTEV-Console.readInt("Juli sz�let�si �ve: ");

    if (korZsofi >= korKati) {
      if (korZsofi>= korJuli) {
        if (korKati>= korJuli)
          System.out.println("Zs�fi, Kati, Juli");
        else
          System.out.println("Zs�fi, Juli, Kati");
      }
      else
        System.out.println("Juli, Zs�fi, Kati");
    }
    else {
      if (korKati>= korJuli) {
        if (korZsofi>= korJuli)
          System.out.println("Kati, Zs�fi, Juli");
        else
          System.out.println("Kati, Juli, Zs�fi");
      }
      else
        System.out.println("Juli, Kati, Zs�fi");
    }
  }
}
