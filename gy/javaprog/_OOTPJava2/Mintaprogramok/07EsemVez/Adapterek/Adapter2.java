/*
 * Mintaprogramok/7. fejezet
 * Adapter2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Adapter2 extends JFrame {
  // Esetleges v�ltoz�k. A WindowFigyelo-b�l el�rhet�k.

  // Bels� oszt�ly:
  class WindowFigyelo extends WindowAdapter {         //1
    public void windowClosing(WindowEvent ev) {
      System.exit(0);
    }
  }

  public Adapter2() {
    setBounds(300,300,300,200);
    addWindowListener(new WindowFigyelo());
    show();
  }

  public static void main (String args[]) {
    new Adapter2();
  }
}
