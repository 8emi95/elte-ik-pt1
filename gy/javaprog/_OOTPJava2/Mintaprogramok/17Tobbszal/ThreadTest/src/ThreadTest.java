/*
 * Mintaprogramok/17. fejezet
 * Projekt: ThreadTest
 * ThreadTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
  Így is lehet szálat létrehozni, de ez már egy kicsit
  nehezen olvasható:

  new Thread() {
   public void run() {
     while (true) {
       System.out.println("*");
       extra.util.Util.delay(2000);
     }
   }
 }.start();

*/
