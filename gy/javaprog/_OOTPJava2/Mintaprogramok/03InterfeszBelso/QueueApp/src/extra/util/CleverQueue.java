/*
 * javalib könyvtár
 *
 * Csomag: extra.util
 * CleverQueue.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package extra.util;

public class CleverQueue extends Queue implements ICleverQueue {
  public void remove(int n) {
    for (int i=0; i<n; i++) {
      if (isEmpty())
        break;
      get();
    }
  }

  public int size() {
    return v.size();
  }
}
