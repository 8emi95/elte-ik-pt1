/*
 * Mintaprogramok/17. fejezet
 * Projekt: ThreadTest
 * ThreadTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

public class ThreadTest {
  public static void main(String[] args) {
    Thread thread1 = new Thread(new Writer('1'));
    thread1.start();
    Thread thread2 = new Thread(new Writer('2'));
    thread2.start();
    new WriterThread().start(); // thread3
  }
}


/*
  �gy is lehet sz�lat l�trehozni, de ez m�r egy kicsit
  nehezen olvashat�:

  new Thread() {
   public void run() {
     while (true) {
       System.out.println("*");
       extra.util.Util.delay(2000);
     }
   }
 }.start();

*/
