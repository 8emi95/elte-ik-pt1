/*
 * Mintaprogramok/5. fejezet
 * SzinFont.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;

public class SzinFont extends JFrame {
  Container cp = getContentPane();

  public SzinFont() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // A keret bal fels� sarka (100,50):
    setLocation(100,50);
    // A cp tartalompanel elrendez�se sorfolytonos, sz�ne k�z�psz�rke:
    cp.setLayout(new FlowLayout());
    cp.setBackground(new Color(180,180,180));         //1

    // C�mke hozz�ad�sa a tartalompanelhez:
    JLabel lb;
    cp.add(lb = new JLabel("Sz�veg:"));
    lb.setFont(new Font("Dialog",Font.ITALIC,50));    //2
    lb.setBackground(SystemColor.info);               //3
    lb.setForeground(SystemColor.infoText);
    lb.setOpaque(true);

    // Sz�vegter�let hozz�ad�sa a tartalompanelhez:
    JTextArea ta;
    cp.add(ta = new JTextArea(5,20));
    ta.setFont(new Font("Monospaced",Font.PLAIN,40));

    // Az ablak elrendez�se �s l�that�v� t�tele:
    pack();
    show();
  }

  public static void main (String args[]) {
    Color c = SystemColor.desktop;
    System.out.println("Piros: "+c.getRed()+" Z�ld: "+c.getGreen()+" K�k: "+c.getBlue());
    new SzinFont();
  }
}
