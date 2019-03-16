/*
 * Feladatmegoldások/15. fejezet
 * SokszorKiir.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

public class SokszorKiir {

  // a) feladat
  static void sokszorKiir() {
    sokszorKiir(10,"Ezentúl mindig szépen struktúrálom a programomat.");
  }

  // b) feladat
  static void sokszorKiir(String szoveg) {
    sokszorKiir(10,szoveg);
  }

  // c) feladat
  static void sokszorKiir(int n, String szoveg) {
    for (int i=1; i<=n; i++)
      System.out.println(szoveg);
  }

  public static void main(String[] args) {
    sokszorKiir();
    sokszorKiir("Profi vagyok.");
    sokszorKiir(5,"De azért még tanulok.");
  }
}
