/*
 * Mintaprogramok/12. fejezet
 * Projekt: forgoegyenes
 * ForgoEgyenes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

// Az alkalmazás appletesítése:
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
