/*
 * Mintaprogramok/17. fejezet
 * Projekt: TermelFogyaszt
 * Fogyaszto.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
        sleep(1000); // "alvás közben" fogyaszt
        int mennyiseg = (int) (Math.random() * 20) + 1;
        System.out.println("Kivennék: " + mennyiseg);
        raktar.kivesz(mennyiseg); // kivesz a raktárból
      }
    }
    catch (InterruptedException e) {
    }
  }
}