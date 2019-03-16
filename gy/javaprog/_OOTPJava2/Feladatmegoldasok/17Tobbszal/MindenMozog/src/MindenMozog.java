/*
 * Feladatmegoldások/17. fejezet
 * Projekt: MindenMozog
 * MindenMozog.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;

public class MindenMozog extends JFrame implements Runnable {
  int step = 1;
  int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();

  public MindenMozog() {
    setBounds(100, 100, 600, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setLayout(new GridLayout(1, 0));
    getContentPane().add(new RotatingLine(50));
    getContentPane().add(new RotatingLine(3));
    show();
  }

  public void run() {
    while (true) {
      if (getX()<0 || getX()>screenWidth-getWidth())
        step = step * (-1);
      setLocation(getX()+step, getY());
      extra.util.Util.delay(5);
    }
  }

  public static void main(String[] args) {
    new Thread(new MindenMozog()).start();
  }
}
