/*
 * Mintaprogramok/4. fejezet
 * Kezeles.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;

public class Kezeles {
  public static void main (String args[]) {
    int szam;
    boolean ok = false;
    do {
      try {
        String str = Console.readLine("Egész szám: ");
        // NumberFormatException lehetséges:
        szam = Integer.parseInt(str);
        // Ide csak siker esetén kerül a vezérlés:
        ok = true;
        System.out.println("OK");
      }
      catch (NumberFormatException ex) {
        System.out.println("Még egyszer! ");
      }
    } while (!ok);
  }
}
