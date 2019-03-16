/*
 * Mintaprogramok/16. fejezet
 * LegElso.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class LegElso {

  public static void main(String[] args) {
    // A bevitt szavak ennél biztosan kisebbek lesznek:
    final String NAGY = "\uffff";
    String szo, elso = NAGY;
    while (!(szo=Console.readLine("Szó: ")).equals("*")) {
      // Nem jó, ha van benne szóköz vagy üres:
      if (szo.indexOf(" ")>=0 || szo.length()==0)
        System.out.println("Van benne szókoz, vagy üres!");
      else if (szo.compareTo(elso)<0)       // szo < elso
        elso = szo;
    }
    if (elso.equals(NAGY))
      System.out.println("Nem volt jó szó bevitel!");
    else
      System.out.println("ABC szerint az elso: "+elso);
  }
}

