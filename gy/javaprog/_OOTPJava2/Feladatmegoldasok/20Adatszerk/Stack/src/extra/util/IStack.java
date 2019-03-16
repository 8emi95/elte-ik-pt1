/*
 * Feladatmegoldások/20. fejezet
 * Projekt: Stack
 * Csomag: extra.util
 * IStack.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
