/*
 * Mintaprogramok/12. fejezet
 * Hurra.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;

public class Hurra extends JApplet {
  public void init() {
    getContentPane().add(new JLabel("Hurrá, fut az elsõ appletem!"));
  }
}
