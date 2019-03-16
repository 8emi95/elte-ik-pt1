/*
 * Mintaprogramok/20. fejezet
 * ValosSzamok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.Console;
import java.util.*;

public class ValosSzamok {

  public static void main(String[] args) {
    Vector szamok = new Vector();
    final double VEGJEL = 0;
    double szam;

    // Sz�mok bek�r�se:
    while (true) {
      szam = Console.readDouble("Sz�m: ");
      if (szam==VEGJEL)
        break;
      szamok.add(new Double(szam));
    }

    if (szamok.isEmpty()) {
      System.out.println("Nem adott meg egyetlen sz�mot sem!");
      return;
    }

    // Sz�mok ki�r�sa egyenk�nt:
    for (int i=0; i<szamok.size(); i++)
      System.out.print(szamok.get(i)+" ");
    System.out.println();

    // A vektor ki�r�sa egyben, rendez�s, �jabb ki�r�s...
    System.out.println("A sz�mok: "+szamok);
    Collections.sort(szamok);
    System.out.println("A sz�mok rendezve: "+szamok);
    System.out.println("Legkisebb : "+Collections.min(szamok));
    System.out.println("Legnagyobb: "+Collections.max(szamok));

    // Egy sz�m keres�se:
    szam = Console.readDouble("Keresend� sz�m: ");
    int index=szamok.indexOf(new Double(szam));
    if (index==-1)
      System.out.println("Nincs ilyen sz�m");
    else
      System.out.println("Van ilyen sz�m, indexe: "+index);
  }
}
