/*
 * Mintaprogramok/20. fejezet
 * TorpeProgram.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

class Ember {
  private String nev;
  private int magassag;

  public Ember(String nev, int magassag) {
    this.nev = nev;
    this.magassag = magassag;
  }

  public Ember(String nev) {
    this(nev,0);
  }

  public String getNev() { return nev; }
  public int getMagassag() { return magassag; }
  public void setMagassag(int mag) { 
    if (mag>0)
      magassag = mag;
  }

  public boolean equals(Object obj) {
    return nev.equals(((Ember)obj).getNev());
  }

  public String toString() {
    return Format.left(nev,10) + Format.right(magassag,3);
  }
}

public class TorpeProgram {
  private Vector torpek = new Vector();

  // A torpék bevitele:
  void bevitel() {
    Ember torpe;
    String nev = Console.readLine("\nTorpe neve: ");
    while (!nev.equals("")) {
      if (torpek.contains(torpe = new Ember(nev)))
        System.out.println("Van mar ilyen torpe!");
      else {
        torpe.setMagassag(Console.readInt("magassaga : "));
        torpek.add(torpe);
      }
      nev = Console.readLine("Torpe neve: ");
    }
  }

  // Egyszerû lista, beépített módon:
  void lista1() {
    System.out.println("\nBeepitett lista:");
    System.out.println(torpek);
  }

  // torpek listázása index szerint, toString()-gel:
  void lista2() {
    System.out.println("\nLista index szerint:");
    for (int i=0; i<torpek.size(); i++) {
      System.out.println(torpek.get(i));
    }
  }

  // Listázás toString() nélkül:
  void lista3() {
    Ember e;
    System.out.println("\nEgyeni lista:");
    for (int i=0; i<torpek.size(); i++) {
      e = (Ember)(torpek.get(i));
      System.out.println("Nev: "+e.getNev()+"  Magassag: "+e.getMagassag());
    }
  }

  // Egy törpe megkeresése:
  void kereses() {
    System.out.println("\nKereses:");
    Ember keresettEmber = new Ember(
      Console.readLine("Torpe neve: "));
    int poz = torpek.indexOf(keresettEmber);
    if (poz >= 0)
      System.out.println("Van, magassaga:"+
        ((Ember)(torpek.get(poz))).getMagassag());
    else
      System.out.println("Nincs ilyen");
  }

  public static void main(String[] args) {
    TorpeProgram tp = new TorpeProgram();
    tp.bevitel();
    tp.lista1();
    tp.lista2();
    tp.lista3();
    tp.kereses();
  }
}
