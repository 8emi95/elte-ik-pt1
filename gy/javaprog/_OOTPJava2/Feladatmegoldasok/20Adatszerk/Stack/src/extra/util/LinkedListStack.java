/*
 * Feladatmegoldások/20. fejezet
 * Projekt: Stack
 * Csomag: extra.util
 * LinkedListStack.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2003.04.01.
 */

package extra.util;

// Verem megvalósítása egyszerû fej nélküli, egyirányú, nyíltvégû láncolt listával:
public class LinkedListStack implements IStack {

  // Egy elemet reprezentáló belsõ osztály:
  private class Elem {
    private Object data;
    private Elem previous, next;

    public Elem(Object data, Elem previous, Elem next) {
      this.data = data;
      this.previous = previous;
      this.next = next;
    }

    public String toString() {
      return data.toString();
    }
  }

  protected Elem first, last;
  protected int size;

  public LinkedListStack() {
    first = last = null;
    size = 0;
  }

  public void push(Object obj) {
    Elem newElem = new Elem(obj,last,null);
    if (isEmpty())
      first = newElem;
    else
      last.next = newElem;
    last = newElem;
    size++;
  }

  public Object pop() {
    if (isEmpty())
      return null;
    Object lastElem = last;
    last = last.previous;
    if (last == null)
      first = null;
    else
      last.next = null;
    size--;
    return lastElem;
  }

  public Object top() {
    if (isEmpty())
      return null;
    return last;
  }

  public boolean isEmpty() {
    return size == 0;
    // Másik megoldás: return first == null;
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
