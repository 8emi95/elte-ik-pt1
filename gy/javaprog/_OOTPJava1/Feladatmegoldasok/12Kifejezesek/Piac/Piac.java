/*
 * Feladatmegold�sok/12. fejezet
 * Piac.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Piac {
  public static void main(String[] args) {
    int piaciAr = Console.readInt("H�ny forint egy kil� eper a piacon? ");
    int boltiAr = Console.readInt("H�ny forint egy kil� eper a szomsz�d boltban? ");
    int mennyiseg = Console.readInt("H�ny kil� epret szeretne bef�zni? ");

    int veszteseg = mennyiseg * (boltiAr - piaciAr);
    System.out.println("\n"+veszteseg+
      " Ft vesztes�g �ri, ha a szomsz�d boltban veszi az epret.");
  }
}
