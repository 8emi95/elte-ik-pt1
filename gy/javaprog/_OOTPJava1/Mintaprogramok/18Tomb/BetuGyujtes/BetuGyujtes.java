/*
 * Mintaprogramok/18. fejezet
 * BetuGyujtes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class BetuGyujtes {
  public static void main (String args[]) {
    String szoveg = Console.readLine("Szöveg: ");
    int[] karakterek = new int['Z'-'A'+1];                    //1
    char karakter;
    for (int i=0; i<szoveg.length(); i++) {                   //2
      karakter = Character.toUpperCase(szoveg.charAt(i));
      if (karakter>='A' && karakter<='Z')
        karakterek[karakter-'A']++;
    }
    for (int i=0; i<karakterek.length; i++) {                 //3
      if (karakterek[i] != 0)
        System.out.println((char)('A'+i)+": "+karakterek[i]);
    }
  }
}
