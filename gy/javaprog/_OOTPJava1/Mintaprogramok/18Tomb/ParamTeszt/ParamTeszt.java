/*
 * Mintaprogramok/18. fejezet
 * ParamTeszt.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

public class ParamTeszt {
  // A form�lis param�ter primit�v elemt�pus� t�mb:
  static void kiir(int[] tomb) {
    for (int i=0; i<tomb.length; i++)
      System.out.print(tomb[i]+" ");
    System.out.println();
  }

  // A form�lis param�ter Object elemt�pus� t�mb:
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
