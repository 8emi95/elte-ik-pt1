/*
 * Feladatmegoldások/2. fejezet
 * Projekt: FaIdomok2
 * Henger.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package idomok;
import extra.Format;

public class Henger extends Idom {
  private double sugar;
  private double magassag;

  public Henger(double sugar, double magassag) {
    this.sugar = sugar;
    this.magassag = magassag;
  }

  public double terfogat() {
    return Math.pow(sugar,2)*Math.PI*magassag;
  }

  public String toString() {
    return "Henger, sugár="+Format.right(sugar,0,1)+" magasság="+Format.right(magassag,0,1)+
      super.toString();
  }
}
