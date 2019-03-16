/*
 * Feladatmegoldások/2. fejezet
 * Projekt: SikIdomok
 * Csomag: idomok
 * Teglalap.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package idomok;

import extra.Format;

public class Teglalap extends SikIdom {
  protected double a,b;

  public Teglalap(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double terulet() {
    return a*b;
  }

  public String toString() {
    return Format.left("Téglalap:",10)+"a="+Format.left(a,5,2)+
           ",  b="+Format.left(b,5,2)+
           ",  terület="+Format.left(terulet(),0,2);
  }
}