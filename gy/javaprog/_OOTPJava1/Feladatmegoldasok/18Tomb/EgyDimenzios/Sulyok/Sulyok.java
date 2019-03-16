/*
 * Feladatmegoldások/18. fejezet
 * Sulyok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class Sulyok {
  public static void main(String[] args) {
    double[] sulyok = new double[10];

    // Súlyok bekérése, átlagszámítás:
    double atlag=0;
    for (int i=0; i<sulyok.length; i++) {
      sulyok[i] = Console.readDouble(Format.right(i+1,2)+". alma súlya: ");
      atlag += sulyok[i];
    }
    atlag /= sulyok.length;

    // Átlagtól való legnagyobb eltérés kiválasztása:
    double elt, maxElt=-1;
    int maxInd=0;
    for (int i=0; i<sulyok.length; i++) {
      elt = Math.abs(sulyok[i]-atlag);
      if (elt>maxElt) {
        maxElt = elt;
        maxInd = i+1;
      }
    }
    System.out.println("Almák átlagsúlya: "+Format.left(atlag,0,2));
    System.out.println("A legjobban a "+maxInd+". alma súlya tér el az átlagtól.");
    System.out.println("Az eltérés: "+Format.left(maxElt,0,2));
  }
}
