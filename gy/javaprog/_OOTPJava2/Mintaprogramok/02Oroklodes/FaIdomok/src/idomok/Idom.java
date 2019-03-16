/*
 * Mintaprogramok/2. fejezet
 * Projekt: FaIdomok
 * Idom.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    return " t�rfogat="+Format.right(terfogat(),0,1)+
      " s�ly="+Format.right(suly(),0,1);
  }
}
