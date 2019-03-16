/*
 * Mintaprogramok/3. fejezet
 * NevtelenTomb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

public class NevtelenTomb {
  static void egyDim() {
    String[] szinek;
    szinek = new String[] {"Piros", "Fehér", "Zöld"};

    for (int i = 0; i<szinek.length; i++)
      System.out.println(szinek[i]);
  }

  static void ketDim() {
    String[][] szinek;

    szinek = new String[][] {
      {"Piros", "Fehér", "Zöld"},
      {"Egy", "Kettõ"}
    };

    for (int i = 0; i<szinek.length; i++)
      for (int j = 0; j<szinek[i].length; j++)
        System.out.println(szinek[i][j]);

  } // main

  public static void main(String[] args)  {
    System.out.println("Egydimenziós tömb:");
    egyDim();
    System.out.println("\nKétdimenziós tömb:");
    ketDim();
  }
}
