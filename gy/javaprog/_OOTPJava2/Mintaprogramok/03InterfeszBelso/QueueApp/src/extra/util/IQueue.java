/*
 * javalib könyvtár
 *
 * Csomag: extra.util
 * IQueue.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package extra.util;

public interface IQueue {
  void put(Object o);
  Object get();
  boolean isEmpty();
}
