/*
 * javalib k�nyvt�r
 *
 * Csomag: extra.util
 * IQueue.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package extra.util;

public interface IQueue {
  void put(Object o);
  Object get();
  boolean isEmpty();
}
