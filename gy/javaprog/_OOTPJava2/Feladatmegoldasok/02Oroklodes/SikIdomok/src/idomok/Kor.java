/*
 * Feladatmegoldások/2. fejezet
 * Projekt: SikIdomok
 * Csomag: idomok
 * Kor.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package idomok;

import extra.Format;

public class Kor extends SikIdom {
  protected double r;

  public Kor(double r) {
    this.r = r;
  }

  public double terulet() {
    return Math.pow(r,2)*Math.PI;
  }

  public String toString() {
    return Format.left("Kör:",10)+"r="+Format.left(r,5,2)+
           ",  terulet="+Format.left(terulet(),0,2);
  }
}