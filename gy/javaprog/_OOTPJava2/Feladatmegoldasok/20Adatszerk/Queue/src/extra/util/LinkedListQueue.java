/*
 * Feladatmegold�sok/20. fejezet
 * Projekt: Queue
 * Csomag: extra.util
 * LinkedListQueue.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package extra.util;

// Sor megval�s�t�sa egyszer� fej n�lk�li, egyir�ny�, ny�ltv�g� l�ncolt list�val:
public class LinkedListQueue implements extra.util.IQueue {

  // Egy elemet reprezent�l� bels� oszt�ly:
  private class Elem {
    private Object data;
    private Elem next;

    public Elem(Object data, Elem next) {
      this.data = data;
      this.next = next;
    }

    public String toString() {
      return data.toString();
    }
  }

  protected Elem first, last;
  protected int size = 0;

  public void put(Object obj) {
    Elem newElem = new Elem(obj,null);
    if (isEmpty())
      first = newElem;
    else
      last.next = newElem;
    last = newElem;
    size++;
  }

  public Object get() {
    if (isEmpty())
      return null;
    Object firstElem = first;
    first = first.next;
    if (first == null)
      last = null;
    size--;
    return firstElem;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public String toString() {
    StringBuffer str = new StringBuffer("");
    Elem pointer = first;
    while (pointer != null) {
      str.append(pointer.data.toString()+" ");
      pointer = pointer.next;
    }
    return str.toString();
  }
}
