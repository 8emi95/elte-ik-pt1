/*
 * Feladatmegold�sok/9. fejezet
 * ForgoEgyenes.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;

public class ForgoEgyenes extends JFrame {
  public ForgoEgyenes() {
    setBounds(100,100,300,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(new Rajzlap());

    show();
  }

  public static void main (String args[]) {
    new ForgoEgyenes();
  }
}
