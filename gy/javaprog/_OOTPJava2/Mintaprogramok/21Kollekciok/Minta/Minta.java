/*
 * Mintaprogramok/21. fejezet
 * Minta.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2004.09.01.
 */

import java.util.*;

public class Minta {
  public static void main(String[] args) {
    TreeSet nyelvek = new TreeSet();                        //1
    nyelvek.add("Java");
    nyelvek.add("PHP");
    nyelvek.add("Delphi");
    nyelvek.add("Java");

    System.out.println("Nyelvek: "+nyelvek);           //3
    System.out.println("Nyelvek száma: "+nyelvek.size());
    if (nyelvek.contains("Java"))
      System.out.println("A Java benne van.");
  }
}
