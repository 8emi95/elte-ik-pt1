/*
 * Feladatmegold�sok/2. fejezet
 * Projekt: Hasabok
 * Hasabok.java (F�oszt�ly)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.*;
import java.util.Vector;

public class Hasabok {
  private Vector hasabok = new Vector();

  public Hasabok() {
    hasabok.add(new Hasab(2,3,10));
    hasabok.add(new Hasab());
    hasabok.add(new Kocka(3));
    hasabok.add(new Kocka());
    hasabok.add(new Hasab(2,2,4));
    hasabok.add(new Kocka(8));
    hasabok.add(new Kocka(5));
  }

  void lista(String info) {
    if (hasabok.isEmpty()) {
      System.out.println("\nNincs egyetlen has�b sem!");
      return;
    }
    System.out.println("\n"+info);
    for (int i=0; i<hasabok.size(); i++) {
      System.out.println(hasabok.get(i));
    }
  }

  void torles(int min) {
    int i = 0;
    while (i < hasabok.size()) {
      Hasab hasab = (Hasab)hasabok.get(i);
      if (hasab.terfogat()<min)
        hasabok.remove(i);
      else
        i++;
    }
  }

  int kockakSzama() {
    int kockakSzama = 0;
    for(int i=0; i < hasabok.size(); i++) {
      if (hasabok.get(i) instanceof Kocka)
        kockakSzama++;
    }
    return kockakSzama;
  }

  int nemKockaHasabokSzama() {
    int nemKockaHasabokSzama = 0;
    for (int i = 0; i < hasabok.size(); i++) {
      Object obj=hasabok.get(i);
      if (obj instanceof Hasab && !(obj instanceof Kocka))
        nemKockaHasabokSzama++;
    }
    return nemKockaHasabokSzama;
  }

  public void run() {
    // a)
    lista("Has�bok:");

    // b)
    torles(10);
    lista("Has�bok(t�rl�s ut�n):");

    // c)
    System.out.println("\n"+Hasab.getHasabokSzama()+" has�b sz�letett �sszesen");
    System.out.println(Kocka.getKockakSzama()+" kocka sz�letett �sszesen");

    // d)
    System.out.println("\nA vektorban "+kockakSzama()+" kocka van.");

    // e)
    System.out.println("\nA vektorban "+nemKockaHasabokSzama()+" hasab van, ami nem kocka.");
  }


  public static void main (String args[]) {
    new Hasabok().run();
  }
}  // Hasabok
