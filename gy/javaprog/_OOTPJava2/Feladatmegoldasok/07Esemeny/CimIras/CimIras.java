/*
 * Feladatmegoldások/7. fejezet
 * AblakMozdul.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (A): Gépeljünk be egy szöveget, és jelenítsük meg
 * azt folyamatosan a keret címében!
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CimIras extends JFrame {

  public CimIras() {
    setSize(500,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        setTitle(getTitle()+e.getKeyChar());
      }
    });
    show();
  }

public static void main(String[] args) {
    new CimIras();
  }
}
