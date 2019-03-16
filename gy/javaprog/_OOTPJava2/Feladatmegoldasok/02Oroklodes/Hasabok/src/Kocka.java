/*
 * Feladatmegoldások/2. fejezet
 * Projekt: Hasabok
 * Kocka.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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

  // Jó lenne az eredeti metódus is, de így gyorsabb:
  public double terfogat() {
    return Math.pow(szelesseg,3);
  }

  // Jó lenne az eredeti metódus is, de így gyorsabb:
  public double felszin() {
    return 6*Math.pow(szelesseg,2);
  }

  public String toString() {
    return "Kocka:  oldal: "+Format.left(getSzelesseg(),5,2)+
           ",  térfogat: "+Format.left(terfogat(),5,2)+
           ",  felszín: "+Format.left(felszin(),5,2);
  }

}