/*
 * Feladatmegold�sok/3. fejezet
 * Projekt: Verem
 * IStack.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

interface IStack {
  public Object pop();
  public void push(Object elem);
  public boolean isEmpty();
}