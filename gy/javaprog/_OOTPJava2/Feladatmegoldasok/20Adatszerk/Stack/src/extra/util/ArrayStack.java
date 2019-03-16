/*
 * Feladatmegoldások/20. fejezet
 * Projekt: Stack
 * Csomag: extra.util
 * ArrayStack.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2003.04.01.
 */

package extra.util;

// Verem megvalósítása egydimenziós tömbbel:
public class ArrayStack implements IStack {
  public static int MAX_SIZE = Integer.MAX_VALUE;
  protected int size;
  protected int incr; // a bõvítés egysége
  protected Object[] array;

  public ArrayStack() {
    this(10);
  }

  public ArrayStack(int incr) {
    this.incr = incr;
    array = new Object[incr];
    size = 0;
  }

  public void push(Object obj) {
    if (isFull())
      return;
    if (size >= array.length) {
      //bõvítés
      Object[] newArray = new Object[size+incr];
      for (int i=0; i<size; i++) {
        newArray[i] = array[i];
      }
      array = newArray;
    }
    array[size++] = obj;
  }

  public Object pop() {
    if (isEmpty())
      return null;
    Object topElem = array[size-1];
    size--;
    return topElem;
  }

  public Object top() {
    if (isEmpty())
      return null;
    return array[size-1];
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
    for (int i=0; i<size; i++) {
      str.append(array[i]+" ");
    }
    return str.toString();
  }
}
