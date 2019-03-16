/*
 * Feladatmegoldások/10. fejezet
 * HangosFokusz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HangosFokusz extends JFrame implements FocusListener {
  private Container cp = getContentPane();

  public HangosFokusz() {
     setLocation(200,200);
     setResizable(false);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     getContentPane().setLayout(new GridLayout(1,0));
     JButton bt;
     for (int i=0; i<5; i++) {
       cp.add(bt=new JButton(""+i));
       bt.addFocusListener(this);
     }
     pack();
     show();
  }

  public void focusGained(FocusEvent e) {
    Toolkit.getDefaultToolkit().beep();
  }

  public void focusLost(FocusEvent e) {
  }

  public static void main (String args[]) {
    new HangosFokusz();
  } // main
} // HangosFokusz
