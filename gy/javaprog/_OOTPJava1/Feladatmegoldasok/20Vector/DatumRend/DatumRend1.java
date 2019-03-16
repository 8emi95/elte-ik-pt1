/*
 * Feladatmegold�sok/20. fejezet
 * DatumRend1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

class Datum implements Comparable {
  private int ev, ho, nap;

  public Datum(int iEv, int iHo, int iNap) {
    ev = iEv;
    ho = iHo;
    nap = iNap;
  }

  public int getEv() { return ev; }
  public int getHo() { return ho; }
  public int getNap() { return nap; }

  public boolean szokoEv() {
    return ev%4==0 && (ev%100!=0 || ev%400==0);
  }

  // A feladatban nincs r� sz�ks�g, de aj�nlatos megadni:
  public boolean equals(Object o) {
    Datum d= (Datum)o;
    return ev==d.ev && ho==d.ho && nap==d.nap;
  }

  // A rendez�shez kell:
  public int compareTo(Object o) {
    Datum d=(Datum)o;
    if (ev<d.getEv()) return -1;
    if (ev>d.getEv()) return 1;

    if (ho<d.getHo()) return -1;
    if (ho>d.getHo()) return 1;

    if (nap<d.getNap()) return -1;
    if (nap>d.getNap()) return 1;
    return 0;
  }

  public String toString() {
    return Format.right(ev,4)+"."+Format.right("0"+ho,2)+"."+
      Format.right("0"+nap,2)+".";
  }
}

public class DatumRend1 {
  private Vector datumok = new Vector();

  public void bevitel() {
    int ev, ho, nap;
    ev = Console.readInt("\n�v: ");
    while (ev != 0) {
      datumok.add(new Datum(ev,Console.readInt("H�: "),
        Console.readInt("Nap: ")));
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
    new DatumRend1().run();
  }
}
