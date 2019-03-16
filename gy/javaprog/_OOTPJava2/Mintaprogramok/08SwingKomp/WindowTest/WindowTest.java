/*
 * Mintaprogramok/8. fejezet
 * WindowTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Ez a feladat nincs a könyvben.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowTest extends JFrame {
  JWindow win;

  public WindowTest() {
    setTitle("Ablak teszt");
    setBounds(100,100,200,100);
    win = new JWindow(this);
    win.getContentPane().add(new JLabel(new ImageIcon("icons/bivaly.gif")));

    win.setBounds(500,200,300,200);
    win.show();
    win.pack();
    show();
  }

  public static void main (String args[]) {
    new WindowTest();
  } // main
}
