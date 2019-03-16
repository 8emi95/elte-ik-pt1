/*
 * Mintaprogramok/20. fejezet
 * LinkedListTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

class SimpleLinkedList {

  // Egy elemet reprezentáló belsõ osztály:
  class Elem {                                             //1
    Object obj;
    Elem next, prev;

    public Elem(Object obj, Elem next, Elem prev) {
      this.obj = obj;
      this.next = next;
      this.prev = prev;
    }
  }

  // LancoltLista adatai, metódusai:
  private Elem header;                                     //2
  private int size;

  public SimpleLinkedList() {                              //3
    header = new Elem(null, null, null);
    header.next = header.prev = header;
    size = 0;
  }

  public Object getFirst() {                               //4
    if (size == 0)
      return null;
    return header.next.obj;
  }

  public Object getLast() {                                //5
    if (size == 0)
      return null;
    return header.prev.obj;
  }

  public int size() {                                      //6
    return size;
  }

  public void addFirst(Object obj) {                       //7
    Elem newElem = new Elem(obj, header.next, header);     //8
    header.next.prev = newElem;                            //9
    header.next = newElem;                                //10
    size++;                                               //11
  }

  public void addLast(Object obj) {                       //12
    Elem newElem = new Elem(obj, header, header.prev);    //13
    header.prev.next = newElem;                           //14
    header.prev = newElem;                                //15
    size++;                                               //16
  }

  public void print() {                                   //17
    Elem pointer = header.next;
    while (pointer != header) {
      System.out.println(pointer.obj);
      pointer = pointer.next;
    }
  }
}

public class LinkedListTest {
  public static void main(String[] args)  {              //18
    SimpleLinkedList list = new SimpleLinkedList();
    list.addFirst("Úttörõ");
    list.addFirst("Kisdobos");
    list.addLast("Utolsó");
    list.addFirst("Elsõ");
    list.print();
    System.out.println("\nElsõ elem: "+list.getFirst());
    System.out.println("Utolsó elem: "+list.getLast());
  }
}
