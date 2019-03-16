/*
 * javalib könyvtár
 *
 * Csomag: extra.util
 * ICleverQueue.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package extra.util;

public interface ICleverQueue extends IQueue {
  void remove(int n);
  int size();
}
