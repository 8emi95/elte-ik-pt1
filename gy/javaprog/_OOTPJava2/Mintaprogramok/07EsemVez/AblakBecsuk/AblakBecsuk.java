/*
 * Mintaprogramok/7. fejezet
 * AblakBecsuk.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AblakBecsuk extends JFrame
                         implements WindowListener {       //1

  public AblakBecsuk () {
    setBounds(100,100,200,100);
    addWindowListener(this);                               //2
    show();
  }

  public void windowOpened(WindowEvent ev) {               //3
  }
  public void windowClosing(WindowEvent ev) {              //4
    System.exit(0);
  }
  public void windowClosed(WindowEvent ev) {}              //5
  public void windowIconified(WindowEvent ev) {}           //6
  public void windowDeiconified(WindowEvent ev) {}         //7
  public void windowActivated(WindowEvent ev) {}           //8
  public void windowDeactivated(WindowEvent ev) {}         //9

  public static void main (String args[]) {
    new AblakBecsuk();
  }
}
