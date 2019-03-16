/*
 * Feladatmegold�sok/20. fejezet
 * LinkedListTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2003.04.01.
 */

public class LinkedListTest {

  public static void main(String[] args) {
    LinkedList lista = new LinkedList();
    lista.addFirst("Utt�r�");
    lista.addFirst("Kisdobos");
    lista.addLast("Utols�");
    lista.addFirst("Els�");
    lista.print();

    System.out.println("\nEls� elem: "+lista.getFirst());
    System.out.println("M�sodik elem: "+lista.getNext(lista.getFirst()));
    System.out.println("M�sodik elem: "+lista.get(2));
    System.out.println("Utols� el�tti elem: "+lista.getPrev(lista.getLast()));
    System.out.println("Utols� elem: "+lista.getLast());
    System.out.println("Utt�r� ut�ni elem: "+lista.getNext("Utt�r�"));

    if (lista.delete(1)) {
      System.out.println("\nElso elem t�r�lve.");
      lista.print();
    }
    else
      System.out.println("\nAz els� elem t�rl�se nem siker�lt!");

    if (lista.delete(3)) {
      System.out.println("\nHarmadik elem t�r�lve.");
      lista.print();
    }
    else
      System.out.println("\nA harmadik elem t�rl�se nem siker�lt!");

    if (lista.delete(3)) {
      System.out.println("\nHarmadik elem t�r�lve.");
      lista.print();
    }
    else
      System.out.println("\nA harmadik elem t�rl�se nem siker�lt!");
  }
}
