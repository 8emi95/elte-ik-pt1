/*
 * Feladatmegoldások/5. fejezet
 * IdeNezz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class IdeNezz extends JFrame {

  public IdeNezz() {
    setLocation (100,50);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    Container cp = getContentPane();
    JLabel lb;
    cp.setBackground(Color.black);
    cp.add(lb = new JLabel("Ide nézz!"));
    lb.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC,32));
    lb.setForeground(new Color(200,255,200));
    pack();
    show();
  }

  public static void main (String args[]) {
    new IdeNezz();
  }
}
