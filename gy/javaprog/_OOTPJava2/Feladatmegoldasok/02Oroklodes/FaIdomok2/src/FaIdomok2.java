/*
 * Feladatmegoldások/2. fejezet
 * Projekt: FaIdomok2
 * FaIdomok2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Készítünk egy általános osszSuly(String className) metódust,
 * mely megadja akármelyik idomfajta össz súlyát.
 */

import java.util.*;
import extra.Format;
import idomok.*;

public class FaIdomok2 {
  private Vector idomok = new Vector();

  public FaIdomok2() {
    idomok.add(new Gomb(3));
    idomok.add(new Hasab(2,4,5));
    idomok.add(new Henger(5,3));
    idomok.add(new Gomb(5));
    idomok.add(new Hasab(3,5,2));
    idomok.add(new Hasab(4,5,4));
    idomok.add(new Henger(4,7));
  }

  public double osszSuly() {
    double osszes=0;
    Idom idom;
    for (int i=0; i<idomok.size(); i++) {
      idom = (Idom)idomok.get(i);
      osszes += idom.suly();
    }
    return osszes;
  }

  public double osszSuly(String className) {
    double osszes=0;
    Idom idom;
    for (int i=0; i<idomok.size(); i++) {
      idom = (Idom)idomok.get(i);
      if (idom.getClass().getName().equals(className))
        osszes += idom.suly();
    }
    return osszes;
  }

  public double osszTerfogat(String className) {
    double osszes=0;
    Idom idom;
    for (int i=0; i<idomok.size(); i++) {
      idom = (Idom)idomok.get(i);
      if (idom.getClass().getName().equals(className))
        osszes += idom.terfogat();
    }
    return osszes;
  }

  public void run() {
    if (idomok.isEmpty()) {
      System.out.println("Nincs idom!");
      return;
    }
    System.out.println("Idomok:");
    for (int i=0; i<idomok.size(); i++)
      System.out.println(idomok.get(i));
    System.out.println();

    System.out.println("Össz súly: "+
      Format.right(osszSuly(),0,1));
    System.out.println("Össz gömbsúly: "+
      Format.right(osszSuly("idomok.Gomb"),0,1));
    System.out.println("Legkisebb térfogatú idom: "+
      Collections.min(idomok));
    System.out.println("Legnagyobb térfogatú idom: "+
      Collections.max(idomok));

    System.out.println("Össz hengersúly: "+
      Format.right(osszSuly("idomok.Henger"),0,1));
    System.out.println("Össz hengertérfogat: "+
      Format.right(osszTerfogat("idomok.Henger"),0,1));

     // A hengereket áttesszük egy új vektorba, és abból választjuk ki a minimálisat:
    Vector hengerek = new Vector();
    for (int i = 0; i < idomok.size(); i++) {
      if (idomok.get(i) instanceof Henger)
        hengerek.add(idomok.get(i));
    }
    if (!hengerek.isEmpty())
      System.out.println("Legkisebb térfogatú henger: "+
                         Collections.min(hengerek));
  }

  public static void main(String[] args) {
    new FaIdomok2().run();
  }
}
