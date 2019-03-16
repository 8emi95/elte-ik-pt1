/*
 * Mintaprogramok/19. fejezet
 * PrimitivRendezett.java
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
    rendez();
  }

  public void kiir() {
    for (int i=0; i<size; i++)
      System.out.print(tomb[i]+" ");
    System.out.println();
  }

  private void rendez() {
    for (int i=0; i<=size-2; i++) {
      int minIndex = i;
      for (int j=i+1; j<=size-1; j++)
        if (tomb[j] < tomb[minIndex])    // elemek hasonlítása
          minIndex = j;
      if (i != minIndex) {
        int seged = tomb[i];      // i. és minIndex. elem cseréje
        tomb[i] = tomb[minIndex];
        tomb[minIndex] = seged;
      }
    }
  }

  // Adott elem keresése:
  public int indexOf(int elem) {
    for (int i=0; i<size; i++) {
      if (tomb[i] == elem)
        return i;
      if (tomb[i] > elem)
        return -1;
    }
    return -1;
  }
}

public class PrimitivRendezett {
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



