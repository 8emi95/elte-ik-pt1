/* 
 * Mintaprogramok/15. fejezet
 * LokalisValtozo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class LokalisValtozo {
  static public void metodus() {
    double d=1e3;
    for (int i=1; i<10; i++) { // i a metódusblokk változója
      //double d = 3.5;        // Szintaktikai hiba! d már létezik!  
      int n=10;
      int m;                      
      //System.out.println(m); // Szintaktikai hiba! m nincs inicializálva!  
      System.out.println(d+n+i);
    }
    int i=5;                   // OK, a for i-je már meghalt.
    //System.out.println(n) ;  // Szintaktikai hiba! n már nem él!
  }
  
  public static void main(String[] args) {
    metodus();
  }
}
