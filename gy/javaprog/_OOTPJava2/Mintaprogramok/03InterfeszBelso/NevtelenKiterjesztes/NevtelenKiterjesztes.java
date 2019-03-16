/*
 * Mintaprogramok/3. fejezet
 * NevtelenKiterjesztes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

class Ember {                                            //1
  private String nev;
  public Ember(String nev) {
    this.nev = nev;
  }
  public String jellemzo() {
    return "Normális";
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
        return "Kövér";
      }
    });
    emberek.add(new Ember("Laci"));                      //4
    emberek.add(new Ember("Jenõ") {                      //5
      public String jellemzo() {
        return "Szemüveges";
      }
    });
    System.out.println(emberek);
  }
}
