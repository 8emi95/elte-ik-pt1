/*
 * Feladatmegold�sok/15. fejezet
 * SokszorKiir.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

public class SokszorKiir {

  // a) feladat
  static void sokszorKiir() {
    sokszorKiir(10,"Ezent�l mindig sz�pen strukt�r�lom a programomat.");
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
    sokszorKiir(5,"De az�rt m�g tanulok.");
  }
}
