/*
 * Mintaprogramok/12. fejezet
 * Projekt: forgoegyenes
 * ForgoEgyenes.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

// Az alkalmaz�s appletes�t�se:
import javax.swing.*;

public class ForgoEgyenes extends /*JFrame*/ JApplet {
  public void init() /*ForgoEgyenes()*/ {
    //setBounds(100,100,300,300);
    //setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(new Rajzlap());
    //show();
  }

  //public static void main (String args[]) {
  //  new ForgoEgyenes();
  //}
}
