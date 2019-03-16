/*
 * Feladatmegoldások/16. fejezet
 * RendezSzoveg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

public class RendezSzoveg {
  private static String[] t = {"kicsi","gyûrûs","középsõ","mutató","hüvelyk","láb","öl"};

  static void lista(String info) {
    System.out.println(info);
    for (int i=0; i<t.length; i++)
      System.out.print(t[i]+" ");
    System.out.println();
  }

  static void quickSort(int bal, int jobb) {
      int i, j;  // futó indexek
      String elvalaszto, temp;  // a tömb kiválasztott eleme

      elvalaszto = t[(bal+jobb)/2];
      i = bal;
      j = jobb;
      while (i<=j) {
        while (t[i].compareTo(elvalaszto)<0)
          i++;
        while (t[j].compareTo(elvalaszto)>0)
          j--;
        if (i<=j) {
          temp = t[i]; t[i] = t[j]; t[j] = temp;
          i++; j--;
        }
      }
      if (bal<j)
        quickSort(bal,j);
      if (i<jobb)
        quickSort(i,jobb);
    }

  public static void main(String[] args) {
    lista("Rendezés elõtt:");
    quickSort(0,t.length-1);
    lista("Rendezés után:");
  }
}
