/*
 * Mintaprogramok/21. fejezet
 * LinkedListTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList lista = new LinkedList();
    lista.add("Gergõ");
    lista.add("Anna");
    lista.add("Matyi");

    System.out.println("Listázás elõre:");
    ListIterator iter = lista.listIterator();
    while (iter.hasNext())
      System.out.println(iter.next());

    System.out.println("\nListázás visszafelé, közben az "+
                       "A betûsök törlése:");
    while (iter.hasPrevious()) {
      String str = (String)iter.previous();
      System.out.println(str);
      if (str.startsWith("A"))
        iter.remove();
    }

    System.out.println("\nLista elõre: ");
    iter = lista.listIterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }

    System.out.println("\nUtolsó elem: "+
                       lista.get(lista.size()-1));
  } // main
}
