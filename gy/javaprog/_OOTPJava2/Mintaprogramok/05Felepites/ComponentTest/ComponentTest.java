/*
 * Mintaprogramok/5. fejezet
 * ComponentTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;

public class ComponentTest extends JFrame {
  Container cp = getContentPane();
  JTextField tf1, tf2;
  JButton bt;

  public ComponentTest() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(200,100);
    cp.setLayout(new GridLayout(3,1));  // Rácsos elrendezés

    // 1. szövegmezõ létrehozása, egérkurzorának beállítása:
    cp.add(tf1 = new JTextField("Ha fölém kerülsz, kézzé válsz."));
    tf1.setCursor(new Cursor(Cursor.HAND_CURSOR));

    // 2. szövegmezõ létrehozása:
    cp.add(tf2 = new JTextField("Kezdetben itt a fókusz"));

    // A nyomógomb létrehozása és érzéketlenné változtatása:
    cp.add(bt = new JButton("Hiába nyomsz!"));
    bt.setEnabled(false);
    show();

    // Fókuszálás. Csak a show() után van hatása:
    tf2.requestFocus();
  }

  public static void main (String args[]) {
    JFrame fr = new ComponentTest();
    // Kilistázzuk a cp tartalmát:
    fr.getContentPane().list();
  }
}
