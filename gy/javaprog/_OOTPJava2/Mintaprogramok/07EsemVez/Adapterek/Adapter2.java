/*
 * Mintaprogramok/7. fejezet
 * Adapter2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Adapter2 extends JFrame {
  // Esetleges változók. A WindowFigyelo-bõl elérhetõk.

  // Belsõ osztály:
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
