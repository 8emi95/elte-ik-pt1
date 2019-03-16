/*
 * Feladatmegoldások/3. fejezet
 * Projekt: Verem
 * ArrayStack.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class ArrayStack implements IStack {
  // Maximalizálni kell a verem méretét:
  private Object[] tarolo = new Object[100];
  private int size=0;

  public Object pop() {
    if (tarolo.length == 0)
      return null;
    size--;
    return tarolo[size];
  }

  public void push(Object elem) {
    if (size < tarolo.length) {
      tarolo[size] = elem;
      size++;
    }
  }

  public boolean isEmpty() {
    return size==0;
  }
}