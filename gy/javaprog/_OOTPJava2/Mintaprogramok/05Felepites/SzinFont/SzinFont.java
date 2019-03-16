/*
 * Mintaprogramok/5. fejezet
 * SzinFont.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;

public class SzinFont extends JFrame {
  Container cp = getContentPane();

  public SzinFont() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // A keret bal felsõ sarka (100,50):
    setLocation(100,50);
    // A cp tartalompanel elrendezése sorfolytonos, színe középszürke:
    cp.setLayout(new FlowLayout());
    cp.setBackground(new Color(180,180,180));         //1

    // Címke hozzáadása a tartalompanelhez:
    JLabel lb;
    cp.add(lb = new JLabel("Szöveg:"));
    lb.setFont(new Font("Dialog",Font.ITALIC,50));    //2
    lb.setBackground(SystemColor.info);               //3
    lb.setForeground(SystemColor.infoText);
    lb.setOpaque(true);

    // Szövegterület hozzáadása a tartalompanelhez:
    JTextArea ta;
    cp.add(ta = new JTextArea(5,20));
    ta.setFont(new Font("Monospaced",Font.PLAIN,40));

    // Az ablak elrendezése és láthatóvá tétele:
    pack();
    show();
  }

  public static void main (String args[]) {
    Color c = SystemColor.desktop;
    System.out.println("Piros: "+c.getRed()+" Zöld: "+c.getGreen()+" Kék: "+c.getBlue());
    new SzinFont();
  }
}
