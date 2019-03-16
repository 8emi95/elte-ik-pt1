/*
 * Feladatmegold�sok/6. fejezet
 * AlulGombok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (A): Tegyen a keretbe egy sz�vegter�letet! A keretb
 * alj�n legyen egy fix magass�g� gombsor az angol ABC bet�ivel!
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

    // A keret k�zep�n a sz�vegter�let:
    cp.add(taSzoveg);

    // A keret alj�n egysoros r�cs, rajta a gombok A-t�l Z-ig:
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
