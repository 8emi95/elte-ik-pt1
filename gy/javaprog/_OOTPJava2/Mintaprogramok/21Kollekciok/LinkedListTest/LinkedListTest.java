/*
 * Mintaprogramok/21. fejezet
 * LinkedListTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList lista = new LinkedList();
    lista.add("Gerg�");
    lista.add("Anna");
    lista.add("Matyi");

    System.out.println("List�z�s el�re:");
    ListIterator iter = lista.listIterator();
    while (iter.hasNext())
      System.out.println(iter.next());

    System.out.println("\nList�z�s visszafel�, k�zben az "+
                       "A bet�s�k t�rl�se:");
    while (iter.hasPrevious()) {
      String str = (String)iter.previous();
      System.out.println(str);
      if (str.startsWith("A"))
        iter.remove();
    }

    System.out.println("\nLista el�re: ");
    iter = lista.listIterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }

    System.out.println("\nUtols� elem: "+
                       lista.get(lista.size()-1));
  } // main
}
