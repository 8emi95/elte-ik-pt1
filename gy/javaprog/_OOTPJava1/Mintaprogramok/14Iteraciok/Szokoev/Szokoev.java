/*
 * Mintaprogramok/14. fejezet
 * Szokoev.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class Szokoev {
  public static void main (String args[]) {
    int tolEv = 1979, igEv = 2020;
    int szokoSzam = 0;

    System.out.print("Sz�k��vek (366 naposak):");
    // A ciklus az els� 4-gyel oszthat� �vr�l indul, n�gyes�vel megy:
    for (int ev=((tolEv-1)/4+1)*4; ev<igEv; ev+=4) {
      if (ev%100==0 && ev%400!=0)
        continue;
      // Ez egy sz�k��v:
      System.out.print(ev+" ");
      szokoSzam++;
    }
    System.out.println("\nSz�k��vek sz�ma: "+szokoSzam);
  }
}
