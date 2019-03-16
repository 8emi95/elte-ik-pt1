/*
 * Mintaprogramok/16. fejezet
 * LegElso.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class LegElso {

  public static void main(String[] args) {
    // A bevitt szavak enn�l biztosan kisebbek lesznek:
    final String NAGY = "\uffff";
    String szo, elso = NAGY;
    while (!(szo=Console.readLine("Sz�: ")).equals("*")) {
      // Nem j�, ha van benne sz�k�z vagy �res:
      if (szo.indexOf(" ")>=0 || szo.length()==0)
        System.out.println("Van benne sz�koz, vagy �res!");
      else if (szo.compareTo(elso)<0)       // szo < elso
        elso = szo;
    }
    if (elso.equals(NAGY))
      System.out.println("Nem volt j� sz� bevitel!");
    else
      System.out.println("ABC szerint az elso: "+elso);
  }
}

