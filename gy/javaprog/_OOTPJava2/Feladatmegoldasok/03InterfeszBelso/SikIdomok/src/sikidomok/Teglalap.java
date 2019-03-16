/*
 * Feladatmegoldások/3. fejezet
 * Projekt: SikIdomok
 * Teglalap.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package sikidomok;

public class Teglalap implements SikIdom {
  protected double a, b;

  public Teglalap(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double kerulet() {
    return 2*(a+b);
  }

  public double terulet() {
    return a*b;
  }

  public String toString() {
    return "Teglalap: a="+a+", b="+b;
  }
}
