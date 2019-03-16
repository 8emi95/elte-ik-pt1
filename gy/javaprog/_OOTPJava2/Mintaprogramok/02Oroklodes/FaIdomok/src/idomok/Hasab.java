/*
 * Mintaprogramok/2. fejezet
 * Projekt: FaIdomok
 * Hasab.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package idomok;
import extra.Format;

public class Hasab extends Idom {
  private double a,b, magassag;

  public Hasab(double a, double b, double magassag) {
    this.a = a;
    this.b = b;
    this.magassag = magassag;
  }

  public double terfogat() {
    return a*b*magassag;
  }

  public String toString() {
    return "Hasáb, a="+Format.right(a,0,1) + " b="+Format.right(b,0,1)+
      " magasság="+Format.right(magassag,0,1)+
      super.toString();
  }
}
