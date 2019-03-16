/*
 * Mintaprogramok/17. fejezet
 * Projekt: TermelFogyaszt
 * Termelo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
        sleep(5000); // "alv�s k�zben" termel
        int mennyiseg = (int) (Math.random() * 100) + 1;
        System.out.println("Betenn�k: " + mennyiseg);
        raktar.betesz(mennyiseg); // beteszi a rakt�rba
      }
    }
    catch (InterruptedException e) {
    }
  }
}
