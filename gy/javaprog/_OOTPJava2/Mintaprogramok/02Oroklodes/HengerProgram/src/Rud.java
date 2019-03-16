/*
 * Mintaprogramok/2. fejezet
 * Projekt: HengerProgram
 * Rud.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.Format;

class Rud extends Henger {                           //1
  private double fajsuly;                            //2

  public Rud(double sugar, double magassag,
      double fajsuly) {                              //3
    super(sugar,magassag);
    this.fajsuly = fajsuly;
  }

  public Rud(double sugar, double magassag) {        //4
    this(sugar, magassag, 1);
  }

  public double getFajsuly() {                       //5
    return fajsuly;
  }

  public double suly() {                             //6
    return terfogat()*fajsuly;
  }

  public String toString() {                         //7
    return super.toString() +
      "\nFajsúly: "+Format.right(getFajsuly(),0,2) +
      " Súly: "+Format.right(suly(),0,2);
  }
}
