/*
 * Mintaprogramok/19. fejezet
 * ClonePrimitivTomb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

public class ClonePrimitivTomb {

  static void print(int[] t) {
    for (int i=0; i<t.length; i++)
      System.out.print(t[i]+" ");
    System.out.println();
  }

  public static void main (String args[]) {
    int[] tomb = new int[5];
    for (int i=0; i<tomb.length; i++)
      tomb[i] = i;

    int[] masoltTomb = (int[])tomb.clone();
    masoltTomb[0] = 9;
    print(tomb);
    print(masoltTomb);
  }
}
