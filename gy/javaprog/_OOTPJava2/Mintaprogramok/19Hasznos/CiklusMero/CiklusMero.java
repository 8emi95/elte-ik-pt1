/*
 * Mintaprogramok/19. fejezet
 * CiklusMero.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    // 10 milli� ciklus v�grehajt�sa ennyi id�be telik:
    System.out.println("10 milli� ciklus ideje: "+
      ciklusIdo(10000000)+" ms");
  }
}
