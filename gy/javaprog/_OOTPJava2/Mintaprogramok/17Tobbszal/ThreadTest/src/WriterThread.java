/*
 * Mintaprogramok/17. fejezet
 * Projekt: ThreadTest
 * WriterThread.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

public class WriterThread extends Thread {
  public void run() {
    while (true) {
      System.out.println();
      try {
        Thread.sleep(100);
      }
      catch (InterruptedException ie) {
      }
    }
  }
}
