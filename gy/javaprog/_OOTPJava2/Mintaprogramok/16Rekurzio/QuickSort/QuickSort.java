/*
 * Mintaprogramok/16. fejezet
 * QuickSort.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

public class QuickSort {
  private static long[] t = {6,12,8,9,3,7,22,21,5,20};

  static void quickSort(int bal, int jobb) {
      int i, j;  // futó indexek
      long elvalaszto, temp;  // a tömb kiválasztott eleme

      elvalaszto = t[(bal+jobb)/2];
      i = bal;
      j = jobb;
      while (i<=j) {
        while (t[i]<elvalaszto)
          i++;
        while (t[j]>elvalaszto)
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
    quickSort(0,t.length-1);
    System.out.println("Rendezve: ");
    for (int i=0; i<t.length; i++)
      System.out.print(t[i]+" ");
    System.out.println();
  }
}
