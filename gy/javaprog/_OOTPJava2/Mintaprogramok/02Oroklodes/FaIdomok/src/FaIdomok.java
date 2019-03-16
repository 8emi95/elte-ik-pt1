/*
 * Mintaprogramok/2. fejezet
 * Projekt: FaIdomok
 * FaIdomok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;
import extra.Format;
import idomok.*;

public class FaIdomok {
  private Vector idomok = new Vector();

  public FaIdomok() {
    idomok.add(new Gomb(3));
    idomok.add(new Hasab(2,4,5));
    idomok.add(new Gomb(5));
    idomok.add(new Hasab(3,5,2));
    idomok.add(new Hasab(4,5,4));
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

  public double osszGombSuly() {
    double osszes=0;
    Idom idom;
    for (int i=0; i<idomok.size(); i++) {
      idom = (Idom)idomok.get(i);
      if (idom instanceof Gomb)
        osszes += idom.suly();
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

    System.out.println("�sszs�ly: "+
      Format.right(osszSuly(),0,1));
    System.out.println("�ssz g�mbs�ly: "+
      Format.right(osszGombSuly(),0,1));
    System.out.println("Legkisebb t�rfogat� idom: "+
      Collections.min(idomok));
    System.out.println("Legnagyobb t�rfogat� idom: "+
      Collections.max(idomok));
  }

  public static void main(String[] args) {
    new FaIdomok().run();
  }
}
