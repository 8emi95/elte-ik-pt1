/*
 * Mintaprogramok/3. fejezet
 * NevtelenKiterjesztes.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

class Ember {                                            //1
  private String nev;
  public Ember(String nev) {
    this.nev = nev;
  }
  public String jellemzo() {
    return "Norm�lis";
  }
  public String toString() {
    return nev + " ("+jellemzo()+")";
  }
}

public class NevtelenKiterjesztes {
  public static void main(String[] args) {
    Vector emberek = new Vector();
    emberek.add(new Ember("Zoli") {                      //2
      public String jellemzo() {                         //3
        return "K�v�r";
      }
    });
    emberek.add(new Ember("Laci"));                      //4
    emberek.add(new Ember("Jen�") {                      //5
      public String jellemzo() {
        return "Szem�veges";
      }
    });
    System.out.println(emberek);
  }
}
