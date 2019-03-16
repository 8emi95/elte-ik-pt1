/*
 * Feladatmegold�sok/20. fejezet
 * Projekt: Queue
 * Csomag: extra.util
 * ArrayQueue.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package extra.util;

// Sor megval�s�t�sa egydimenzi�s t�mbbel (ciklikus t�rol�s):
public class ArrayQueue implements extra.util.IQueue {
  public static int MAX_SIZE = Integer.MAX_VALUE;
  protected int first, last;
  protected int size;
  protected int incr; // a b�v�t�s egys�ge
  protected Object[] array;

  public ArrayQueue() {
    this(10);
  }

  public ArrayQueue(int incr) {
    this.incr = incr;
    array = new Object[incr];
    first = 0;
    last = prev(first);
    size = 0;
  }

  private int prev(int index) {
    index--;
    if (index < 0)
      index = array.length-1;
    return index;
  }

  private int next(int index) {
    index++;
    if (index > array.length-1)
      index = 0;
    return index;
  }

  public void put(Object obj) {
    if (isFull())
      return;
    if (size >= array.length) {
      //b�v�t�s
      Object[] newArray = new Object[size+incr];
      for (int i=0, index=first; i<size; i++) {
        newArray[i] = array[index];
        index = next(index);
      }
      array = newArray;
      first = 0;
      last = size-1;
    }
    last = next(last);
    array[last] = obj;
    size++;
  }

  public Object get() {
    if (isEmpty())
      return null;
    Object firstElem = array[first];
    first = next(first);
    size--;
    return firstElem;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == MAX_SIZE;
  }

  public int size() {
    return size;
  }

  public String toString() {
    StringBuffer str = new StringBuffer("");
    for (int i=1, index=first; i<=size; i++) {
      str.append(array[index]+" ");
      index = next(index);
    }
    return str.toString();
  }
}
