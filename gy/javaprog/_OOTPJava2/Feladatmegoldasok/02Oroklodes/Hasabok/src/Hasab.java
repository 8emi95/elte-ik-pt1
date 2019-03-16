/*
 * Feladatmegoldások/2. fejezet
 * Projekt: Hasabok
 * Hasab.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.Format;

class Hasab {
  protected double szelesseg, hosszusag, magassag;
  private static int hasabokSzama=0;

  public Hasab(double szelesseg, double hosszusag, double magassag) {
    this.szelesseg=szelesseg;
    this.hosszusag=hosszusag;
    this.magassag=magassag;
    hasabokSzama++;
  }


  public Hasab() {
    this(1,1,1);
  }

  public double getSzelesseg() { return szelesseg; }
  public double getHosszusag() { return hosszusag; }
  public double getMagassag() { return magassag; }
  public static int getHasabokSzama() { return hasabokSzama; }

  public double terfogat() {
    return szelesseg*hosszusag*magassag;
  }

  public double felszin() {
    return 2 * (szelesseg*hosszusag + szelesseg*magassag + hosszusag*magassag);
  }

  public String toString() {
    return "Hasáb:  szélesség: "+Format.left(szelesseg,5,2)+
           ",  hosszúság: "+Format.left(hosszusag,5,2)+
           ",  magasság: "+Format.left(magassag,5,2)+
           ",  térfogat: "+Format.left(terfogat(),6,2)+
           ",  felszín: "+Format.left(felszin(),5,2);
  }
}