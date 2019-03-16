/*
 * Mintaprogramok/7. fejezet
 * Adapter1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// K�ls� oszt�ly:
class WindowFigyelo extends WindowAdapter {           //1
  public void windowClosing(WindowEvent ev) {         //2
    System.exit(0);
  }
}

public class Adapter1 extends JFrame {
  // Esetleges v�ltoz�k. A WindowFigyelo-b�l nem �rhet�k el.

  public Adapter1() {
    setBounds(300,300,300,200);
    addWindowListener(new WindowFigyelo());           //3
    show();
  }

  public static void main (String args[]) {
    new Adapter1();
  }
}
