/*
 * Feladatmegold�sok/2. fejezet
 * Projekt: FaIdomok2
 * FaIdomok2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * K�sz�t�nk egy �ltal�nos osszSuly(String className) met�dust,
 * mely megadja ak�rmelyik idomfajta �ssz s�ly�t.
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

    System.out.println("�ssz s�ly: "+
      Format.right(osszSuly(),0,1));
    System.out.println("�ssz g�mbs�ly: "+
      Format.right(osszSuly("idomok.Gomb"),0,1));
    System.out.println("Legkisebb t�rfogat� idom: "+
      Collections.min(idomok));
    System.out.println("Legnagyobb t�rfogat� idom: "+
      Collections.max(idomok));

    System.out.println("�ssz hengers�ly: "+
      Format.right(osszSuly("idomok.Henger"),0,1));
    System.out.println("�ssz hengert�rfogat: "+
      Format.right(osszTerfogat("idomok.Henger"),0,1));

     // A hengereket �ttessz�k egy �j vektorba, �s abb�l v�lasztjuk ki a minim�lisat:
    Vector hengerek = new Vector();
    for (int i = 0; i < idomok.size(); i++) {
      if (idomok.get(i) instanceof Henger)
        hengerek.add(idomok.get(i));
    }
    if (!hengerek.isEmpty())
      System.out.println("Legkisebb t�rfogat� henger: "+
                         Collections.min(hengerek));
  }

  public static void main(String[] args) {
    new FaIdomok2().run();
  }
}
