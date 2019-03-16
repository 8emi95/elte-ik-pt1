/*
 * Mintaprogramok/19. fejezet
 * HordoKereses.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class Hordo {
  private int atmero, magassag;   // cm-ben

  public Hordo(int atmero, int magassag) {
    this.atmero = atmero;
    this.magassag = magassag;
  }

  public int kapacitas() {     // literben
    return (int)(Math.round(Math.pow(atmero/2.0,2)*
      Math.PI*magassag/1000));
  }

  public boolean equals(Hordo hordo) {
    return (hordo.atmero == atmero) &&
      (hordo.magassag == magassag);
  }

  public int compareTo(Hordo hordo) {
    return kapacitas()-hordo.kapacitas();
  }

  public String toString() {
    return "\n�tmer�:"+Format.right(atmero,6)+
      " Magass�g:"+Format.right(magassag,6)+
      " Kapacit�s:"+Format.right(kapacitas(),8);
  }
}

class Kontener {
  private Hordo[] hordok = new Hordo[1000];
  private int size=0;

  public Kontener() {
    int atmero;
    while (size<hordok.length && (atmero=Console.readInt("\n�tmer�: "))!= 0) {
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
    int atmero;
    Hordo hasonlitoHordo;
    atmero = Console.readInt("\n�tmer�: ");
    while (atmero!=0) {
      hasonlitoHordo = new Hordo(atmero,Console.readInt("Magass�g: "));
      int index = kontener.indexOf(hasonlitoHordo);
      if (index >= 0)
        System.out.println("Indexe: "+index);
      else
        System.out.println("Nincs ilyen elem");
      atmero = Console.readInt("\n�tmer�: ");
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
