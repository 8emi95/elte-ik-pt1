/*
 * Mintaprogramok/7. fejezet
 * Adapter3.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Adapter3 extends JFrame {
  // Esetleges változók. A névtelen WindowAdapter-bõl elérhetõk.

  public Adapter3() {
    setBounds(300,300,300,200);

    // Névtelen osztály hozzáadása a figyelõlánchoz:
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
