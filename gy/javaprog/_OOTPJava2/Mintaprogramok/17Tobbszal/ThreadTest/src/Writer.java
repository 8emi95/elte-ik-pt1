/*
 * Mintaprogramok/17. fejezet
 * Projekt: ThreadTest
 * Writer.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

public class Writer implements Runnable {
  char c;
  public Writer(char c) {
    this.c = c;
  }
  public void run() {                                    //1
    while (true) {
      System.out.print(c);
      try {
        Thread.sleep(50);                                //2
      }
      catch (InterruptedException ie) {
      }
    }
  }
}
