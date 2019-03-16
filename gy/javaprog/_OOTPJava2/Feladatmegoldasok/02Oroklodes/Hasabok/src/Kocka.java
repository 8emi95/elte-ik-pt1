/*
 * Feladatmegold�sok/2. fejezet
 * Projekt: Hasabok
 * Kocka.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.Format;

class Kocka extends Hasab {
  private static int kockakSzama=0;

  public Kocka(double oldal) {
    super(oldal,oldal,oldal);
    kockakSzama++;
  }

  public Kocka() {
    this(1);
  }

  public static int getKockakSzama() { return kockakSzama; }

  // J� lenne az eredeti met�dus is, de �gy gyorsabb:
  public double terfogat() {
    return Math.pow(szelesseg,3);
  }

  // J� lenne az eredeti met�dus is, de �gy gyorsabb:
  public double felszin() {
    return 6*Math.pow(szelesseg,2);
  }

  public String toString() {
    return "Kocka:  oldal: "+Format.left(getSzelesseg(),5,2)+
           ",  t�rfogat: "+Format.left(terfogat(),5,2)+
           ",  felsz�n: "+Format.left(felszin(),5,2);
  }

}