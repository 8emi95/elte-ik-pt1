/*
 * Feladatmegoldások/6. fejezet
 * AlulGombok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (A): Tegyen a keretbe egy szövegterületet! A keretb
 * alján legyen egy fix magasságú gombsor az angol ABC betûivel!
 */

import javax.swing.*;
import java.awt.*;

public class AlulGombok extends JFrame {
  private Container cp = getContentPane();
  private JTextArea taSzoveg = new JTextArea(30,15);
  private JPanel pnGombok = new JPanel();
  private JButton[] gombok = new JButton[26];

  public AlulGombok() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // A keret közepén a szövegterület:
    cp.add(taSzoveg);

    // A keret alján egysoros rács, rajta a gombok A-tól Z-ig:
    cp.add(pnGombok,"South");
    pnGombok.setLayout(new GridLayout(1,0));
    for (int i = 0; i < gombok.length; i++) {
      gombok[i] = new JButton(""+(char)('A'+i));
      pnGombok.add(gombok[i]);
    }

    pack();
    show();
  }

  public static void main(String[] args) {
    new AlulGombok();
  }
}
