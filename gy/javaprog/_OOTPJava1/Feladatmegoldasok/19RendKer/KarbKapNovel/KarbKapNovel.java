/*
 * Feladatmegoldások/19. fejezet
 * KarbKapNovel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 *
 * Változások a Mintaprogramok\19. fejezet, KarRendezett-hez képest:
 * - increaseCapacity() metódus;
 * - add() metódusnál kapacitás növelése;
 * - beszuras() metódusban nincs isFull() vizsgálat.
 */

import extra.*;

class SortedStringContainer {
  private String[] array;         // konténer tömb
  private int capacity;           // konténer kapacitása
  private int capacityIncrement;  // a kapacitás bõvítésének mértéke
  private int size;               // konténer aktuális mérete
  private int current;            // keresés után felhasználható mutató

  public SortedStringContainer(int capacity) {
    this.capacity = capacity;
    capacityIncrement = 10;
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

  // Megnöveli a konténer kapacitását plus darab elemmel:
  public void increaseCapacity(int plus) {
    capacity += plus;
    String[] array = new String[capacity];
    for (int i=0; i<size; i++)
      array[i] = this.array[i];
    this.array = array;
  }

  // Megmondja, van-e már ilyen elem. current az a mutató,
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

  // Visszaadja az elem indexét. -1, ha nincs.
  // A current keres a tömbben, és állítja current értékét.
  public int indexOf(String str) {
    if (contains(str))
      return current;
    else
      return -1;
  }

  // Beszúrás. A felette álló elemeket feljebb toljuk:
  public boolean add(String str) {
    // Ha tele van, megnöveljük a kapacitást capacityIncrement darab elemmel:
    if (isFull())
      increaseCapacity(capacityIncrement);

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

  // Törlés. A törölt elemre húzzuk a felette álló elemeket:
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

  // Elemek listázása:
  public void print() {
    for (int i=0; i<size; i++)
      System.out.println(array[i]);
  }
}

// Nevek rendezett karbantartása és listázása:
public class KarbKapNovel {
  private SortedStringContainer nevek = new SortedStringContainer(10);

  void beszuras() {
    String nev = Console.readLine("Új név: ");
    if (nevek.contains(nev))
      System.out.println("Van már ilyen név");
    else
      nevek.add(nev);
  }

  void kereses() {
    String nev = Console.readLine("Keresendõ név: ");
    int n = nevek.indexOf(nev);
    if (n == -1)
      System.out.println("Nincs ilyen név");
    else
      System.out.println(n+". név");
  }

  void torles() {
    String nev = Console.readLine("Törlendõ név: ");
    if (nevek.indexOf(nev)>=0) {
      if (Character.toUpperCase(Console.readChar
        ("Biztosan törölni akarja? (I/N) "))=='I')
        nevek.remove(nev);
      }
    else
      System.out.println("Nincs ilyen név!");
  }

  void listazas() {
    System.out.println("Nevek:");
    nevek.print();
  }

  void menu() {
    char menu;
    do {
      System.out.print("\nÚ(j) K(eres) T(öröl) L(ista) V(ége)? ");
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
    new KarbKapNovel().menu();
  }
}
