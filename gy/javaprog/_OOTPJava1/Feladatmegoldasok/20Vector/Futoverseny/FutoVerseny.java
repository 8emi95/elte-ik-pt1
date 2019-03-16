/*
 * Feladatmegoldások/20. fejezet
 * FutoVerseny.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
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
    return "Név:"+Format.left(nev,20)+"Táv:"+Format.left(tav,10)+"Idõ:"+Format.left(ido,10);
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
      valasz = Console.readInt("Táv sorszáma: ");
    while (valasz<1 || valasz>tavok.length);
    return tavok[valasz-1];
  }

  void felvitel(){
    String nev;
    Versenyzo versenyzo;
    System.out.println("\nVersenyzõk nevezése:");
    while (!(nev = Console.readLine("Név: ")).equals("")) {
      versenyzo = new Versenyzo(nev,tavBeker());
      if (versenyzok.contains(versenyzo)) {
        System.out.println("Ezen a távon már van ilyen nevû induló!");
        continue;
      }
      versenyzok.add(versenyzo);
    }
  }

  void eredmenyek(){
    String nev;
    Versenyzo versenyzo;
    System.out.println("\nEredmények megadása:");
    while (!(nev = Console.readLine("Név: ")).equals("")) {
      versenyzo = new Versenyzo(nev,tavBeker());
      int poz = versenyzok.indexOf(versenyzo);
      if (poz==-1) {
        System.out.println("Ezen a távon nincs ilyen nevû induló!");
        continue;
      }
      versenyzo = (Versenyzo)versenyzok.get(poz);
      versenyzo.setIdo(Console.readInt("Idõ: "));
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
      System.out.println("\nN: Nevezések felvitele");
      System.out.println("E: Eredmények megadása");
      System.out.println("L: Versenyzõk listája nevezések sorrendjében");
      System.out.println("D: Dobogós versenyzõk távonként");
      System.out.println("V: Vége");
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
          lista(versenyzok,"\nVersenyzõk listája nevezés sorrendjében:");
          break;
        }
        case 'D': {
          lista(dobogosok(100,3),"\nDobogós versenyzõk 100m-en:");
          lista(dobogosok(200,3),"\nDobogós versenyzõk 200m-en:");
          lista(dobogosok(400,3),"\nDobogós versenyzõk 400m-en:");
          lista(dobogosok(800,3),"\nDobogós versenyzõk 800m-en:");
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
