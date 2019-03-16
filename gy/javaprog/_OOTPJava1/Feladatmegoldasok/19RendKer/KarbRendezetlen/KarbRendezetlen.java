/*
 * Feladatmegold�sok/19. fejezet
 * KarbRendezetlen.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 *
 * V�ltoz�sok a Mintaprogramok\19. fejezet, KarRendezett-hez k�pest:
 * - contains() met�dusban v�gig keres�nk;
 * - add() met�dusban �j elem a v�g�re ker�l;
 * - remove() met�dusban az utols� elem ker�l a t�r�lt hely�re.
 */

import extra.*;

class StringContainer {
  private String[] array;  // kont�ner t�mb
  private int capacity;    // kont�ner kapacit�sa
  private int size;        // kont�ner aktu�lis m�rete
  private int current;     // keres�s ut�n felhaszn�lhat� mutat�

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

  // Megmondja, van-e m�r ilyen elem. current az a mutat�,
  // ahol az elem van, vagy lenne:
  public boolean contains(String str) {
    for (current=0; current<size; current++) {
      if (array[current].compareTo(str) == 0)
        return true;
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
    else {
      array[size] = str;
      size++;
      return true;
    }
  }

  // T�rl�s. A t�r�lt elemre h�zzuk a felette �ll� elemeket:
  public boolean remove(String str) {
    if (contains(str)) {
      array[current] = array[size-1];
      size--;
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

/* Nevek rendezetlen karbantart�sa �s list�z�sa.
 * A kont�nert gyors besz�r�shoz k�sz�tett�k, amit most nem haszn�lunk ki.
 * A besz�r�s akkor lehetne p�ld�ul gyors, ha a sz�vegek lemezr�l ker�ln�nek a kont�nerbe.)
 */
public class KarbRendezetlen {
  private StringContainer nevek = new StringContainer(20);

  void beszuras() {
    String nev = Console.readLine("�j n�v: ");
    if (nevek.isFull())
      System.out.println("Nincs t�bb hely");
    else if (nevek.contains(nev))
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
      System.out.print("\n�(j) K(eres) T(�r�l) L(ista) V(�ge)? ");
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
