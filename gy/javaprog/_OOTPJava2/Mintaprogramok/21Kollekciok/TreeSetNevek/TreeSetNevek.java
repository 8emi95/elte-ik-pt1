/*
 * Mintaprogramok/21. fejezet
 * TreeSetNevek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class TreeSetNevek {
  public static void main(String[] args) {
    TreeSet nevsor = new TreeSet();                        //1

    nevsor.add("Soma");
    nevsor.add("Jeremiás");
    nevsor.add("Janka");

    // Kiírás névsorban:
    System.out.println(nevsor);

    TreeSet nevek = new TreeSet(new Comparator() {         //2
      public int compare(Object a, Object b) {
        return ((String)a).length() - ((String)b).length();
      }
    } );
    nevek.addAll(nevsor);
    System.out.println(nevek);
  }
}
