/*
 * Feladatmegold�sok/3. fejezet
 * Projekt: SikIdomok
 * Negyzet.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package sikidomok;

public class Negyzet extends Teglalap {
  public Negyzet(double a) {
    super(a,a);
  }

  public String toString() {
    return "Negyzet: a="+a;
  }
}
