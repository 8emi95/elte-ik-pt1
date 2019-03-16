/*
 * Feladatmegoldások/20. fejezet
 * LinkedListTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2003.04.01.
 */

public class LinkedListTest {

  public static void main(String[] args) {
    LinkedList lista = new LinkedList();
    lista.addFirst("Uttörõ");
    lista.addFirst("Kisdobos");
    lista.addLast("Utolsó");
    lista.addFirst("Elsõ");
    lista.print();

    System.out.println("\nElsõ elem: "+lista.getFirst());
    System.out.println("Második elem: "+lista.getNext(lista.getFirst()));
    System.out.println("Második elem: "+lista.get(2));
    System.out.println("Utolsó elõtti elem: "+lista.getPrev(lista.getLast()));
    System.out.println("Utolsó elem: "+lista.getLast());
    System.out.println("Uttörõ utáni elem: "+lista.getNext("Uttörõ"));

    if (lista.delete(1)) {
      System.out.println("\nElso elem törölve.");
      lista.print();
    }
    else
      System.out.println("\nAz elsõ elem törlése nem sikerült!");

    if (lista.delete(3)) {
      System.out.println("\nHarmadik elem törölve.");
      lista.print();
    }
    else
      System.out.println("\nA harmadik elem törlése nem sikerült!");

    if (lista.delete(3)) {
      System.out.println("\nHarmadik elem törölve.");
      lista.print();
    }
    else
      System.out.println("\nA harmadik elem törlése nem sikerült!");
  }
}
