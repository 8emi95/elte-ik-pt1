/*
 * javalib k�nyvt�r
 *
 * Csomag: extra.util
 * Queue.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package extra.util;
import java.util.*;

public class Queue implements IQueue {
  protected Vector v = new Vector();

  public void put(Object o) {
    v.add(o);
  }

  public Object get() {
    if (isEmpty())
      return null;
    return v.remove(0);
  }

  public boolean isEmpty() {
    return v.size() == 0;
  }

  public String toString() {
    StringBuffer str = new StringBuffer("");
    for (int i=0; i<v.size(); i++)
      str.append(v.get(i)+" ");
    return str.toString();
  }
}
