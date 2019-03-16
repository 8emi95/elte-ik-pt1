/*
 * Mintaprogramok/20. fejezet
 * NobelDijasok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;
import java.util.*;

class NobelDijas implements Comparable {
  private String nev;
  private String orszag;
  private String szakterulet;
  private int evszam;

  public NobelDijas(String iNev, String iOrszag, String iSzakterulet, int iEvszam){
    nev = iNev;
    orszag = iOrszag;
    szakterulet = iSzakterulet;
    evszam = iEvszam;
  }

  public String getSzakterulet(){
    return szakterulet;
  }

  public int getEvszam(){
    return evszam;
  }

  public boolean equals(Object obj){
    NobelDijas dijas = (NobelDijas) obj;
    return (evszam==dijas.evszam) && (szakterulet.equals(dijas.getSzakterulet()));
  }

  public int compareTo(Object obj){
    return evszam - ((NobelDijas)obj).evszam;
  }

  public String toString() {
    return Format.left(nev,20)+Format.left(orszag,20)+
      Format.left(szakterulet,20)+Format.left(evszam,10);
  }
}

public class NobelDijasok {
  private Vector szakteruletek = new Vector();
  private Vector dijasok = new Vector();

  // Szakteruletek felvitele végjelig. Két egyformát nem engedünk felvinni:
  void felvitelSzakteruletek(){
    String szakterulet;
    while (true) {
      szakterulet = Console.readLine("Szakterulet: ");
      if (szakterulet.equals(""))
        return;
      if (szakteruletek.indexOf(szakterulet)>=0)
        System.out.println("Mar van ilyen");
      else
        szakteruletek.add(szakterulet);
    }
  }

  void felvitelDijasok(){
    String nev, orszag, szakterulet;
    int evszam;
    NobelDijas dijas;

    System.out.println("\n*** Nobel dijasok felvitele ***");
    while (true) {
      szakterulet = Console.readLine("\nSzakterulet: ");
      if (szakterulet.equals(""))
        break;
      if (szakteruletek.indexOf(szakterulet)<0) {
        System.out.println("Nincs ilyen szakterulet");
        continue;
      }
        
      evszam = Console.readInt("Evszam: ");
      dijas = new NobelDijas("","",szakterulet,evszam);
      if (dijasok.contains(dijas)) {
        System.out.println("Ezen a szakteruleten ebben az evben mar van Nobel dijas!");
        continue;
      }
      nev = Console.readLine("Nev: ");
      orszag = Console.readLine("Orszag: ");
      dijas = new NobelDijas(nev,orszag,szakterulet,evszam);
      dijasok.add(dijas);
    }
    Collections.sort(dijasok);
  }

  void listaDijasok() {
    System.out.println("\n*** Nobel dijasok ***");
    for (int i=0; i<dijasok.size();i++) {
      System.out.println((NobelDijas)dijasok.get(i));
    }
  }

  void listaSzakteruletSzerint(){
    NobelDijas dijas; 
    String szakterulet;
    szakterulet = Console.readLine("\nSzakterulet: ");
    System.out.println(Format.left("Nev",20)+Format.left("Orszag",20)+
      Format.left("Evszam",10));
    for (int i=0; i<dijasok.size(); i++){
      dijas = (NobelDijas)dijasok.get(i);
      if (szakterulet.equals(dijas.getSzakterulet()))
        System.out.println(dijas);
    }
  }

  void evszamGyujtes() {
    int[] gyujto = new int[2010];
    for (int i=0; i<dijasok.size(); i++){
      int ev = ((NobelDijas)dijasok.get(i)).getEvszam();
      gyujto[ev]++;
    }
    System.out.println("\n*** Nobel dijasok szama ev szerint ***");
    for (int ev=0; ev<gyujto.length; ev++) {
      if (gyujto[ev]!=0)
        System.out.println(Format.right(ev,4)+":  "+Format.right(gyujto[ev],6));
    }
  }

  public static void main(String[] args) {
    NobelDijasok nd = new NobelDijasok();
    nd.felvitelSzakteruletek();
    nd.felvitelDijasok();
    nd.listaDijasok();
    nd.listaSzakteruletSzerint();
    nd.evszamGyujtes();
  }
}
