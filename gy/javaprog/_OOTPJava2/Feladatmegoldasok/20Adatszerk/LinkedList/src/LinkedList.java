/*
 * Feladatmegold�sok/20. fejezet
 * LinkedList.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2003.04.01.
 */

public class LinkedList {

  // Egy elemet reprezent�l� bels� oszt�ly:
  class Elem {
    private Object obj;
    private Elem next, prev;

    public Elem(Object obj, Elem next, Elem prev) {
      this.obj = obj;
      this.next = next;
      this.prev = prev;
    }
  }

  // LancoltLista adatai, met�dusai:
  private Elem header;
  private int size;

  // Konstruktor:
  public LinkedList() {
    header = new Elem(null,null,null);
    header.next = header.prev = header;
    size = 0;
  }

  // Visszaadja a lista els� elem�t:
  public Object getFirst() {
    if (size==0)
      return null;
    return header.next.obj;
  }

  // Visszaadja a lista utols� elem�t:
  public Object getLast() {
    if (size==0)
      return null;
    return header.prev.obj;
  }

  /* Visszaadja a lista obj el�tti (el�z�) elem�t.
   * Ha obj a legels� elem, akkor null-t ad vissza:
   */
  public Object getPrev(Object obj) {
    Elem elem = elem(obj);
    if (elem == null || elem.prev == null)
      return null;
    return elem.prev.obj;
  }

  /* Visszaadja a lista obj ut�ni (k�vetkez�) elem�t.
   * Ha obj az utols� elem, akkor null-t ad vissza:
   */
  public Object getNext(Object obj) {
    Elem elem = elem(obj);
    if (elem == null || elem.next == null)
      return null;
    return elem.next.obj;
  }

  /* Visszaadja az adott index� listaelemet.
   * Ha nincs ilyen index� elem, a visszaadott �rt�k null.
   */
  public Object get(int index) {
    Elem elem = elem(index);
    if (elem == null)
      return null;
    return elem.obj;
  }

  // Visszaadja a lista m�ret�t:
  public int size() {
    return size;
  }

  // obj hozz�adja a list�hoz, a lista els� elemek�nt:
  public void addFirst(Object obj) {
    Elem newElem = new Elem(obj,header.next,header);
    header.next.prev = newElem;
    header.next = newElem;
    size++;
  }

  // obj hozz�adja a list�hoz, a lista utols� elemek�nt:
  public void addLast(Object obj) {
    Elem newElem = new Elem(obj,header,header.prev);
    header.prev.next = newElem;
    header.prev = newElem;
    size++;
  }

  // Adott index� elem t�rl�se a list�b�l. Siker eset�n a visszaadott �rt�k true:
  public boolean delete(int index) {
    Elem elem = elem(index);
    if (elem == null)
      return false;
    elem.prev.next = elem.next;
    if (elem.next != null)
      elem.next.prev = elem.prev;
    return true;
  }

  // A lista ki�r�sa konzolra:
  public void print() {
    Elem pointer = header.next;
    while (pointer != header) {
      System.out.println(pointer.obj);
      pointer = pointer.next;
    }
  }

  /* Priv�t met�dus.
   * Visszaadja obj-ot Elem t�pus� objektumk�nt.
   * Ha obj nincs a list�ban, a visszaadott �rt�k null.
   */
  private Elem elem(Object obj) {
    Elem pointer = header.next;
    while (pointer != header) {
      if (pointer.obj == obj)
        return pointer;
      pointer = pointer.next;
    }
    return null;
  }

  /* Priv�t met�dus.
   * Visszaadja a megadott index� elemet Elem t�pus� objektumk�nt.
   * Ha nincs ilyen index� elem, a visszaadott �rt�k null.
   */
  private Elem elem(int index) {
    Elem pointer = header.next;
    int counter = 0;
    while (pointer != header) {
      if (++counter == index)
        return pointer;
      pointer = pointer.next;
    }
    return null;
  }

}
