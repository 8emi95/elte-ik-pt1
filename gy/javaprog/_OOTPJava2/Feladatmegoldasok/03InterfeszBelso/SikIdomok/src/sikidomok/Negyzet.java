/*
 * Feladatmegoldások/3. fejezet
 * Projekt: SikIdomok
 * Negyzet.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
