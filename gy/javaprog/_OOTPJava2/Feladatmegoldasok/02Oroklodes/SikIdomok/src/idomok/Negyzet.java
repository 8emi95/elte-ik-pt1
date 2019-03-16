/*
 * Feladatmegoldások/2. fejezet
 * Projekt: SikIdomok
 * Csomag: idomok
 * Negyzet.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package idomok;

import extra.Format;

public class Negyzet extends Teglalap {

  public Negyzet(double a) {
    super(a,a);
  }

  public String toString() {
    return Format.left("Négyzet:",10)+"a="+Format.left(a,5,2)+
           ",  terület="+Format.left(terulet(),0,2);
  }
}