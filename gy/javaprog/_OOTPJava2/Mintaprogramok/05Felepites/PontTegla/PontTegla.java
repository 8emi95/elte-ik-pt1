/*
 * Mintaprogramok/5. fejezet
 * PontTegla.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;

public class PontTegla {
  public static void main (String args[]) {
    // r1 bal felsõ sarka (100,100), mérete 50x30:
    Rectangle r1 = new Rectangle(100,100,50,30);
    // r2 bal felsõ sarka (120,80), mérete 20x60:
    Rectangle r2 = new Rectangle();
    r2.setLocation(120,80);
    r2.setSize(20,60);

    // r1 és r2 közös részének meghatározása:
    Rectangle kozos = r1.intersection(r2);
    System.out.println("Közös: "+kozos);

    // A p pont koordinátái: (130,110):
    Point p = new Point(130,110);
    // Benne van a pont?
    if (kozos.contains(p))
      System.out.println(p+" benne van");
    else
      System.out.println(p+" nincs benne");

    // Pontsorozat megadása:
    Point[] pontok = {new Point(50,80),new Point(15,70),
      new Point(30,95),new Point(120,200)};

    // r1 és r2 téglák egyesítése, majd a pontok hozzáadása:
    Rectangle nagy = r1.union(r2);
    for (int i=0; i<pontok.length; i++)
      nagy.add(pontok[i]);
    System.out.println("Nagy: "+nagy);
    System.out.println("Nagy mérete: "+nagy.getSize());
  }
}
