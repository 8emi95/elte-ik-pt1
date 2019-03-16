/*
 * Mintaprogramok/5. fejezet
 * ComponentTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    cp.setLayout(new GridLayout(3,1));  // R�csos elrendez�s

    // 1. sz�vegmez� l�trehoz�sa, eg�rkurzor�nak be�ll�t�sa:
    cp.add(tf1 = new JTextField("Ha f�l�m ker�lsz, k�zz� v�lsz."));
    tf1.setCursor(new Cursor(Cursor.HAND_CURSOR));

    // 2. sz�vegmez� l�trehoz�sa:
    cp.add(tf2 = new JTextField("Kezdetben itt a f�kusz"));

    // A nyom�gomb l�trehoz�sa �s �rz�ketlenn� v�ltoztat�sa:
    cp.add(bt = new JButton("Hi�ba nyomsz!"));
    bt.setEnabled(false);
    show();

    // F�kusz�l�s. Csak a show() ut�n van hat�sa:
    tf2.requestFocus();
  }

  public static void main (String args[]) {
    JFrame fr = new ComponentTest();
    // Kilist�zzuk a cp tartalm�t:
    fr.getContentPane().list();
  }
}
