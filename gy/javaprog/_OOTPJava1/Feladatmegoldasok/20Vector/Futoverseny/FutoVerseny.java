/*
 * Feladatmegold�sok/20. fejezet
 * FutoVerseny.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;
import java.util.Vector;
import java.util.Collections;

class Versenyzo implements Comparable{
  private String nev;
  private int tav, ido;

  public Versenyzo(String nev, int tav){
    this.nev = nev;
    this.tav = tav;
    ido = 0;
  }

  public String getNev(){
    return nev;
  }

  public int getTav(){
    return tav;
  }

  public int getIdo(){
    return ido;
  }

  public void setIdo(int ido){
    if (ido>0)
      this.ido = ido;
  }

  public boolean equals(Object obj){
    Versenyzo versenyzo = (Versenyzo) obj;
    return (nev.equals(versenyzo.getNev())) && (tav==versenyzo.tav);
  }

  public int compareTo(Object obj){
    return ((Versenyzo)obj).ido - ido;
  }

  public String toString() {
    return "N�v:"+Format.left(nev,20)+"T�v:"+Format.left(tav,10)+"Id�:"+Format.left(ido,10);
  }
}

public class FutoVerseny {
  private Vector versenyzok = new Vector();

  int tavBeker() {
    int[] tavok={100,200,400,800};
    for (int i=0; i<tavok.length; i++)
      System.out.println(i+1+". "+tavok[i]+"m");
    int valasz;
    do
      valasz = Console.readInt("T�v sorsz�ma: ");
    while (valasz<1 || valasz>tavok.length);
    return tavok[valasz-1];
  }

  void felvitel(){
    String nev;
    Versenyzo versenyzo;
    System.out.println("\nVersenyz�k nevez�se:");
    while (!(nev = Console.readLine("N�v: ")).equals("")) {
      versenyzo = new Versenyzo(nev,tavBeker());
      if (versenyzok.contains(versenyzo)) {
        System.out.println("Ezen a t�von m�r van ilyen nev� indul�!");
        continue;
      }
      versenyzok.add(versenyzo);
    }
  }

  void eredmenyek(){
    String nev;
    Versenyzo versenyzo;
    System.out.println("\nEredm�nyek megad�sa:");
    while (!(nev = Console.readLine("N�v: ")).equals("")) {
      versenyzo = new Versenyzo(nev,tavBeker());
      int poz = versenyzok.indexOf(versenyzo);
      if (poz==-1) {
        System.out.println("Ezen a t�von nincs ilyen nev� indul�!");
        continue;
      }
      versenyzo = (Versenyzo)versenyzok.get(poz);
      versenyzo.setIdo(Console.readInt("Id�: "));
    }
  }

  Vector dobogosok(int tav, int db) {
    Vector dobogosok = new Vector();
    Vector v = new Vector(versenyzok);
    int i=0;
    while (i<v.size()) {
      Versenyzo versenyzo = (Versenyzo)v.get(i);
      if (versenyzo.getTav()!=tav || versenyzo.getIdo()==0)
        v.remove(i);
      else
        i++;
    }
    for (int j=0; j<db; j++) {
      if (v.size()==0)
        break;
      Object legjobb = Collections.max(v);
      dobogosok.add(legjobb);
      v.remove(legjobb);
    }
    return dobogosok;
  }

  void lista(Vector vektor, String info) {
    System.out.println(info);
    for (int i=0; i<vektor.size();i++)
      System.out.println(vektor.get(i));
  }

  public void menu() {
    char valasz;
    do {
      System.out.println("\nN: Nevez�sek felvitele");
      System.out.println("E: Eredm�nyek megad�sa");
      System.out.println("L: Versenyz�k list�ja nevez�sek sorrendj�ben");
      System.out.println("D: Dobog�s versenyz�k t�vonk�nt");
      System.out.println("V: V�ge");
      valasz = Character.toUpperCase(Console.readChar());
      switch (valasz) {
        case 'N': {
          felvitel();
          break;
        }
        case 'E': {
          eredmenyek();
          break;
        }
        case 'L': {
          lista(versenyzok,"\nVersenyz�k list�ja nevez�s sorrendj�ben:");
          break;
        }
        case 'D': {
          lista(dobogosok(100,3),"\nDobog�s versenyz�k 100m-en:");
          lista(dobogosok(200,3),"\nDobog�s versenyz�k 200m-en:");
          lista(dobogosok(400,3),"\nDobog�s versenyz�k 400m-en:");
          lista(dobogosok(800,3),"\nDobog�s versenyz�k 800m-en:");
          break;
        }
      }
    } while (valasz!='V');
  }

  public static void main(String[] args) {
    FutoVerseny verseny = new FutoVerseny();
    verseny.menu();
  }
}
