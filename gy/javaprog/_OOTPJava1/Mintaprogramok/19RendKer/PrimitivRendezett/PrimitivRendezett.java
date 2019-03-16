/*
 * Mintaprogramok/19. fejezet
 * PrimitivRendezett.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class Kontener {
  private int[] tomb = new int[1000];
  private int size=0;

  public Kontener() {
    int elem;
    while ((size<tomb.length) && (elem = Console.readInt("Sz�m: "))!=0) {
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
        if (tomb[j] < tomb[minIndex])    // elemek hasonl�t�sa
          minIndex = j;
      if (i != minIndex) {
        int seged = tomb[i];      // i. �s minIndex. elem cser�je
        tomb[i] = tomb[minIndex];
        tomb[minIndex] = seged;
      }
    }
  }

  // Adott elem keres�se:
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

    // Keres�sek:
    int elem;
    while ((elem = Console.readInt("Keresend� sz�m: "))!=0) {
      int index = kontener.indexOf(elem);
      if (index >= 0)
        System.out.println("Indexe: "+index);
      else
        System.out.println("Nincs ilyen sz�m");
    }
  }
}



