/*
 * Feladatmegoldások/9. fejezet
 * PacMen.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Egy kis plusz. Ezek a csámcsogáshoz kellenek:

public class PacMen extends JFrame {

  public PacMen() {
    setTitle("Hungry PacMen in Hungary");
    setBounds(100,100,500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = getContentPane();

    cp.setLayout(new GridLayout(0,1));
    cp.add(new PacMan(15,Color.black,20));
    cp.add(new PacMan(20,Color.red,60));
    cp.add(new PacMan(10,Color.blue,40));

    show();
  }

  public static void main (String args[]) {
    new PacMen();
  }
}
