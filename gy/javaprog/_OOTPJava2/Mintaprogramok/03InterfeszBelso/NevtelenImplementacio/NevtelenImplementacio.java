/*
 * Mintaprogramok/3. fejezet
 * NevtelenImplementacio.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

interface Jellemzett {
  public String jellemzo();
}

public class NevtelenImplementacio {
  public static void main(String[] args) {
    Vector jellemzettek = new Vector();
    jellemzettek.add(new Jellemzett() {
      public String jellemzo() {
        return "Csunya";
      }
    });
    jellemzettek.add(new Jellemzett() {
      public String jellemzo() {
        return "Szep";
      }
    });

    for (int i=0; i<jellemzettek.size(); i++) {
      Jellemzett jel =
        (Jellemzett)jellemzettek.get(i);
      System.out.println(jel.jellemzo());
    }
  }
}
