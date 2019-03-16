/*
 * Mintaprogramok/17. fejezet
 * Projekt: ThreadTest
 * WriterThread.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
