/*
 * Mintaprogramok/20. fejezet
 * VectorMinta.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

public class VectorMinta {
  // Vektor listázása:
  static void lista(String info,Vector v) {
    System.out.println("\n"+info);
    System.out.println("meret: "+v.size());
    for (int i=0; i<v.size(); i++)
      System.out.println(i+". "+v.get(i));
  }

  public static void main(String[] args) {
    Vector v = new Vector();
    v.add(new String("Marci"));
    v.add(new String("Dani"));
    v.add(new String("Peti"));
    v.add(new String("Rudi"));
    lista("4 elemu vektor",v); // Marci Dani Peti Rudi

    if (v.contains("Peti")) {
      System.out.print("Peti benne van, ");
      System.out.println("indexe:"+v.indexOf("Peti"));
    }

    v.remove(2);
    lista("2. torolve",v);     // Marci Dani Rudi

    v.remove("Rudi"); // A két Rudi egyenlo (equals==true)
    lista("Rudi torolve",v);   // Marci Dani

    v.add(0,new String("Cili"));
    v.add(1,new String("Marci"));
    lista("Beszuras elore",v); // Cili Marci Marci Dani

    int n=v.size();
    System.out.println("\nUtolso ket objektum kiirasa");
    System.out.println(v.get(n-2)+" "+v.get(n-1)); // Marci Dani

    v.set(1,new String("Toni")); // Az eddigi 1. objektum elvész
    lista("1. elem atirasa Toni-ra",v); // Cili Toni Marci Dani

    Vector vv = new Vector(v);
    lista("vv vektor:",vv);    // Cili Toni Marci Dani

    vv.clear();
    lista("A vv vektor ures lett",vv);  // (üres)

    vv.add(new String("Marci"));
    vv.add(new String("Lili"));
    vv.addAll(v);
    lista("Marci, Lili es a teljes v hozzaadasa vv-hez",vv);
                               // Marci Lili Cili Toni Marci Dani

    lista("v vektor:",v);      // Cili Toni Marci Dani
    if (vv.containsAll(v))     // true
      System.out.println("\nvv tartalmazza v elemeit");
    else
      System.out.println("\nvv nem taralmazza v elemeit");

    vv.retainAll(v);
    lista("vv es v kozos resze:",vv); // Marci Cili Toni Marci Dani
  }
} // VectorMinta

