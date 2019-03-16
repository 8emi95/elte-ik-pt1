/*
 * Feladatmegoldások/2. fejezet
 * Projekt: SikIdomok
 * Csomag: idomok
 * SikIdom.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package idomok;

public abstract class SikIdom implements Comparable {

  public abstract double terulet();

  public int compareTo(Object obj) {
    double ter1 = terulet();
    double ter2 = ((SikIdom)obj).terulet();
    if (ter1 < ter2)
      return -1;
    if (ter1 > ter2)
      return 1;
    return 0;
    /* Másik megoldás:
    return (int)Math.round((terulet()-((SikIdom)obj).terulet()));
    */
  }
}
