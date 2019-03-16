/*
 * Mintaprogramok/17. fejezet
 * Projekt: TermelFogyaszt
 * Fogyaszto.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

class Fogyaszto extends Thread {
  private Raktar raktar;

  public Fogyaszto(Raktar raktar) {
    this.raktar = raktar;
  }

  public void run() {
    try {
      while (true) {
        sleep(1000); // "alv�s k�zben" fogyaszt
        int mennyiseg = (int) (Math.random() * 20) + 1;
        System.out.println("Kivenn�k: " + mennyiseg);
        raktar.kivesz(mennyiseg); // kivesz a rakt�rb�l
      }
    }
    catch (InterruptedException e) {
    }
  }
}