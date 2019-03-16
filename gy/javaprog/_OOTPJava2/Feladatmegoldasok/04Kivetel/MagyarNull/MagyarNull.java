/*
 * Feladatmegoldások/4. fejezet
 * MagyarNull.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;

class MasikOsztaly {
  public static void osztas() {
    double eredm = 1/Console.readInt("Osztó: ");
  }
}

public class MagyarNull {

  static void osztas() {
    double eredm = 1/Console.readInt("Osztó: ");
  }

  public static void main (String args[]) {
    try {
      // Osztási kísérlet a main-ben:
      double eredm = 1/Console.readInt("Osztó: ");
      // Osztási kísérlet a MagyarNull.osztas-ban:
      osztas();
      // Osztási kísérlet a MasikOsztaly.osztas-ban:
      MasikOsztaly.osztas();
    }
    catch (ArithmeticException e) {
      if (e.getMessage().equals("/ by zero")) {
        throw new ArithmeticException("Nullával osztottál!");
      }
    }
  }
}
