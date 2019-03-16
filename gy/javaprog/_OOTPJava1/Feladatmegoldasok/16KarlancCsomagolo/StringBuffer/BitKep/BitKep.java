/*
 * Feladatmegoldások/16. fejezet
 * BitKep.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class BitKep {

  // Elsõ megoldás. A bevezetõ nullák nincsenek a láncban.
  static String bitKep1(int szam) {
    StringBuffer str = new StringBuffer(32);  // az int típus 32 bites
    do {
      if ((szam & 1) == 1)
        str.insert(0,'1');
      else
        str.insert(0,'0');
      szam >>= 1 ;
    } while (szam != 0);
    return str.toString();
  }

  // Második megoldás. A bevezetõ nullák is szerepelnek a láncban.
  static String bitKep2(int szam) {
    StringBuffer str = new StringBuffer(32);  // az int típus 32 bites
    for (int i=31; i>=0; i--)
      str.append(szam>>i & 1);
    return str.toString();
  }

  static long num(String bitKep) {
     long num = 0;
     long he = 1;
     for (int i=bitKep.length()-1; i>=0; i--) {
       if (bitKep.charAt(i) != '0')
         num += he;
       he *= 2;
     }
     return num;
  }

  public static void main(String[] args) {
    int szam = Console.readInt("Szám= ");
    String bitKep = bitKep1(szam);
    System.out.println(bitKep + " " + num(bitKep));

    bitKep = bitKep2(szam);
    System.out.println(bitKep + " " + num(bitKep));
  }
}
