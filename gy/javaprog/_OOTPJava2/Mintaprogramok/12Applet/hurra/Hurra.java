/*
 * Mintaprogramok/12. fejezet
 * Hurra.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import javax.swing.*;

public class Hurra extends JApplet {
  public void init() {
    getContentPane().add(new JLabel("Hurr�, fut az els� appletem!"));
  }
}
