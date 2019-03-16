/*
 * Mintaprogramok/19. fejezet
 * KarbRendezett.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class SortedStringContainer {
  private String[] array;    // kont�ner t�mb
  private int capacity;      // kont�ner kapacit�sa
  private int size;          // kont�ner aktu�lis m�rete
  private int current;       // keres�s ut�n felhaszn�lhat� mutat�

  public SortedStringContainer(int capacity) {
    this.capacity = capacity;
    size = 0;
    array = new String[capacity];
  }

  public SortedStringContainer() {
    this(100);
  }

  public int capacity() { return capacity; }
  public int size() { return size; }
  public boolean isEmpty() { return size == 0; }
  public boolean isFull() { return size == capacity; }

  // Megmondja, van-e m�r ilyen elem. current az a mutat�,
  // ahol az elem van, vagy lenne:
  public boolean contains(String str) {
    for (current=0; current<size; current++) {
      if (array[current].compareTo(str) == 0)
        return true;
      if (array[current].compareTo(str) > 0)
        return false;
    }
    return false;
  }

  // Visszaadja az elem index�t. -1, ha nincs.
  // A current keres a t�mbben, �s �ll�tja current �rt�k�t.
  public int indexOf(String str) {
    if (contains(str))
      return current;
    else
      return -1;
  }

  // Besz�r�s. A felette �ll� elemeket feljebb toljuk:
  public boolean add(String str) {
    if (isFull())
      return false;

    if (contains(str))
      return false;
    else {                       // current-et a contains adja
      for (int i=size; i>current; i--)
        array[i] = array[i-1];
      array[current] = str;
      size++;
      return true;
    }
  }

  // T�rl�s. A t�r�lt elemre h�zzuk a felette �ll� elemeket:
  public boolean remove(String str) {
    if (contains(str)) {
      size--;
      for (int i=current; i<size; i++)
        array[i] = array[i+1];
      return true;
    }
    else
      return false;
  }

  // Elemek list�z�sa:
  public void print() {
    for (int i=0; i<size; i++)
      System.out.println(array[i]);
  }
}

// Nevek rendezett karbantart�sa �s list�z�sa:
public class KarbRendezett {
  private SortedStringContainer nevek = new SortedStringContainer(20);

  void beszuras() {
    if (nevek.isFull()) {
      System.out.println("Nincs t�bb hely");
      return;
    }
    String nev = Console.readLine("�j n�v: ");
    if (nevek.contains(nev))
      System.out.println("Van m�r ilyen n�v");
    else
      nevek.add(nev);
  }

  void kereses() {
    String nev = Console.readLine("Keresend� n�v: ");
    int n = nevek.indexOf(nev);
    if (n == -1)
      System.out.println("Nincs ilyen n�v");
    else
      System.out.println(n+". n�v");
  }

  void torles() {
    String nev = Console.readLine("T�rlend� n�v: ");
    if (nevek.indexOf(nev)>=0) {
      if (Character.toUpperCase(Console.readChar
        ("Biztosan t�r�lni akarja? (I/N) "))=='I')
        nevek.remove(nev);
      }
    else
      System.out.println("Nincs ilyen n�v!");
  }

  void listazas() {
    System.out.println("Nevek:");
    nevek.print();
  }

  void menu() {
    char menu;
    do {
      System.out.print("\nU(j) K(eres) T(�r�l) L(ista) V(�ge)? ");
      menu = Character.toUpperCase(Console.readChar());
      switch (menu) {
        case 'U' : { beszuras(); break; }
        case 'K' : { kereses(); break; }
        case 'T' : { torles(); break; }
        case 'L' : { listazas(); break; }
      }
    } while (menu != 'V');
  }

  public static void main(String[] args) {
    new KarbRendezett().menu();
  }
}
