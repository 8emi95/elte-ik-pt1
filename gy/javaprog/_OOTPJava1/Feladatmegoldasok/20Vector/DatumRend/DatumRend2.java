/*
 * Feladatmegoldások/20. fejezet
 * DatumRend2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 *
 * Dátumellenõrzés. A Datum osztálynak van egy statikus newDatum metódusa,
 * amely csak akkor hoz létre Datun objektumot, ha helyes a dátum.
 * Más módszer a dátum hasonlítására.
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

  /* A konstruktor privát, mert csak ellenõrzés után
   * lehet létrehozni az objektumot newDatum-mal:
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

  // A feladatban nincs rá szükség, de ajánlatos megadni:
  public boolean equals(Object obj) {
    return toNumber() == ((Datum)obj).toNumber();
  }

  // A rendezéshez kell:
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
    ev = Console.readInt("\nÉv: ");
    while (ev != 0) {
      datum = Datum.newDatum(ev,Console.readInt("Hó: "),
        Console.readInt("Nap: "));
      if (datum != null)
        datumok.add(datum);
      else
        System.out.println("Nem jó dátum!");
      ev = Console.readInt("\nÉv: ");
    }
  }

  public void lista() {
    for (int i=0; i<datumok.size(); i++)
      System.out.println(datumok.get(i));
  }

  public void run() {
    bevitel();
    System.out.println("\nDátumok listája a felvitel sorrendjében:");
    lista();
    System.out.println("\nDátumok listája rendezetten:");
    Collections.sort(datumok);
    lista();
  }

  public static void main (String args[]) {
    new DatumRend2().run();
  }
}
