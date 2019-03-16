/*
 * Feladatmegold�sok/18. fejezet
 * Sulyok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class Sulyok {
  public static void main(String[] args) {
    double[] sulyok = new double[10];

    // S�lyok bek�r�se, �tlagsz�m�t�s:
    double atlag=0;
    for (int i=0; i<sulyok.length; i++) {
      sulyok[i] = Console.readDouble(Format.right(i+1,2)+". alma s�lya: ");
      atlag += sulyok[i];
    }
    atlag /= sulyok.length;

    // �tlagt�l val� legnagyobb elt�r�s kiv�laszt�sa:
    double elt, maxElt=-1;
    int maxInd=0;
    for (int i=0; i<sulyok.length; i++) {
      elt = Math.abs(sulyok[i]-atlag);
      if (elt>maxElt) {
        maxElt = elt;
        maxInd = i+1;
      }
    }
    System.out.println("Alm�k �tlags�lya: "+Format.left(atlag,0,2));
    System.out.println("A legjobban a "+maxInd+". alma s�lya t�r el az �tlagt�l.");
    System.out.println("Az elt�r�s: "+Format.left(maxElt,0,2));
  }
}
