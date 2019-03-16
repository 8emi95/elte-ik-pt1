/*
 * Feladatmegoldások/19. fejezet
 * KarbRendezetlen.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 *
 * Változások a Mintaprogramok\19. fejezet, KarRendezett-hez képest:
 * - contains() metódusban végig keresünk;
 * - add() metódusban új elem a végére kerül;
 * - remove() metódusban az utolsó elem kerül a törölt helyére.
 */

import extra.*;

class StringContainer {
  private String[] array;  // konténer tömb
  private int capacity;    // konténer kapacitása
  private int size;        // konténer aktuális mérete
  private int current;     // keresés után felhasználható mutató

  public StringContainer(int capacity) {
    this.capacity = capacity;
    size = 0;
    array = new String[capacity];
  }

  public StringContainer() {
    this(100);
  }

  public int capacity() { return capacity; }
  public int size() { return size; }
  public boolean isEmpty() { return size == 0; }
  public boolean isFull() { return size == capacity; }

  // Megmondja, van-e már ilyen elem. current az a mutató,
  // ahol az elem van, vagy lenne:
  public boolean contains(String str) {
    for (current=0; current<size; current++) {
      if (array[current].compareTo(str) == 0)
        return true;
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
    if (isFull())
      return false;

    if (contains(str))
      return false;
    else {
      array[size] = str;
      size++;
      return true;
    }
  }

  // Törlés. A törölt elemre húzzuk a felette álló elemeket:
  public boolean remove(String str) {
    if (contains(str)) {
      array[current] = array[size-1];
      size--;
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

/* Nevek rendezetlen karbantartása és listázása.
 * A konténert gyors beszúráshoz készítettük, amit most nem használunk ki.
 * A beszúrás akkor lehetne például gyors, ha a szövegek lemezrõl kerülnének a konténerbe.)
 */
public class KarbRendezetlen {
  private StringContainer nevek = new StringContainer(20);

  void beszuras() {
    String nev = Console.readLine("Új név: ");
    if (nevek.isFull())
      System.out.println("Nincs több hely");
    else if (nevek.contains(nev))
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
    new KarbRendezetlen().menu();
  }
}
