/*
 * Feladatmegold�sok/16. fejezet
 * BitKep.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class BitKep {

  // Els� megold�s. A bevezet� null�k nincsenek a l�ncban.
  static String bitKep1(int szam) {
    StringBuffer str = new StringBuffer(32);  // az int t�pus 32 bites
    do {
      if ((szam & 1) == 1)
        str.insert(0,'1');
      else
        str.insert(0,'0');
      szam >>= 1 ;
    } while (szam != 0);
    return str.toString();
  }

  // M�sodik megold�s. A bevezet� null�k is szerepelnek a l�ncban.
  static String bitKep2(int szam) {
    StringBuffer str = new StringBuffer(32);  // az int t�pus 32 bites
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
    int szam = Console.readInt("Sz�m= ");
    String bitKep = bitKep1(szam);
    System.out.println(bitKep + " " + num(bitKep));

    bitKep = bitKep2(szam);
    System.out.println(bitKep + " " + num(bitKep));
  }
}
