/*
 * Mintaprogramok/4. fejezet
 * Kezeles.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.*;

public class Kezeles {
  public static void main (String args[]) {
    int szam;
    boolean ok = false;
    do {
      try {
        String str = Console.readLine("Eg�sz sz�m: ");
        // NumberFormatException lehets�ges:
        szam = Integer.parseInt(str);
        // Ide csak siker eset�n ker�l a vez�rl�s:
        ok = true;
        System.out.println("OK");
      }
      catch (NumberFormatException ex) {
        System.out.println("M�g egyszer! ");
      }
    } while (!ok);
  }
}
