/*
 * Feladatmegoldások/17. fejezet
 * Projekt: SzovegStatisztika
 * SzovegStatisztika.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

package felbukkan;

import javax.swing.JFrame;

public class Felbukkan extends JFrame implements Runnable {
  public Felbukkan() {
    setBounds(200,100,500,300);
    setTitle("Makacs vagyok. 10 percenként felbukkanok!");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void run() {
    int i=0;
    while (true) {
      setState(NORMAL);
      setVisible(true);
      System.out.println(++i +". felbukkanás");
      try {
        Thread.sleep(5*1000);
      }
      catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    Felbukkan felbukkan = new Felbukkan();
    felbukkan.show();
    new Thread(felbukkan).start();
  }
}