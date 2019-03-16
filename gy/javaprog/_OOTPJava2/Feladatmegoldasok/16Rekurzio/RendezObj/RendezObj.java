/*
 * Feladatmegoldások/16. fejezet
 * RendezObj.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

/* Versenyzõ. Az van elõbb a rendezésben, akinak nagyobb a
 * pontszáma. A pontszámok egyenlõsége esetén a név dönt.
 */
class Versenyzo implements Comparable {
  private String nev;
  private double pontszam;

  public Versenyzo(String nev, double pontszam) {
    this.nev = nev;
    this.pontszam = pontszam;
  }

  public String getNev() {
    return nev;
  }

  public double getPontszam() {
    return pontszam;
  }

  private int comparePontszam(double pontszam1, double pontszam2) {
    if (pontszam1 > pontszam2)
      return -1;
    else if (pontszam1 < pontszam2)
      return 1;
    else
      return 0;
  }

  public int compareTo(Object obj) {
    Versenyzo ver = (Versenyzo)obj;
    int comparePontszam = comparePontszam(pontszam,ver.getPontszam());
    if (comparePontszam != 0)
      return comparePontszam;
    else
      return nev.compareTo(ver.getNev());
  }

  public String toString() {
    return pontszam +" ("+nev+")";
  }
}

public class RendezObj {
  private static Comparable[] t = new Comparable[4];

  static {
    t[0] = new Versenyzo("Halmos Bertalan",14.6);
    t[1] = new Versenyzo("Kardos Bendegúz",14.6);
    t[2] = new Versenyzo("Halmos Bertalan",15.1);
    t[3] = new Versenyzo("Kardos Bendegúz",19.0);
  }

  static void lista(String info) {
    System.out.println(info);
    for (int i=0; i<t.length; i++)
      System.out.println(t[i]);
    System.out.println();
  }

  // Gyorsrendezõ algoritmus, amely Comparable objektumokat rendez:
  static void quickSort(int bal, int jobb) {
      int i, j;  // futó indexek
      Comparable elvalaszto, temp;  // a tömb kiválasztott eleme

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

    // Más megoldás. Quicksort helyett a Collections.sort-tal rendezünk:
    Vector v = new Vector();
    for (int i = 0; i < t.length; i++) {
      v.add(t[i]);
    }
    Collections.sort(v);
    lista("Rendezés után:");
  }
}
