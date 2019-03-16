/*
 * Feladatmegoldások/12. fejezet
 * Piac.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Piac {
  public static void main(String[] args) {
    int piaciAr = Console.readInt("Hány forint egy kiló eper a piacon? ");
    int boltiAr = Console.readInt("Hány forint egy kiló eper a szomszéd boltban? ");
    int mennyiseg = Console.readInt("Hány kiló epret szeretne befõzni? ");

    int veszteseg = mennyiseg * (boltiAr - piaciAr);
    System.out.println("\n"+veszteseg+
      " Ft veszteség éri, ha a szomszéd boltban veszi az epret.");
  }
}
