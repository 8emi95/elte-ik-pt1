/*
 * Mintaprogramok/12. fejezet
 * Kamat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Kamat {
  public static void main(String[] args) {
    double osszeg, ujOsszeg;
    double kamatSzazalek;
    int honap;
    osszeg = Console.readDouble("Összeg (Ft)? ");
    kamatSzazalek = Console.readDouble("Kamat%? ");
    honap = Console.readInt("Hány hónapra köti le? ");

    ujOsszeg = osszeg *
      Math.pow(1+kamatSzazalek/100,honap/12.0);            //1
    System.out.println(honap+" hónap múlva "+
      Format.left(ujOsszeg,0,2)+" Ft-ot vehet ki");        //2
  }
}

