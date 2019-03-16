/*
 * Mintaprogramok/2. fejezet
 * Projekt: FaIdomok
 * Gomb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package idomok;
import extra.Format;

public class Gomb extends Idom {
  private double sugar;

  public Gomb(double sugar) {
    this.sugar = sugar;
  }

  public double terfogat() {
    return 4*Math.pow(sugar,3)*Math.PI/3;
  }

  public String toString() {
    return "Gömb, sugár="+Format.right(sugar,0,1)+
      super.toString();
  }
}
