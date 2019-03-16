/*
 * Mintaprogramok/18. fejezet
 * ParamTeszt.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

public class ParamTeszt {
  // A formális paraméter primitív elemtípusú tömb:
  static void kiir(int[] tomb) {
    for (int i=0; i<tomb.length; i++)
      System.out.print(tomb[i]+" ");
    System.out.println();
  }

  // A formális paraméter Object elemtípusú tömb:
  static void kiir(Object[] tomb) {
    for (int i=0; i<tomb.length; i++)
      System.out.print(tomb[i]+" ");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] szamok1 = new int[2], szamok2 = new int[5];
    szamok1[1] = 5;
    szamok2[0] = 99; szamok2[4] = -5;

    kiir(szamok1); kiir(szamok2);

    String[] szerzok1 = {"Mozart","Wagner","Beethoven"};
    StringBuffer[] szerzok2 = new StringBuffer[2];
    szerzok2[0] = new StringBuffer("Monteverdi");
    szerzok2[1] = new StringBuffer("Corelli");
    kiir(szerzok1); kiir(szerzok2);
  }
}
