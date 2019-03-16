/*
 * Feladatmegold�sok/19. fejezet
 * HordoKereses.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 *
 * A compareTo() met�dust h�rom f�lek�ppen adtuk meg az a, b, illetve c feladatnak megfelel�en.
 */

import extra.*;

class Hordo {
  private int atmero, magassag;   // cm-ben

  public Hordo(int atmero, int magassag) {
    this.atmero = atmero;
    this.magassag = magassag;
  }

  public int getAtmero() { return atmero; }
  public int getMagassag() { return magassag; }

  public int kapacitas() {     // literben
    return (int)(Math.round(Math.pow(atmero/2.0,2)*
      Math.PI*magassag/1000));
  }

  public boolean equals(Hordo hordo) {
    return (hordo.atmero == atmero) &&
      (hordo.magassag == magassag);
  }

  /* a) feladat:
   * Rendezetts�g: kapacit�s, azon bel�l �tm�r� szerint n�vekv�.
  public int compareTo(Hordo hordo) {
    if (kapacitas()!=hordo.kapacitas())
      return kapacitas()-hordo.kapacitas();
    return atmero-hordo.getAtmero();
  }
  */

  /* b) feladat:
   * Rendezetts�g: kapacit�sszerint n�vekv�, azon bel�l �tm�r� szerint cs�kken�.
  public int compareTo(Hordo hordo) {
    if (kapacitas()!=hordo.kapacitas())
      return kapacitas()-hordo.kapacitas();
    return hordo.getAtmero()-atmero;
  }
  */

  /* c) feladat:
   * Rendezetts�g: kapacit�s, azon bel�l magass�g szerint cs�kken�.*/

  public int compareTo(Hordo hordo) {
    if (kapacitas()!=hordo.kapacitas())
      return hordo.kapacitas()-kapacitas();
    return hordo.getMagassag()-magassag;
  }

  public String toString() {
    return "\n�tm�r�:"+Format.right(atmero,6)+
      " Magass�g:"+Format.right(magassag,6)+
      " Kapacit�s:"+Format.right(kapacitas(),8);
  }
}

class Kontener {
  private Hordo[] hordok = new Hordo[1000];
  private int size=0;

  public Kontener() {
    int atmero, magassag;
    while (size<hordok.length && (atmero=Console.readInt("\n�tm�r�: "))!= 0) {
      hordok[size++] = new Hordo(atmero,Console.readInt("Magass�g: "));
    }
    rendez();
  }

  public void kiir() {
    for (int i=0; i<size; i++)
      System.out.print(hordok[i]+" ");
    System.out.println();
  }

  private void rendez() {
    for (int i=0; i<=size-2; i++) {
      int minIndex = i;
      for (int j=i+1; j<=size-1; j++)
        if (hordok[j].compareTo(hordok[minIndex])<0)  // hordok[j] < hordok[minIndex]
          minIndex = j;
      if (i != minIndex) {
        Hordo seged = hordok[i];      // i. �s minIndex. elem cser�je
        hordok[i] = hordok[minIndex];
        hordok[minIndex] = seged;
      }
    }
  }

  // Adott m�ret� hord� keres�se:
  public int indexOf(Hordo hordo) {
    for (int i=0; i<size; i++) {
      if (hordok[i].equals(hordo))
        return i;
    }
    return -1;
  }

  // Adott kapacit�s� hord� keres�se el�lr�l:
  public int indexOf(int kap) {
    return indexOf(kap,0);
  }

  // Adott kapacit�s� hord� keres�se az adott indext�l:
  public int indexOf(int kap, int index) {
    for (int i=index; i<size; i++) {
      int iKap = hordok[i].kapacitas();
      if (iKap == kap)
        return i;
      if (iKap > kap)
        return -1;
    }
    return -1;
  }
}

public class HordoKereses {
  private Kontener kontener;

  public HordoKereses() {
    kontener = new Kontener();
    kontener.kiir();
    meretKereses();
    kapacitasKereses();
  }

  // Adott m�ret� hord�k keres�se:
  void meretKereses() {
    int atmero, magassag;
    Hordo hasonlitoHordo;
    atmero = Console.readInt("\n�tm�r�: ");
    while (atmero!=0) {
      hasonlitoHordo = new Hordo(atmero,Console.readInt("Magass�g: "));
      int index = kontener.indexOf(hasonlitoHordo);
      if (index >= 0)
        System.out.println("Indexe: "+index);
      else
        System.out.println("Nincs ilyen elem");
      atmero = Console.readInt("\n�tm�r�: ");
    }
  }

  // Kapacit�sok keres�se:
  void kapacitasKereses() {
    int kap;
    while ((kap=Console.readInt("Keresend� kapacit�s: "))!=0) {
      int index = kontener.indexOf(kap);
      if (index >= 0)
        System.out.println("Indexe: "+index);
      else
        System.out.println("Nincs ilyen hord�");
    }
  }

  public static void main(String[] args) {
    new HordoKereses();
  }
}
