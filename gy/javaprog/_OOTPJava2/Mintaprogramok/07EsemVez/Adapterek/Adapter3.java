/*
 * Mintaprogramok/7. fejezet
 * Adapter3.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Adapter3 extends JFrame {
  // Esetleges v�ltoz�k. A n�vtelen WindowAdapter-b�l el�rhet�k.

  public Adapter3() {
    setBounds(300,300,300,200);

    // N�vtelen oszt�ly hozz�ad�sa a figyel�l�nchoz:
    addWindowListener(new WindowAdapter() {           //1
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    show();
  }

  public static void main (String args[]) {
    new Adapter3();
  }
}
