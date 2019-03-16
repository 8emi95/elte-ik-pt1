/*
 * Mintaprogramok/17. fejezet
 * Projekt: TermelFogyaszt
 * Termelo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

public class Termelo extends Thread {
  private Raktar raktar;

  public Termelo (Raktar raktar) {
    this.raktar=raktar;
  }

  public void run() {
    try {
      while (true) {
        sleep(5000); // "alvás közben" termel
        int mennyiseg = (int) (Math.random() * 100) + 1;
        System.out.println("Betennék: " + mennyiseg);
        raktar.betesz(mennyiseg); // beteszi a raktárba
      }
    }
    catch (InterruptedException e) {
    }
  }
}
