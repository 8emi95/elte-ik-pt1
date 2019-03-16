/*
 * Feladatmegoldások/3. fejezet
 * Projekt: Verem
 * IStack.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

interface IStack {
  public Object pop();
  public void push(Object elem);
  public boolean isEmpty();
}