/*
 * Feladatmegoldások/20. fejezet
 * LinkedList.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2003.04.01.
 */

public class LinkedList {

  // Egy elemet reprezentáló belsõ osztály:
  class Elem {
    private Object obj;
    private Elem next, prev;

    public Elem(Object obj, Elem next, Elem prev) {
      this.obj = obj;
      this.next = next;
      this.prev = prev;
    }
  }

  // LancoltLista adatai, metódusai:
  private Elem header;
  private int size;

  // Konstruktor:
  public LinkedList() {
    header = new Elem(null,null,null);
    header.next = header.prev = header;
    size = 0;
  }

  // Visszaadja a lista elsõ elemét:
  public Object getFirst() {
    if (size==0)
      return null;
    return header.next.obj;
  }

  // Visszaadja a lista utolsó elemét:
  public Object getLast() {
    if (size==0)
      return null;
    return header.prev.obj;
  }

  /* Visszaadja a lista obj elõtti (elõzõ) elemét.
   * Ha obj a legelsõ elem, akkor null-t ad vissza:
   */
  public Object getPrev(Object obj) {
    Elem elem = elem(obj);
    if (elem == null || elem.prev == null)
      return null;
    return elem.prev.obj;
  }

  /* Visszaadja a lista obj utáni (következõ) elemét.
   * Ha obj az utolsó elem, akkor null-t ad vissza:
   */
  public Object getNext(Object obj) {
    Elem elem = elem(obj);
    if (elem == null || elem.next == null)
      return null;
    return elem.next.obj;
  }

  /* Visszaadja az adott indexû listaelemet.
   * Ha nincs ilyen indexû elem, a visszaadott érték null.
   */
  public Object get(int index) {
    Elem elem = elem(index);
    if (elem == null)
      return null;
    return elem.obj;
  }

  // Visszaadja a lista méretét:
  public int size() {
    return size;
  }

  // obj hozzáadja a listához, a lista elsõ elemeként:
  public void addFirst(Object obj) {
    Elem newElem = new Elem(obj,header.next,header);
    header.next.prev = newElem;
    header.next = newElem;
    size++;
  }

  // obj hozzáadja a listához, a lista utolsó elemeként:
  public void addLast(Object obj) {
    Elem newElem = new Elem(obj,header,header.prev);
    header.prev.next = newElem;
    header.prev = newElem;
    size++;
  }

  // Adott indexû elem törlése a listából. Siker esetén a visszaadott érték true:
  public boolean delete(int index) {
    Elem elem = elem(index);
    if (elem == null)
      return false;
    elem.prev.next = elem.next;
    if (elem.next != null)
      elem.next.prev = elem.prev;
    return true;
  }

  // A lista kiírása konzolra:
  public void print() {
    Elem pointer = header.next;
    while (pointer != header) {
      System.out.println(pointer.obj);
      pointer = pointer.next;
    }
  }

  /* Privát metódus.
   * Visszaadja obj-ot Elem típusú objektumként.
   * Ha obj nincs a listában, a visszaadott érték null.
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

  /* Privát metódus.
   * Visszaadja a megadott indexû elemet Elem típusú objektumként.
   * Ha nincs ilyen indexû elem, a visszaadott érték null.
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
