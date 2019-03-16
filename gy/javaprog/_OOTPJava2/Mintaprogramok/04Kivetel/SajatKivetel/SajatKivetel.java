/*
 * Mintaprogramok/4. fejezet
 * SajatKivetel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

// Saját kivételosztály:
class OutOfRangeException extends RuntimeException {
  OutOfRangeException(String s) { super(s); }
}

public class SajatKivetel {

  static int readSzam(int tol, int ig) {
    if (tol > ig) {
      int seged=tol; tol=ig; ig=seged;
    }

    int szam;
    while (true) {
      try {
        // NumberFormatException keletkezhet:
        szam = Integer.parseInt(Console.readLine("Szam: "));
        if (szam < tol || szam > ig)
          throw new OutOfRangeException(tol+"-tol "+ig+"-ig!");
        return szam;
      } // try
      catch (NumberFormatException ex) {
        System.out.println("Illegalis karakter!");
      }
      catch (OutOfRangeException ex) {
        System.out.println(ex.getMessage());
      }
    } // while
  }

  public static void main (String args[]) {
    int lottoSzam = readSzam(1,90);
    System.out.println("OK");
  }
}


