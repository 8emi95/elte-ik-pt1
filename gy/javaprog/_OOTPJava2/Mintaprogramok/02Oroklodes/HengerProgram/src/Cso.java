/*
 * Mintaprogramok/2. fejezet
 * Projekt: HengerProgram
 * Cso.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.Format;

class Cso extends Rud {                               //1
  private double falVastagsag;                        //2

  public Cso(double sugar, double magassag,
      double falVastagsag, double fajsuly) {          //3
    super(sugar,magassag,fajsuly);
    this.falVastagsag = falVastagsag;
  }

  public Cso(double sugar, double magassag,
      double falVastagsag) {                          //4
    this(sugar,magassag,falVastagsag,1);
  }

  public double getFalVastagsag() {                   //5
    return falVastagsag;
  }

  public double terfogat() {                          //6
    Henger belso = new Henger(
      getSugar()-falVastagsag,getMagassag());
    return super.terfogat()-belso.terfogat();
  }

  public String toString() {                          //7
    return super.toString() +
      " Falvastagság: "+Format.right(getFalVastagsag(),0,2);
  }
}
