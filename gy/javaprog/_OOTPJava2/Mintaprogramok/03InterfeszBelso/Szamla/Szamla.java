/*
 * Mintaprogramok/3. fejezet
 * Szamla.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;

interface Euro {
  double ARFOLYAM = 230.0;
  String PENZNEM = "EURO";
}

public class Szamla implements Euro {
  public static void main (String args[]) {
    double ftOsszeg = Console.readDouble("Összeg (Ft): ");
    System.out.println(Format.left(ftOsszeg/ARFOLYAM,0,2)+" "+PENZNEM);
  }
}
