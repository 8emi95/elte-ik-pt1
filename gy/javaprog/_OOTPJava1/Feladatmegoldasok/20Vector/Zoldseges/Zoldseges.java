/*
 * FeladatMegoldások/20. fejezet
 * Zoldseges.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;
import java.util.*;

class Zoldseg implements Comparable {
  private String nev;
  private double egysegar, menny;
  private final double MIN_MENNY, MAX_MENNY;

  public Zoldseg(String nev, double egysegar, double menny, double minMenny, double maxMenny) {
    this.nev = nev;
    this.egysegar = egysegar;
    this.menny = menny;
    this.MIN_MENNY = minMenny;
    this.MAX_MENNY = maxMenny;
  }

  public Zoldseg(String nev, double egysegar, double menny) {
    this(nev,egysegar,menny,0,0);
  }

  public String getNev() {
    return nev;
  }

  public double getEgysegar() {
    return egysegar;
  }

  public void setEgysegar(double egysegar) {
    if (egysegar >= 0)
      this.egysegar = egysegar;
  }

  public double getMenny() {
    return menny;
  }

  public double getMinMenny() {
    return MIN_MENNY;
  }

  public double getMaxMenny() {
    return MAX_MENNY;
  }

  public double getAr() {
    return menny*egysegar;
  }

  public boolean van(double menny) {
    return menny>0 && menny<=this.menny;
  }

  public void hozzatesz(double menny) {
    if (menny>0)
      this.menny += menny;
  }

  public boolean elvesz(double menny) {
    if (van(menny)) {
      this.menny -= menny;
      return true;
    }
    return false;
  }

  public static boolean egyenloNev(String nev1, String nev2) {
    return nev1.trim().equalsIgnoreCase(nev2.trim());
  }

  public boolean equals(Object obj) {
    return egyenloNev(nev,((Zoldseg)obj).getNev());
  }

  public int compareTo(Object obj){
    double elt = getAr() - ((Zoldseg)obj).getAr();
    if (elt<0)
      return -1;
    if (elt>0)
      return 1;
    return (int)elt;
  }

  public String toString() {
    return Format.left(nev,20)+"\tEgysegar: "+egysegar+
      "\tMennyiseg: "+menny+" kg";
  }
}

public class Zoldseges {
  private Vector zoldsegek=new Vector();
  private Vector szamla;
  private Vector rendeles;
  private Vector statisztika=new Vector();

  private void felvitel() {
    String nev=Console.readLine("\nZoldseg neve: ");
    Zoldseg zoldseg = new Zoldseg(nev,0,0,0,0);
    if (zoldsegek.contains(zoldseg)) {
      System.out.println("Mar van ilyen nevu zoldseg!");
      return;
    }
    double egysegar=Console.readDouble("Egysegar: ");
    double menny=Console.readDouble("Mennyiseg: ");
    double minMenny;
    do
      minMenny=Console.readDouble("Minimalis mennyiseg: ");
    while (minMenny<=0);
    double maxMenny;
    do
      maxMenny=Console.readDouble("Maximalis mennyiseg: ");
    while (maxMenny<=minMenny);
    zoldsegek.add(new Zoldseg(nev,egysegar,menny,minMenny,maxMenny));
  }

  private void torles() {
    Zoldseg zoldseg = new Zoldseg(Console.readLine("\nZoldseg neve: "),0,0,0,0);
    int index = zoldsegek.indexOf(zoldseg);
    if (index >= 0) {
      System.out.println(zoldsegek.get(index));
      char valasz = Character.toUpperCase(Console.readChar("Biztosan torolni akarja ezt a zoldseget? (I/N)"));
      if (valasz == 'I')
        zoldsegek.remove(index);
    }
    else
      System.out.println("Nincs ilyen nevu zoldseg!");
  }

  private void egysegarModositas() {
    Zoldseg zoldseg = new Zoldseg(Console.readLine("\nZoldseg neve: "),0,0,0,0);
    int index = zoldsegek.indexOf(zoldseg);
    if (index >= 0) {
      zoldseg = (Zoldseg)zoldsegek.get(index);
      System.out.println(zoldseg);
      zoldseg.setEgysegar(Console.readDouble("Uj egysegar: "));
    }
    else
      System.out.println("Nincs ilyen nevu zoldseg!");
  }


  private void hozzaad(Vector vektor,Zoldseg zoldseg) {
    int index = vektor.indexOf(zoldseg);
    if (index >= 0) {
      Zoldseg modZoldseg = (Zoldseg)vektor.get(index);
      modZoldseg.hozzatesz(zoldseg.getMenny());
    }
    else
      vektor.add(zoldseg);
  }

  private void vasarlas(Zoldseg zoldseg) {
    System.out.println(zoldseg);
    if (zoldseg.getMenny()==0) {
      System.out.println(zoldseg.getNev()+"-bol a keszlet elfogyott!");
      return;
    }
    double menny;
    boolean van;
    do {
      menny = Console.readDouble("Vasarolando mennyiseg(kg): ");
      van = zoldseg.van(menny);
      if (!van)
        System.out.println(zoldseg.getNev()+"-bol nincs ekkora mennyiseg!");
    } while (!van);
    zoldseg.elvesz(menny);
    hozzaad(szamla,new Zoldseg(zoldseg.getNev(),zoldseg.getEgysegar(),menny));
    hozzaad(statisztika,new Zoldseg(zoldseg.getNev(),zoldseg.getEgysegar(),menny));
  }

  private void vasarlasok() {
    szamla=new Vector();
    int valasz;
    while (true) {
      lista(zoldsegek,"\nValaszthato zoldsegek:");
      System.out.println(" 0. Vasarlas vege");
      do
        valasz = Console.readInt("Zoldseg sorszama: ");
      while (valasz<0 || valasz>zoldsegek.size());
      if (valasz==0)
        break;
      vasarlas((Zoldseg)zoldsegek.get(valasz-1));
    }
    szamla();
  }

  private void szamla() {
    System.out.println("\nSzamla:");
    double osszesen=0;
    for (int i=0; i<szamla.size();i++) {
      Zoldseg zoldseg = (Zoldseg)szamla.get(i);
      double ar = zoldseg.getAr();
      System.out.println(Format.right(i+1,2)+". "+zoldseg+"\tAr: "+Format.right(ar,4,1));
      osszesen += ar;
    }
    System.out.println("Fizetendo osszeg: "+Format.right(osszesen,4,1));
  }

  private void utanrendeles() {
    rendeles=new Vector();
    for (int i=0; i<zoldsegek.size();i++) {
      Zoldseg zoldseg = (Zoldseg)zoldsegek.get(i);
      if (zoldseg.getMenny()<zoldseg.getMinMenny()) {
        double menny = zoldseg.getMaxMenny()-zoldseg.getMenny();
        hozzaad(rendeles,new Zoldseg(zoldseg.getNev(),zoldseg.getEgysegar(),menny));
        hozzaad(zoldsegek,new Zoldseg(zoldseg.getNev(),zoldseg.getEgysegar(),menny));
      }
    }
    lista(rendeles,"\nUtanrendeles:");
  }

  private void zaras() {
    if (statisztika.size()==0)
      System.out.println("Ma nem volt vasarlas!");
    else {
      lista(statisztika,"\nEladasok:");
      System.out.println("A kovetkezo zoldsegbol adtuk el a legtobbet:");
      System.out.println(Collections.max(statisztika));
    }
    System.out.println("A kovetkezo zoldsegekbol nem adtunk el semmit sem:");
    for (int i=0; i<zoldsegek.size();i++) {
      Zoldseg zoldseg = (Zoldseg)zoldsegek.get(i);
      if (!statisztika.contains(zoldseg))
        System.out.println(zoldseg.getNev());
    }
  }

  private void lista(Vector vektor, String info) {
    System.out.println(info);
    for (int i=0; i<vektor.size();i++)
      System.out.println(Format.right(i+1,2)+". "+vektor.get(i));
  }

  private boolean benne(char kar, String s) {
    kar = Character.toUpperCase(kar);
    return (s.indexOf(kar)>=0);
  }

  public void menu() {
    char valasz;
    do {
      System.out.println("\nU Uj zoldseg");
      System.out.println("T Zoldseg torlese");
      System.out.println("E Zoldseg egysegaranak modositasa");
      System.out.println("L Zoldsegek listaja");
      System.out.println("V Vasarlas");
      System.out.println("R UtanRendeles");
      System.out.println("Z Zaras");
      do
        valasz = Character.toUpperCase(Console.readChar());
      while (!benne(valasz,"UTELVRZ"));
      switch (valasz) {
        case 'U':
          felvitel();
          break;
        case 'T':
          torles();
          break;
        case 'E':
          egysegarModositas();
          break;
        case 'L':
          lista(zoldsegek,"Zoldsegek:");
          break;
        case 'V':
          vasarlasok();
          break;
        case 'R':
          utanrendeles();
          break;
        case 'Z':
          zaras();
          break;
      }
    } while (valasz != 'Z');
  }

  public static void main(String[] args) {
    new Zoldseges().menu();
  }
}
