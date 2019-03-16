/*
 * Mintaprogramok/16. fejezet
 * HanoiKonzol.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

public class HanoiKonzol {
  static int lepes = 0;

  static void attesz(int n, int mirol, int mire, int manko) {
    if (n == 1)
      System.out.println(++lepes+". lepes: "+mirol+"-"+mire);
    else {
      attesz(n-1,mirol,manko,mire);
      System.out.println(++lepes+". lepes: "+mirol+"-"+mire);
      attesz(n-1,manko,mire,mirol);
    }
  }

  public static void main(String[] args) {
    attesz(4,1,2,3);
  }
}
