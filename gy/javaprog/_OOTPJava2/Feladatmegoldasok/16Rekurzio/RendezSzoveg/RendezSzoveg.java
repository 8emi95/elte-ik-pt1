/*
 * Feladatmegold�sok/16. fejezet
 * RendezSzoveg.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

public class RendezSzoveg {
  private static String[] t = {"kicsi","gy�r�s","k�z�ps�","mutat�","h�velyk","l�b","�l"};

  static void lista(String info) {
    System.out.println(info);
    for (int i=0; i<t.length; i++)
      System.out.print(t[i]+" ");
    System.out.println();
  }

  static void quickSort(int bal, int jobb) {
      int i, j;  // fut� indexek
      String elvalaszto, temp;  // a t�mb kiv�lasztott eleme

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
    lista("Rendez�s el�tt:");
    quickSort(0,t.length-1);
    lista("Rendez�s ut�n:");
  }
}
