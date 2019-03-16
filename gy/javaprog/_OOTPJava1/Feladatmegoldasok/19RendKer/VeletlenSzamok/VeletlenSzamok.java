/*
 * Feladatmegoldások/19. fejezet
 * VeletlenSzamok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class Szamok {
  private double[] szamok;
  public Szamok(int db, int alsoHatar, int felsoHatar) {
    szamok = new double[db];
    for (int i=0; i<szamok.length; i++)
      szamok[i] = (Math.random()*(felsoHatar-alsoHatar))+alsoHatar;
  }

  // a) feladat:
  public void rendezNovekvo() {
    for (int i=0; i<=szamok.length-2; i++) {
      int minIndex = i;
      for (int j=i+1; j<=szamok.length-1; j++)
        if (szamok[j] < szamok[minIndex])    // elemek hasonlítása
          minIndex = j;
      if (i != minIndex) {
        double seged = szamok[i];      // i. és minIndex. elem cseréje
        szamok[i] = szamok[minIndex];
        szamok[minIndex] = seged;
      }
    }
  }

  // b) feladat:
  public void rendezCsokkeno() {
    for (int i=0; i<=szamok.length-2; i++) {
      int minIndex = i;
      for (int j=i+1; j<=szamok.length-1; j++)
        if (szamok[j] > szamok[minIndex])    // elemek hasonlítása
          minIndex = j;
      if (i != minIndex) {
        double seged = szamok[i];      // i. és minIndex. elem cseréje
        szamok[i] = szamok[minIndex];
        szamok[minIndex] = seged;
      }
    }
  }

  // c) feladat:
  private boolean rendezettMaskepp(double a, double b) {
    return
      (a>=0 && b<0) ||
      (a>=0 && b>=0 && a<b) ||
      (a<0 && b<0 && a>b);
  }

  public void rendezMaskepp() {
    for (int i=0; i<=szamok.length-2; i++) {
      int minIndex = i;
      for (int j=i+1; j<=szamok.length-1; j++)
        if (!rendezettMaskepp(szamok[minIndex],szamok[j]))    // elemek hasonlítása
          minIndex = j;
      if (i != minIndex) {
        double seged = szamok[i];      // i. és minIndex. elem cseréje
        szamok[i] = szamok[minIndex];
        szamok[minIndex] = seged;
      }
    }
  }

  public void listaz() {
    for (int i=0; i<szamok.length; i++)
      System.out.print(Format.right(szamok[i],8,2));
    System.out.println();
  }
}

public class VeletlenSzamok {
  public static void main(String[] args) {
    Szamok szamok = new Szamok(1000,-100,100);
    System.out.println("\nSzámok rendezése növekvõleg:");
    szamok.rendezNovekvo();
    szamok.listaz();

    System.out.println("\nSzámok rendezése csökkenõleg:");
    szamok.rendezCsokkeno();
    szamok.listaz();

    System.out.println("\nSzámok rendezése másképp:");
    szamok.rendezMaskepp();
    szamok.listaz();
  }
}
