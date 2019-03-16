/*
 * Feladatmegold�sok/4. fejezet
 * MagyarNull.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.*;

class MasikOsztaly {
  public static void osztas() {
    double eredm = 1/Console.readInt("Oszt�: ");
  }
}

public class MagyarNull {

  static void osztas() {
    double eredm = 1/Console.readInt("Oszt�: ");
  }

  public static void main (String args[]) {
    try {
      // Oszt�si k�s�rlet a main-ben:
      double eredm = 1/Console.readInt("Oszt�: ");
      // Oszt�si k�s�rlet a MagyarNull.osztas-ban:
      osztas();
      // Oszt�si k�s�rlet a MasikOsztaly.osztas-ban:
      MasikOsztaly.osztas();
    }
    catch (ArithmeticException e) {
      if (e.getMessage().equals("/ by zero")) {
        throw new ArithmeticException("Null�val osztott�l!");
      }
    }
  }
}
