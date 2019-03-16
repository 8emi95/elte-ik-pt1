/*
 * Feladatmegoldások/3. fejezet
 * Projekt: Verem
 * Verem.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

public class Verem {
  public static void main(String[] args)  {
    IStack verem = new VectorStack();
    //IStack verem = new ArrayStack();

    verem.push("madár!");
    verem.push("a ");
    verem.push("tojik ");
    verem.push("neked ");
    verem.push("Aladár, ");
    verem.push("Aladár, ");

    while (! verem.isEmpty())
      System.out.print(verem.pop());
  }
}