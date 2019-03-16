/*
 * Feladatmegoldások/3. fejezet
 * Projekt: SikIdomok
 * SikIdomok.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import sikidomok.*;
import extra.Format;
import java.util.*;

public class SikIdomok {
  private Vector idomok = new Vector();

  public SikIdomok() {
    idomok.add(new Teglalap(6,9));
    idomok.add(new Kor(4));
    idomok.add(new Negyzet(5.8));
    idomok.add(new Negyzet(7));
    idomok.add(new Kor(12));
  }

  // a)
  void lista() {
    System.out.println("\nSikidomok listaja");
    for (int i=0; i<idomok.size(); i++)
      System.out.println(idomok.get(i));
  }

  // b)
  double atlagTerulet() {
    if (idomok.isEmpty())
      return 0;
    double osszTer=0;
    for (int i=0; i<idomok.size(); i++) {
      osszTer += ((SikIdom)idomok.get(i)).terulet();
    }
    return osszTer/idomok.size();
  }

  // c)
  int korokSzama() {
    int ksz=0;
    for (int i=0; i<idomok.size(); i++)
      if (idomok.get(i) instanceof Kor)
        ksz++;
    return ksz;
  }

  void run() {
    lista();
    System.out.println("\nAtlag terulet: "+Format.right(atlagTerulet(),0,2));
    System.out.println("\nKorok szama: "+korokSzama());
  }

  public static void main (String args[]) {
    new SikIdomok().run();
  }
}
