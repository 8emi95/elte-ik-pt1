/*
 * Mintaprogramok/17. fejezet
 * Projekt: TermelFogyaszt
 * TermelFogyaszt.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

public class TermelFogyaszt {

  public static void main(String[] args) {
    // A rakt�r 1000 darabbal indul:
    Raktar raktar = new Raktar(1000);
    // A termel� a rakt�rb�l vesz:
    Termelo termelo = new Termelo(raktar);
    // A fogyaszt� a rakt�rb�l fogyaszt:
    Fogyaszto fogyaszto = new Fogyaszto(raktar);
    // Indul a g�pezet:
    termelo.start();
    fogyaszto.start();
  }
}