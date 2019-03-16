/*
 * Feladatmegoldások/20. fejezet
 * SzamSorozat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;
import java.util.*;

public class SzamSorozat {
  Vector szamok = new Vector();

  void beker() {
    int szam;
    while ((szam = Console.readInt("Szám: ")) != 0)
      szamok.add(new Integer(szam));
  }

  void kiirElore() {
    for (int i=0; i<szamok.size(); i++)
      System.out.print(szamok.get(i)+" ");
    System.out.println();
  }

  void kiirHatra() {
    for (int i=szamok.size()-1; i>=0; i--)
      System.out.print(szamok.get(i)+" ");
    System.out.println();
  }

  void negativokNullara() {
    for (int i=0; i<szamok.size(); i++)
      if (((Integer)szamok.get(i)).intValue()<0)
        szamok.set(i,new Integer(0));
  }

  double atlag() {
    if (szamok.size()==0)
      return 0;
    int osszeg=0;
    for (int i=0; i<szamok.size(); i++)
      osszeg += ((Integer)szamok.get(i)).intValue();
    return (double)osszeg/szamok.size();
  }

  int hanySzam(int szam) {
    int db=0;
    Integer hasSzam=new Integer(szam);
    for (int i=0; i<szamok.size(); i++)
      if (hasSzam.equals(szamok.get(i)))
        db++;
    return db;
  }

  void osszesTorol(int szam) {
    Integer szamObj = new Integer(szam);
    while (szamok.contains(szamObj))
      szamok.remove(szamObj);
  }

  void tobbiTorol(int szam) {
    Integer szamObj = new Integer(szam);
    int poz = szamok.indexOf(szamObj);
    if (poz==-1)
      return;
    while ((poz=szamok.indexOf(szamObj,poz+1))>=0)
      szamok.remove(poz);
  }

  void run() {
    beker();
    kiirElore();                                         //a
    kiirHatra();                                         //b
    negativokNullara(); kiirElore();                     //c
    System.out.println("Átlag= "+atlag());               //d
    System.out.println("A 3-masok száma: "+hanySzam(3)); //e
    osszesTorol(3); kiirElore();                         //f
    tobbiTorol(5); kiirElore();                          //g
    //h:
    System.out.println("Legkisebb szám= "+Collections.min(szamok));
    System.out.println("Legnagyobb szám= "+Collections.max(szamok));

    Collections.sort(szamok); kiirElore();               //i
    Collections.reverse(szamok); kiirElore();            //j
    Collections.shuffle(szamok); kiirElore();            //k
    Collections.sort(szamok); kiirElore();               //l
    // m:
    int index = Collections.binarySearch(szamok,new Integer(Console.readInt("Keresendõ: ")));
    System.out.println("Indexe= "+index);
  }

  public static void main(String[] args) {
    SzamSorozat szamSorozat = new SzamSorozat();
    szamSorozat.run();
  }
}
