/*
 * Feladatmegoldások/6. fejezet
 * KetSzoveg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (A): Tegyen a keretre két egyenlõ nagyságú szövegterületet!
 *    a) A szövegterületek egymás alatt helyezkedjenek el!
 *    b) A szövegterületek egymás mellett helyezkedjenek el!
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class KetSzoveg extends JFrame {
  private Container cp = getContentPane();
  private JTextArea taSzoveg1 = new JTextArea();
  private JTextArea taSzoveg2 = new JTextArea();

  public KetSzoveg() {
    setBounds(100,100,400,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    /*
    // a) a szövegterületek egymás alatt vannak:
    cp.setLayout(new GridLayout(2,1));
    */

    // b) a szövegterületek mellett alatt vannak:
    cp.setLayout(new GridLayout(1,2));
    cp.add(taSzoveg1);
    taSzoveg1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    cp.add(taSzoveg2);
    taSzoveg2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

    show();
  }

  public static void main(String[] args) {
    new KetSzoveg();
  }
}
