/*
 * Feladatmegoldások/2. fejezet
 * Projekt: SikIdomok
 * SikIdomok.java (Fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;
import idomok.*;
import extra.Format;

public class SikIdomok {
  private Vector idomok = new Vector();

  public SikIdomok() {
    idomok.add(new Teglalap(6,9));
    idomok.add(new Kor(4));
    idomok.add(new Negyzet(5));
    idomok.add(new Negyzet(7));
  }

  void lista(String info) {
    System.out.println("\n"+info);
    for (int i=0; i<idomok.size(); i++)
      System.out.println(idomok.get(i));
  }

  double atlagTerulet() {
    if (idomok.isEmpty())
      return 0;
    double osszTer=0;
    for (int i=0; i<idomok.size(); i++) {
      SikIdom sikIdom=(SikIdom)idomok.get(i);
      osszTer+=sikIdom.terulet();
    }
    return osszTer/idomok.size();
  }

  int korokSzama() {
    int ksz=0;
    for (int i=0; i<idomok.size(); i++)
      if (idomok.get(i) instanceof Kor)
        ksz++;
    return ksz;
  }

  void run() {
    if (idomok.isEmpty()) {
      System.out.println("\nNincs egyetlen sikidom sem!");
      return;
    }
    // a)
    lista("Sikidomok:");

    // b)
    System.out.println("\nSikidomok átlag területe: "+Format.left(atlagTerulet(),0,2));

    // c)
    System.out.println("\nLegkisebb sikidom : "+Collections.min(idomok));
    System.out.println("Legnagyobb sikidom: "+Collections.max(idomok));

    // d)
    Collections.sort(idomok);
    lista("Sikidomok rendezetten:");

    // e)
    System.out.println("\nKörök száma: "+korokSzama());
  }

  public static void main (String args[]) {
    new SikIdomok().run();
  }
}
