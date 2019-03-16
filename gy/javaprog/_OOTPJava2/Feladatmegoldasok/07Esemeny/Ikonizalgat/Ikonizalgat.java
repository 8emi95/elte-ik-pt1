/*
 * Feladatmegold�sok/7. fejezet
 * Ikonizalgat.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ikonizalgat extends JFrame
                         implements WindowListener {
  JLabel lbInfo = new JLabel(" ",JLabel.CENTER);
  int n = 0;

  public Ikonizalgat() {
    setBounds(400,300,300,100);
    getContentPane().add(lbInfo);
    addWindowListener(this);
    show();
  }

  public void windowOpened(WindowEvent ev) {
  }
  public void windowClosing(WindowEvent ev) {
    System.exit(0);
  }
  public void windowClosed(WindowEvent ev) {
  }
  public void windowIconified(WindowEvent ev) {
    if (n == 3)
      System.exit(0);
    lbInfo.setText(++n +"-szer ikon� v�ltoztatt�l! Csak h�rmat b�rok ki!");
  }
  public void windowDeiconified(WindowEvent ev) {
  }
  public void windowActivated(WindowEvent ev) {
  }
  public void windowDeactivated(WindowEvent ev) {
  }

  public static void main (String args[]) {
    new Ikonizalgat();
  }
}
