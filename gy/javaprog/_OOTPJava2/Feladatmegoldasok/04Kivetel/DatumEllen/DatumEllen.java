/*
 * Feladatmegoldások/4. fejezet
 * DatumEllen.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;

class Datum {
  private int ev, ho, nap;

  private Datum(int ev, int ho, int nap) {
    this.ev = ev;
    this.ho = ho;
    this.nap = nap;

  }

  public String toString() {
    return ev+":"+ho+":"+nap;
  }

  static Datum readDatum() {
    int ev=0, ho=0, nap=0;
    while (true) {
      try {
        ev = Console.readInt("Ev: ");
        if (ev==0)
          return null;
        if (ev<1900 || ev>2010)
          throw new Exception("Ev=1900..2010!");
        break;
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    while (true) {
      try {
        ho = Console.readInt("Ho: ");
        if (ho==0)
          return null;
        if (ho<1 || ho>12)
          throw new Exception("Honap=1..12!");
        break;
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    while (true) {
      try {
        nap = Console.readInt("Nap: ");
        if (nap==0)
          return null;
        if (nap<1)
          throw new Exception("Nap>=1!");
        if (ho==1 || ho==3 || ho==5 || ho==7 || ho==8 || ho==10 || ho==12) {
          if (nap>31)
            throw new Exception("31 napos honap!");
        }
        else if (ho==4 || ho==6 || ho==9 || ho==11) {
          if (nap>30)
            throw new Exception("30 napos honap!");
        }
        else {  // február
          boolean szokoev = (ev%4==0 && (ev%100!=0 || ev%400==0));
          if (szokoev) {
            if (nap>29)
              throw new Exception("29 napos honap!");
          }
          else
            if (nap>28)
              throw new Exception("28 napos honap!");
        }
        break;
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return new Datum(ev,ho,nap);
  }
}

public class DatumEllen {
  public static void main (String[] args) {
    Datum datum = Datum.readDatum();
    System.out.println("\n"+datum);
  }
}
