/*
 * Feladatmegold�sok/20. fejezet
 * TorpeProgram3.java
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
  public void setMagassag(int mag) { magassag = mag; }

  // A vektorban val� keres�s n�v szerint t�rt�nik:
  public boolean equals(Object obj) {
    return nev.equals(((Ember)obj).getNev());
  }

  // A rendez�s magass�g szerint t�rt�nik.
  // A magass�gok hasonl�t�s�nak eredm�nye egy pozit�v, nulla vagy negat�v sz�m:
  public int compareTo(Object obj) {
    return magassag - ((Ember)obj).getMagassag();
  }

  public String toString() {
    return Format.left(nev,10) + Format.right(magassag,3);
  }
}

public class TorpeProgram3 {
  private Vector torpek = new Vector();

  // A torp�k bevitele:
  void felvitel() {
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

  public void torles() {
    Ember torlendo = new Ember(Console.readLine("T�rlend� t�rpe: "));
    int index = torpek.indexOf(torlendo);
    if (index >= 0) {
      System.out.println(torpek.get(index));
      char valasz = Character.toUpperCase(Console.readChar("Biztosan t�r�lni akarja? (I/N)"));
      if (valasz == 'I')
        torpek.remove(index);
    }
    else
      System.out.println("Nincs ilyen nev� t�rpe!");
  }

  public void magassagAllitas() {
    Ember torpe = new Ember(Console.readLine("T�rpe neve: "));
    int index = torpek.indexOf(torpe);
    if (index >= 0) {
      torpe = (Ember)(torpek.get(index));
      System.out.println(torpe);
      torpe.setMagassag(Console.readInt("�j magass�g: "));
    }
    else
      System.out.println("Nincs ilyen nev� t�rpe!");
  }

  public void listaNovekvo() {
    // A torpek rendezetts�ge nem v�ltozik.
    Vector torpek = new Vector(this.torpek);
    Collections.sort(torpek);
    lista(torpek);
  }

  public void listaCsokkeno() {
    Vector torpek = new Vector(this.torpek);
    Collections.sort(torpek);
    Collections.reverse(torpek);
    lista(torpek);
  }

  public void lista(Vector emberek) {
    for (int i=0; i<emberek.size(); i++)
      System.out.println(emberek.get(i));
  }

  // torpek list�z�sa a felvitel sorrendj�ben:
  public void listaEredeti() {
    System.out.println("\nT�rp�k list�ja index szerint:");
    lista(torpek);
  }

  public void leg() {
    System.out.println("A legalacsonyabb t�rpe: "+Collections.min(torpek));
    System.out.println("A legmagasabb t�rpe   : "+Collections.max(torpek));
  }

  private boolean benne(char kar,String s) {
    kar = Character.toUpperCase(kar);
    return (s.indexOf(kar)>=0);
  }

  void menu() {
    char valasz;
    do {
      System.out.print("a:Felvitel - b:T�rles - c:Magass�g�ll�t�s - d:ListaN�vekv� - "+
        "e:ListaCs�kken� - f:ListaEredeti - g:Leg - v:V�ge...?");
      do
        valasz = Character.toUpperCase(Console.readChar());
      while (!benne(valasz,"ABCDEFGV"));
      switch (valasz) {
        case 'A':
          felvitel();
          break;
        case 'B':
          torles();
          break;
        case 'C':
          magassagAllitas();
          break;
        case 'D':
          listaNovekvo();
          break;
        case 'E':
          listaCsokkeno();
          break;
        case 'F':
          listaEredeti();
          break;
        case 'G':
          leg();
          break;
      }
    } while (valasz != 'V');
  }

  public static void main(String[] args) {
    TorpeProgram3 tp = new TorpeProgram3();
    tp.menu();
  }
}
