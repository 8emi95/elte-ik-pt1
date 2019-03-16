/*
 * Feladatmegold�sok/20. fejezet
 * DatumRend2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 *
 * D�tumellen�rz�s. A Datum oszt�lynak van egy statikus newDatum met�dusa,
 * amely csak akkor hoz l�tre Datun objektumot, ha helyes a d�tum.
 * M�s m�dszer a d�tum hasonl�t�s�ra.
 */

import extra.*;
import java.util.*;

class Datum implements Comparable {
  private int ev, ho, nap;

  public static Datum newDatum(int ev, int ho, int nap) {
    if (ho<1 || ho>12 || nap<1 || nap>31)
      return null;
    if ((ho==4 || ho==6 || ho==9 || ho==11) && nap>30)
      return null;
    if (ho==2 && !szokoEv(ev) && nap>28)
      return null;
    if (ho==2 && szokoEv(ev) && nap>29)
      return null;
    return new Datum(ev,ho,nap);
  }

  /* A konstruktor priv�t, mert csak ellen�rz�s ut�n
   * lehet l�trehozni az objektumot newDatum-mal:
   */
  private Datum(int ev, int ho, int nap) {
    this.ev = ev;
    this.ho = ho;
    this.nap = nap;
  }

  public int getEv() { return ev; }
  public int getHo() { return ho; }
  public int getNap() { return nap; }

  public static boolean szokoEv(int ev) {
    return ev%4==0 && (ev%100!=0 || ev%400==0);
  }

  private int toNumber() {
    return ev*10000+ho*100+nap;
  }

  // A feladatban nincs r� sz�ks�g, de aj�nlatos megadni:
  public boolean equals(Object obj) {
    return toNumber() == ((Datum)obj).toNumber();
  }

  // A rendez�shez kell:
  public int compareTo(Object obj) {
    return toNumber()-((Datum)obj).toNumber();
  }

  public String toString() {
    return Format.right(ev,4)+"."+Format.right("0"+ho,2)+"."+
      Format.right("0"+nap,2)+".";
  }
}

public class DatumRend2 {
  private Vector datumok = new Vector();

  public void bevitel() {
    int ev, ho, nap;
    Datum datum;
    ev = Console.readInt("\n�v: ");
    while (ev != 0) {
      datum = Datum.newDatum(ev,Console.readInt("H�: "),
        Console.readInt("Nap: "));
      if (datum != null)
        datumok.add(datum);
      else
        System.out.println("Nem j� d�tum!");
      ev = Console.readInt("\n�v: ");
    }
  }

  public void lista() {
    for (int i=0; i<datumok.size(); i++)
      System.out.println(datumok.get(i));
  }

  public void run() {
    bevitel();
    System.out.println("\nD�tumok list�ja a felvitel sorrendj�ben:");
    lista();
    System.out.println("\nD�tumok list�ja rendezetten:");
    Collections.sort(datumok);
    lista();
  }

  public static void main (String args[]) {
    new DatumRend2().run();
  }
}
