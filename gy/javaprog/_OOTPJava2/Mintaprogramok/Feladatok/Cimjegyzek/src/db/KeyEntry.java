/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: db
 * Key.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Kulcs osztály egy egyedhez. Tartalmazza a kulcsot és az egyed pozícióját a lemezen.
 */

package db;
import java.util.*;

// Egy kulcsbejegyzés:
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
