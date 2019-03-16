/*
 * Feladatmegoldások/20. fejezet
 * TorpeProgram3.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
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

  // A vektorban való keresés név szerint történik:
  public boolean equals(Object obj) {
    return nev.equals(((Ember)obj).getNev());
  }

  // A rendezés magasság szerint történik.
  // A magasságok hasonlításának eredménye egy pozitív, nulla vagy negatív szám:
  public int compareTo(Object obj) {
    return magassag - ((Ember)obj).getMagassag();
  }

  public String toString() {
    return Format.left(nev,10) + Format.right(magassag,3);
  }
}

public class TorpeProgram3 {
  private Vector torpek = new Vector();

  // A torpék bevitele:
  void felvitel() {
    Ember torpe;
    String nev = Console.readLine("\nTörpe neve: ");
    while (!nev.equals("")) {
      if (torpek.contains(torpe = new Ember(nev)))
        System.out.println("Van már ilyen törpe!");
      else {
        torpe.setMagassag(Console.readInt("magassága : "));
        torpek.add(torpe);
      }
      nev = Console.readLine("Törpe neve: ");
    }
  }

  public void torles() {
    Ember torlendo = new Ember(Console.readLine("Törlendõ törpe: "));
    int index = torpek.indexOf(torlendo);
    if (index >= 0) {
      System.out.println(torpek.get(index));
      char valasz = Character.toUpperCase(Console.readChar("Biztosan törölni akarja? (I/N)"));
      if (valasz == 'I')
        torpek.remove(index);
    }
    else
      System.out.println("Nincs ilyen nevû törpe!");
  }

  public void magassagAllitas() {
    Ember torpe = new Ember(Console.readLine("Törpe neve: "));
    int index = torpek.indexOf(torpe);
    if (index >= 0) {
      torpe = (Ember)(torpek.get(index));
      System.out.println(torpe);
      torpe.setMagassag(Console.readInt("Új magasság: "));
    }
    else
      System.out.println("Nincs ilyen nevû törpe!");
  }

  public void listaNovekvo() {
    // A torpek rendezettsége nem változik.
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

  // torpek listázása a felvitel sorrendjében:
  public void listaEredeti() {
    System.out.println("\nTörpék listája index szerint:");
    lista(torpek);
  }

  public void leg() {
    System.out.println("A legalacsonyabb törpe: "+Collections.min(torpek));
    System.out.println("A legmagasabb törpe   : "+Collections.max(torpek));
  }

  private boolean benne(char kar,String s) {
    kar = Character.toUpperCase(kar);
    return (s.indexOf(kar)>=0);
  }

  void menu() {
    char valasz;
    do {
      System.out.print("a:Felvitel - b:Törles - c:MagasságÁllítás - d:ListaNövekvõ - "+
        "e:ListaCsökkenõ - f:ListaEredeti - g:Leg - v:Vége...?");
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
