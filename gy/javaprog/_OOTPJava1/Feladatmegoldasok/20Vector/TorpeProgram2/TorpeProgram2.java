/*
 * Feladatmegold�sok/20. fejezet
 * TorpeProgram2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

class Ember implements Comparable {
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
  public void setMagassag(int mag) { magassag = mag;
  }

  public boolean equals(Object obj) {
    return nev.equals(((Ember)obj).getNev());
  }

  public int compareTo(Object obj) {
    return nev.compareTo(((Ember)obj).getNev());
  }

  public String toString() {
    return Format.left(nev,10) + Format.right(magassag,3);
  }
}

public class TorpeProgram2 {
  private Vector torpek = new Vector();

  // A torp�k bevitele:
  void bevitel() {
    Ember torpe;
    String nev = Console.readLine("\nT�rpe neve: ");
    while (!nev.equals("")) {
      if (torpek.contains(torpe = new Ember(nev)))
        System.out.println("Van m�r ilyen t�rpe!");
      else {
        torpe.setMagassag(Console.readInt("magass�ga : "));
        torpek.add(torpe);
      }
      nev = Console.readLine("T�rpe neve: ");
    }
  }

  // torpek list�z�sa index szerint, toString()-gel:
  void lista() {
    System.out.println("\nT�rp�k list�ja:");
    for (int i=0; i<torpek.size(); i++) {
      System.out.println(torpek.get(i));
    }
  }

  void rendezes() {
    Collections.sort(torpek);
  }

  public static void main(String[] args) {
    TorpeProgram2 tp = new TorpeProgram2();
    tp.bevitel();
    tp.lista();
    tp.rendezes();
    tp.lista();
  }
}
