/*
 * Feladatmegoldások/18. fejezet
 * TombParam.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class TombParam {

  // Két határérték közötti véletlen valósszám elõállítása:
  static double random(double also, double felso) {
    // a>b esetén a két szám felcserélése:
    if (also>felso) {
      double seged=also; also=felso; felso=also;
    }
    return (Math.random()*(felso-also))+also;
  }

  // a) feladat
  static void feltolt(double[] tomb, double alsoHatar, double felsoHatar) {
    for (int i=0; i<tomb.length; i++)
      tomb[i] = random(alsoHatar,felsoHatar);
  }

  // b) feladat
  static void feltolt(String[] tomb) {
    for (int i=0; i<tomb.length; i++)
      tomb[i] = Console.readLine(Format.right(i+1,2)+". szöveg: ");
  }

  // c) feladat
  static void kiir(double[] tomb) {
    for (int i=0; i<tomb.length; i++)
      System.out.println(Format.right(i+1,2)+". "+Format.right(tomb[i],8,2));
  }

  // d) feladat
  static void kiir(String[] tomb) {
    for (int i=0; i<tomb.length; i++)
      System.out.println(Format.right(i+1,2)+". "+tomb[i]);
  }

  // e) feladat
  static double atlag(double[] tomb) {
    double osszeg = 0;
    for (int i=0; i<tomb.length; i++)
      osszeg += tomb[i];
    return osszeg/tomb.length;
  }

  // f) feladat
  static void megFordit(String[] tomb) {
    for (int i=0; i<tomb.length/2; i++) {
      // i. szöveg kicserélése a párjával:
      int ii = tomb.length-i-1;
      String seged = tomb[i];
      tomb[i] = tomb[ii];
      tomb[ii] = seged;
    }
  }


  public static void main(String[] args) {
    double[] valosak = new double[10];
    feltolt(valosak,3.5,4.5);
    System.out.println("Véletlen valós számok:");
    kiir(valosak);
    System.out.println("Átlag: "+Format.left(atlag(valosak),0,1));

    String[] szovegek = new String[5];

    System.out.println("\nÍrja be a szövegeket:");
    feltolt(szovegek);
    System.out.println("\nSzövegek:");
    kiir(szovegek);
    megFordit(szovegek);
    System.out.println("\nSzövegek fordított sorrendben:");
    kiir(szovegek);
  }
}
