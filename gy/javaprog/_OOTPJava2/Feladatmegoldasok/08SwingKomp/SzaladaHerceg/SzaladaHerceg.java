/*
 * Feladatmegoldások/8. fejezet
 * SzaladaHerceg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SzaladaHerceg extends JFrame {
  Container cp = getContentPane();

  public SzaladaHerceg() {
    setLocation(200,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.setLayout(new GridLayout(2,1));
    JLabel lbSzoveg;
    cp.add(lbSzoveg = new JLabel("Szalad a herceg",SwingConstants.CENTER));
    lbSzoveg.setFont(new Font("Arial",Font.BOLD,30));
    JPanel dukePanel = new JPanel();
    cp.add(dukePanel);
    ImageIcon iiDuke = new ImageIcon("icons/duke.running.gif");
    ImageIcon iiJava = new ImageIcon("icons/java_logo.gif");
    dukePanel.add(new JLabel("Ott a kávé! ",iiDuke,SwingConstants.LEFT));
    dukePanel.add(new JLabel(iiJava));

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent ev) {
        System.exit(0);
      }
    });

    pack();
    setVisible(true);
  }

  public static void main (String args[]) {
    new SzaladaHerceg();
  }
}
