/*
 * Mintaprogramok/19. fejezet
 * PrimitivRendezetlen.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class Kontener {
  private int[] tomb = new int[1000];
  private int size=0;

  public Kontener() {
    int elem;
    while ((size<tomb.length) && (elem = Console.readInt("Szám: "))!=0) {
      tomb[size++] = elem;
    }
  }

  public void kiir() {
    for (int i=0; i<size; i++)
      System.out.print(tomb[i]+" ");
    System.out.println();
  }

  // Adott elem keresése:
  public int indexOf(int elem) {
    for (int i=0; i<size; i++) {
      if (tomb[i] == elem)
        return i;
    }
    return -1;
  }
}

public class PrimitivRendezetlen {
  public static void main(String[] args) {
    Kontener kontener = new Kontener();
    kontener.kiir();

    // Keresések:
    int elem;
    while ((elem = Console.readInt("Keresendõ szám: "))!=0) {
      int index = kontener.indexOf(elem);
      if (index >= 0)
        System.out.println("Indexe: "+index);
      else
        System.out.println("Nincs ilyen szám");
    }
  }
}
