/*
 * Feladatmegold�sok/2. fejezet
 * Projekt: SikIdomok
 * Csomag: idomok
 * Kor.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    return Format.left("K�r:",10)+"r="+Format.left(r,5,2)+
           ",  terulet="+Format.left(terulet(),0,2);
  }
}