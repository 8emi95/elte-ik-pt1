/* 
 * Mintaprogramok/15. fejezet
 * LokalisValtozo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class LokalisValtozo {
  static public void metodus() {
    double d=1e3;
    for (int i=1; i<10; i++) { // i a met�dusblokk v�ltoz�ja
      //double d = 3.5;        // Szintaktikai hiba! d m�r l�tezik!  
      int n=10;
      int m;                      
      //System.out.println(m); // Szintaktikai hiba! m nincs inicializ�lva!  
      System.out.println(d+n+i);
    }
    int i=5;                   // OK, a for i-je m�r meghalt.
    //System.out.println(n) ;  // Szintaktikai hiba! n m�r nem �l!
  }
  
  public static void main(String[] args) {
    metodus();
  }
}
