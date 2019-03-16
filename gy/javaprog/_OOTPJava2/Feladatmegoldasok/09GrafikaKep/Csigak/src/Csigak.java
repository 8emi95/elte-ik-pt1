/*
 * Feladatmegoldások/9. fejezet
 * Csigak.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class Csigak extends JFrame {
  public Csigak() {
    setBounds(100,100,500,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(2,2));
    cp.add(new Csiga(3,0.1,Color.black));
    cp.add(new Csiga(1,0.02,Color.white));
    cp.add(new Csiga(2,0.05,Color.blue));
    cp.add(new Csiga(3,0.05,Color.red));
    show();
  }

  public static void main (String args[]) {
    new Csigak();
  }
}
