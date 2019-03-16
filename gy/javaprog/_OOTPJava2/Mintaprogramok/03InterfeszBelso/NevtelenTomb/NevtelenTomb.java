/*
 * Mintaprogramok/3. fejezet
 * NevtelenTomb.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

public class NevtelenTomb {
  static void egyDim() {
    String[] szinek;
    szinek = new String[] {"Piros", "Feh�r", "Z�ld"};

    for (int i = 0; i<szinek.length; i++)
      System.out.println(szinek[i]);
  }

  static void ketDim() {
    String[][] szinek;

    szinek = new String[][] {
      {"Piros", "Feh�r", "Z�ld"},
      {"Egy", "Kett�"}
    };

    for (int i = 0; i<szinek.length; i++)
      for (int j = 0; j<szinek[i].length; j++)
        System.out.println(szinek[i][j]);

  } // main

  public static void main(String[] args)  {
    System.out.println("Egydimenzi�s t�mb:");
    egyDim();
    System.out.println("\nK�tdimenzi�s t�mb:");
    ketDim();
  }
}
