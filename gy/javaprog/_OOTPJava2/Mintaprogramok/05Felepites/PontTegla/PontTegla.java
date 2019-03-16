/*
 * Mintaprogramok/5. fejezet
 * PontTegla.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;

public class PontTegla {
  public static void main (String args[]) {
    // r1 bal fels� sarka (100,100), m�rete 50x30:
    Rectangle r1 = new Rectangle(100,100,50,30);
    // r2 bal fels� sarka (120,80), m�rete 20x60:
    Rectangle r2 = new Rectangle();
    r2.setLocation(120,80);
    r2.setSize(20,60);

    // r1 �s r2 k�z�s r�sz�nek meghat�roz�sa:
    Rectangle kozos = r1.intersection(r2);
    System.out.println("K�z�s: "+kozos);

    // A p pont koordin�t�i: (130,110):
    Point p = new Point(130,110);
    // Benne van a pont?
    if (kozos.contains(p))
      System.out.println(p+" benne van");
    else
      System.out.println(p+" nincs benne");

    // Pontsorozat megad�sa:
    Point[] pontok = {new Point(50,80),new Point(15,70),
      new Point(30,95),new Point(120,200)};

    // r1 �s r2 t�gl�k egyes�t�se, majd a pontok hozz�ad�sa:
    Rectangle nagy = r1.union(r2);
    for (int i=0; i<pontok.length; i++)
      nagy.add(pontok[i]);
    System.out.println("Nagy: "+nagy);
    System.out.println("Nagy m�rete: "+nagy.getSize());
  }
}
