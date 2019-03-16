/*
 * Feladatmegoldások/6. fejezet
 * IrogepFelulet.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import extra.*;

public class IrogepFelulet extends JFrame {
  Container cp = getContentPane();
  private String[] sorok = {"1234567890-=","QWERTYUIOP[]","ASDFGHJKL;","ZXCVBNM,./"};

  public IrogepFelulet () {
    setLocation(100,100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(4,1));

    // 0. sor:
    JPanel pnSor = new JPanel();
    pnSor.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    for (int n=0; n<sorok[0].length(); n++)
      pnSor.add(new JButton(""+sorok[0].charAt(n)));
    pnSor.add(new JButton("Backspace"));
    cp.add(pnSor);

    // 1. sor:
    pnSor = new JPanel();
    pnSor.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    pnSor.add(new JButton("Tab"));
    for (int n=0; n<sorok[1].length(); n++)
      pnSor.add(new JButton(""+sorok[1].charAt(n)));
    cp.add(pnSor);

    // 2. sor:
    pnSor = new JPanel();
    pnSor.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    pnSor.add(new JButton("Caps Lock"));
    for (int n=0; n<sorok[2].length(); n++)
      pnSor.add(new JButton(""+sorok[2].charAt(n)));
    pnSor.add(new JButton("Enter"));
    cp.add(pnSor);

    // 3. sor:
    pnSor = new JPanel();
    pnSor.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    pnSor.add(new JButton("Shift"));
    for (int n=0; n<sorok[3].length(); n++)
      pnSor.add(new JButton(""+sorok[3].charAt(n)));
    pnSor.add(new JButton("Shift"));
    cp.add(pnSor);

    pack();
    show();
  }

  public static void main (String args[]) {
    new IrogepFelulet();
  }
}
