/*
 * Feladatmegold�sok/20. fejezet
 * Projekt: Stack
 * Csomag: extra.util
 * IStack.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2003.04.01.
 */

package extra.util;

public interface IStack {
  void push(Object o);
  Object pop();
  Object top();
  boolean isEmpty();
  int size();
}
