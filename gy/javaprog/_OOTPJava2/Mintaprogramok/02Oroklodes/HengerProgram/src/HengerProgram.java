/*
 * Mintaprogramok/2. fejezet
 * Projekt: HengerProgram
 * HengerProgram.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;
import java.util.Vector;

public class HengerProgram {                              //1
  private Vector hengerek = new Vector();                 //2

  public HengerProgram() {                                //3
    hengerek.add(new Henger(1,4));
    hengerek.add(new Rud(0.5,4,2));
    hengerek.add(new Rud(0.5,4));
    hengerek.add(new Cso(5,5,0.5));
    hengerek.add(new Cso(5,5,0.5,2));
  }

  public double atlagTerfogat() {                         //4
    Henger henger;
    double osszTerfogat = 0;
    for (int i=0; i<hengerek.size(); i++) {
      henger = (Henger)hengerek.get(i);
      osszTerfogat += henger.terfogat();
    }
    int meret = hengerek.size();
    return meret==0? 0 : osszTerfogat/meret;
  }

  public void lista(Vector vektor) {                      //5
    for (int i=0; i<vektor.size(); i++) {
      System.out.println(vektor.get(i));
    }
  }

  public void run() {                                     //6
    // Hengerek listázása:
    System.out.println("Hengerek száma: "+hengerek.size());
    lista(hengerek);

    // Átlagtérfogat számítása:
    System.out.println("\nÁtlagtérfogat: "+
      Format.right(atlagTerfogat(),0,2));

    // Csövek listázása, összsúlyuk számítása:
    double suly = 0;                                      //7
    System.out.println("\nCsövek listája");
    for (int i=0; i<hengerek.size(); i++) {
      Object obj = hengerek.get(i);
      if (obj instanceof Cso) {
        System.out.println(obj);
        suly += ((Cso)obj).suly();
      }
    }
    System.out.println("\nCsövek súlya összesen: "+
      Format.right(suly,0,2));

    // Született hengerek száma:
    System.out.println("\nSzületett hengerek száma: "+
      Henger.getSzuletesSzamlalo());                      //8
  }

  public static void main (String args[]) {
    new HengerProgram().run();
    Console.pressEnter();
  }
}
