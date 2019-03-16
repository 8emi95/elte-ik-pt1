/*
 * Feladatmegold�sok/3. fejezet
 * Projekt: SikIdomok
 * Kor.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package sikidomok;

public class Kor implements SikIdom {
  protected double r;

  public Kor(double r) {
    this.r = r;
  }

  public double kerulet() {
    return 2*r*PI;
  }

  public double terulet() {
    return Math.pow(r,2)*PI;
  }

  public String toString() {
    return "Kor: r="+r;
  }
}
