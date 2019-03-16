/*
 * Mintaprogramok/19. fejezet
 * StringRendezett.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class Kontener {
  private String[] tomb = new String[1000];
  private int size=0;

  public Kontener() {
    String elem;
    while ((size<tomb.length) && !(elem=Console.readLine("Sz�veg: ")).equals("")) {
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
        if (tomb[j].compareTo(tomb[minIndex])<0) //3 tomb[j] < tomb[minIndex]
          minIndex = j;
      if (i != minIndex) {
        String seged = tomb[i];
        tomb[i] = tomb[minIndex];
        tomb[minIndex] = seged;
      }
    }
  }

  // Adott elem keres�se:
  public int indexOf(String elem) {
    for (int i=0; i<size; i++) {
      if (tomb[i].compareTo(elem) == 0)
        return i;
      if (tomb[i].compareTo(elem) > 0)
        return -1;
    }
    return -1;
  }
}

public class StringRendezett {
  public static void main(String[] args) {
    Kontener kontener = new Kontener();
    kontener.kiir();

    // Keres�s:
    String elem;
    while (!(elem = Console.readLine("Keresend� sz�veg: ")).equals("")) {
      int index = kontener.indexOf(elem);
      if (index >= 0)
        System.out.println("Indexe: "+index);
      else
        System.out.println("Nincs ilyen sz�veg");
    }
  }
}
