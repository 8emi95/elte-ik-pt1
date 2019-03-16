/*
 * Feladatmegold�sok/2. fejezet
 * Projekt: SikIdomok
 * Csomag: idomok
 * Negyzet.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package idomok;

import extra.Format;

public class Negyzet extends Teglalap {

  public Negyzet(double a) {
    super(a,a);
  }

  public String toString() {
    return Format.left("N�gyzet:",10)+"a="+Format.left(a,5,2)+
           ",  ter�let="+Format.left(terulet(),0,2);
  }
}