/* 
 * Feladatmegoldások/20. fejezet
 * Szerviz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;
import java.util.*;

class Auto implements Comparable {
  private String rendszam;
  private String tulaj;
  private float fogyasztas;

  public Auto(String rendszam, String tulaj, float fogyasztas) {
    this.rendszam = rendszam;
    this.tulaj = tulaj;
    this.fogyasztas = fogyasztas;
  }

  public boolean equals(Object obj) {
    Auto auto = (Auto)obj;
    return rendszam.equals(auto.rendszam);
  }

  public int compareTo(Object obj) {
    return tulaj.compareTo(((Auto)obj).tulaj);
  }

  public String toString() {
    return Format.left(tulaj,20)+Format.left(rendszam,10)+
      Format.right(fogyasztas,8,2);
  }
}

public class Szerviz {
  private Vector autok;

  public Szerviz() {
    autok = new Vector();
  }

  void ujAuto() {
    String rendszam = Console.readLine("Rendszam : ");
    Auto auto = new Auto(rendszam,"",0); // hasonlito objektum
    if (autok.contains(auto)) {
      System.out.println("Ilyen rendszamu auto mar letezik!");
      return;
    }
    
    String tulaj = Console.readLine("Tulajdonos : ");
    float fogyasztas = (float)(Console.readDouble("Fogyasztas : "));
    autok.add(new Auto(rendszam,tulaj,fogyasztas));
    Collections.sort(autok);
  }

  void lista() {
    if (autok.size()==0) {
      System.out.println("Nincs egyetlen auto sem!");
      return;
    }
    System.out.println("Autok listaja tulajdonos szerint rendezve:");
    for (int i=0; i<autok.size(); i++)
      System.out.println(autok.get(i));
  }

  void keres() {
    String rendszam = Console.readLine("Rendszam: ");
    Auto kerAuto = new Auto(rendszam,"",0);
    // Nem használható a binarySearch, mert a compareTo nem
    // rendszamra van megadva:
    Auto auto;
    boolean van = false;
    for (int i=0; i<autok.size(); i++) {
      auto = (Auto)(autok.get(i));
      if (auto.equals(kerAuto)) {
        System.out.println("Van ilyen auto, adatai:\n"+auto);
        van = true;
        break;
      }
    }
    if (!van)
      System.out.println("Nincs ilyen auto!");
  }

  void menu() {
    char kar;
    do {
      System.out.print("U(j auto) / L(ista) / K(eres) / V(ege) ");
      kar = Character.toUpperCase(Console.readChar());
      switch (kar) {
        case 'U' : ujAuto(); break;
        case 'L' : lista(); break;
        case 'K' : keres(); break;
      }
    } while (kar != 'V');
  }
  
  public static void main (String args[]) {
    Szerviz szerviz = new Szerviz();
    szerviz.menu();
  }
}
