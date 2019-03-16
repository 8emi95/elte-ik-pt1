/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: db
 * Key.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Kulcs oszt�ly egy egyedhez. Tartalmazza a kulcsot �s az egyed poz�ci�j�t a lemezen.
 */

package db;
import java.util.*;

// Egy kulcsbejegyz�s:
public class KeyEntry implements Comparable {
  public String key;
  public long position;

  public KeyEntry(String key, long position) {
    this.key = key;
    this.position = position;
  }

  public int compareTo(Object o) {
   return key.compareTo(((KeyEntry)o).key);
  }

  public boolean equals(Object o) {
    return key.equals(((KeyEntry)o).key) &&
      position == ((KeyEntry)o).position;
  }

  public String toString() {
    return key;
  }
}
