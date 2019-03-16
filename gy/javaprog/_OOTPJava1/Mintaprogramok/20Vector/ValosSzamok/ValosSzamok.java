/*
 * Mintaprogramok/20. fejezet
 * ValosSzamok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.Console;
import java.util.*;

public class ValosSzamok {

  public static void main(String[] args) {
    Vector szamok = new Vector();
    final double VEGJEL = 0;
    double szam;

    // Számok bekérése:
    while (true) {
      szam = Console.readDouble("Szám: ");
      if (szam==VEGJEL)
        break;
      szamok.add(new Double(szam));
    }

    if (szamok.isEmpty()) {
      System.out.println("Nem adott meg egyetlen számot sem!");
      return;
    }

    // Számok kiírása egyenként:
    for (int i=0; i<szamok.size(); i++)
      System.out.print(szamok.get(i)+" ");
    System.out.println();

    // A vektor kiírása egyben, rendezés, újabb kiírás...
    System.out.println("A számok: "+szamok);
    Collections.sort(szamok);
    System.out.println("A számok rendezve: "+szamok);
    System.out.println("Legkisebb : "+Collections.min(szamok));
    System.out.println("Legnagyobb: "+Collections.max(szamok));

    // Egy szám keresése:
    szam = Console.readDouble("Keresendõ szám: ");
    int index=szamok.indexOf(new Double(szam));
    if (index==-1)
      System.out.println("Nincs ilyen szám");
    else
      System.out.println("Van ilyen szám, indexe: "+index);
  }
}
