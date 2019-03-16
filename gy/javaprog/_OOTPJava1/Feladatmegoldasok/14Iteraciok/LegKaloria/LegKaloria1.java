/*
 * Feladatmegold�sok/14. fejezet
 * LegKaloria1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class  LegKaloria1 {
  public static void main(String[] args) {
    //Ebben a megold�sban felt�telezz�k, hogy 1 minimum �s maximum van.
    int napiKaloria = Console.readInt("1. nap kal�ri�ja: ");
    int min=napiKaloria , max=napiKaloria, minNap=1, maxNap=1;
    for (int nap=2; nap<=7; nap++) {
      napiKaloria = Console.readInt(nap+". nap kal�ri�ja: ");
      if (napiKaloria<min) {
        min=napiKaloria;
        minNap=nap;
      }
      else if (napiKaloria>max) {
        max=napiKaloria;
        maxNap=nap;
      }
    }
    System.out.println("A legkevesebb kal�ri�t ("+min+") a "+minNap+". napon fogyasztottuk.");
    System.out.println("A legt�bb kal�ri�t ("+max+") a "+maxNap+". napon fogyasztottuk.");
  }
}