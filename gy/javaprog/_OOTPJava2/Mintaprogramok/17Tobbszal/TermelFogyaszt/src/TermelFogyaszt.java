/*
 * Mintaprogramok/17. fejezet
 * Projekt: TermelFogyaszt
 * TermelFogyaszt.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

public class TermelFogyaszt {

  public static void main(String[] args) {
    // A raktár 1000 darabbal indul:
    Raktar raktar = new Raktar(1000);
    // A termelõ a raktárból vesz:
    Termelo termelo = new Termelo(raktar);
    // A fogyasztó a raktárból fogyaszt:
    Fogyaszto fogyaszto = new Fogyaszto(raktar);
    // Indul a gépezet:
    termelo.start();
    fogyaszto.start();
  }
}