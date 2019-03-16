/*
 * Feladatmegold�sok/3. fejezet
 * Projekt: Verem
 * Verem.java (f�oszt�ly)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

public class Verem {
  public static void main(String[] args)  {
    IStack verem = new VectorStack();
    //IStack verem = new ArrayStack();

    verem.push("mad�r!");
    verem.push("a ");
    verem.push("tojik ");
    verem.push("neked ");
    verem.push("Alad�r, ");
    verem.push("Alad�r, ");

    while (! verem.isEmpty())
      System.out.print(verem.pop());
  }
}