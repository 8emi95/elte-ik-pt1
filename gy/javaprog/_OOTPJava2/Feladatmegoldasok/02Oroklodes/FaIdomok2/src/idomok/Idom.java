/*
 * Feladatmegoldások/2. fejezet
 * Projekt: FaIdomok2
 * Idom.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package idomok;
import extra.Format;

public abstract class Idom implements Comparable {
  private static double FAJSULY = 0.8;
  public abstract double terfogat();

  public double suly() {
    return terfogat()*FAJSULY;
  }

  public int compareTo(Object obj) {
    double t = ((Idom)obj).terfogat();
    if (t > terfogat())
      return -1;
    else if (t < terfogat())
      return 1;
    else
      return 0;
  }

  public String toString() {
    return " terfogat="+Format.right(terfogat(),0,1)+
      " suly="+Format.right(suly(),0,1);
  }
}
