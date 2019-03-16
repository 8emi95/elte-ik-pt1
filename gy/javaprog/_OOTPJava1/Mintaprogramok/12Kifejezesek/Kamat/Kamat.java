/*
 * Mintaprogramok/12. fejezet
 * Kamat.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Kamat {
  public static void main(String[] args) {
    double osszeg, ujOsszeg;
    double kamatSzazalek;
    int honap;
    osszeg = Console.readDouble("�sszeg (Ft)? ");
    kamatSzazalek = Console.readDouble("Kamat%? ");
    honap = Console.readInt("H�ny h�napra k�ti le? ");

    ujOsszeg = osszeg *
      Math.pow(1+kamatSzazalek/100,honap/12.0);            //1
    System.out.println(honap+" h�nap m�lva "+
      Format.left(ujOsszeg,0,2)+" Ft-ot vehet ki");        //2
  }
}

