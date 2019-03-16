/*
 * Mintaprogramok/2. fejezet
 * Projekt: HengerProgram
 * Henger.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.Format;

class Henger {                                            //1
  private static int szuletesSzamlalo=0;                  //2
  private double sugar, magassag;

  public Henger(double sugar, double magassag) {          //3
    this.sugar = sugar;
    this.magassag = magassag;
    szuletesSzamlalo++;
  }

  public static int getSzuletesSzamlalo() {               //4
    return szuletesSzamlalo;
  }

  public double getSugar() {                              //5
    return sugar;
  }

  public double getMagassag() {                           //6
    return magassag;
  }

  public double terfogat() {                              //7
    return (sugar*sugar*Math.PI*magassag);
  }

  public String toString() {                              //8
    return "\n"+getClass().getName() +
      "\nSug�r: "+Format.right(getSugar(),0,2) +
      " Magass�g: "+Format.right(getMagassag(),0,2) +
      " T�rfogat: "+Format.right(terfogat(),0,2);
  }
}
