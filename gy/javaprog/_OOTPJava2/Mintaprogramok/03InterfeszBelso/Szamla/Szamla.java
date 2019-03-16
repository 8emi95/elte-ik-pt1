/*
 * Mintaprogramok/3. fejezet
 * Szamla.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.*;

interface Euro {
  double ARFOLYAM = 230.0;
  String PENZNEM = "EURO";
}

public class Szamla implements Euro {
  public static void main (String args[]) {
    double ftOsszeg = Console.readDouble("�sszeg (Ft): ");
    System.out.println(Format.left(ftOsszeg/ARFOLYAM,0,2)+" "+PENZNEM);
  }
}
