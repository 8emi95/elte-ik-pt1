/*
 * Mintaprogramok/19. fejezet
 * CiklusMero.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

public class CiklusMero {
  static long ciklusIdo(long ciklusSzam) {
    long kezdIdo = System.currentTimeMillis();
    for (long i=0; i<ciklusSzam; i++);
    long vegIdo = System.currentTimeMillis();
    return vegIdo-kezdIdo;
  }

  public static void main(String[] args) {
    // 10 millió ciklus végrehajtása ennyi idõbe telik:
    System.out.println("10 millió ciklus ideje: "+
      ciklusIdo(10000000)+" ms");
  }
}
