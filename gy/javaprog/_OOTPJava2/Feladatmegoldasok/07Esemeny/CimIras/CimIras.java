/*
 * Feladatmegold�sok/7. fejezet
 * AblakMozdul.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (A): G�pelj�nk be egy sz�veget, �s jelen�ts�k meg
 * azt folyamatosan a keret c�m�ben!
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
