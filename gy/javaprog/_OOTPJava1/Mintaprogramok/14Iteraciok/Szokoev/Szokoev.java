/*
 * Mintaprogramok/14. fejezet
 * Szokoev.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Szokoev {
  public static void main (String args[]) {
    int tolEv = 1979, igEv = 2020;
    int szokoSzam = 0;

    System.out.print("Szökõévek (366 naposak):");
    // A ciklus az elsõ 4-gyel osztható évrõl indul, négyesével megy:
    for (int ev=((tolEv-1)/4+1)*4; ev<igEv; ev+=4) {
      if (ev%100==0 && ev%400!=0)
        continue;
      // Ez egy szökõév:
      System.out.print(ev+" ");
      szokoSzam++;
    }
    System.out.println("\nSzökõévek száma: "+szokoSzam);
  }
}
