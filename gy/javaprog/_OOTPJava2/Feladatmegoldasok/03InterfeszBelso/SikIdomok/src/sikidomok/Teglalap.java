/*
 * Feladatmegold�sok/3. fejezet
 * Projekt: SikIdomok
 * Teglalap.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
