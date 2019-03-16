/*
 * Feladatmegold�sok/3. fejezet
 * Projekt: Verem
 * VectorStack.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class VectorStack implements IStack {
  private Vector tarolo = new Vector();

  public Object pop() {
    if (tarolo.isEmpty())
      return null;
    return tarolo.remove(tarolo.size()-1);
  }

  public void push(Object elem) {
    tarolo.add(elem);
  }

  public boolean isEmpty() {
    return tarolo.isEmpty();
  }
}