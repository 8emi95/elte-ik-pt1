/*
 * Feladatmegoldások/8. fejezet
 * TukorSzoveg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (A): Tegyen a keretbe két szövegterületet egymás alá!
 * Az alsó szöveg legyen mindig ugyanaz, mint a felsõ!
 * Az alsõ szöveget nem lehet szerkeszteni.
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class TukorSzoveg extends JFrame implements DocumentListener {
  private Container cp = getContentPane();
  private JTextArea taSzoveg1, taSzoveg2;

  public TukorSzoveg() {
    setBounds(300,200,400,400);
    setTitle("Tükör szöveg");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));
    cp.add(new JScrollPane(taSzoveg1 = new JTextArea()));
    cp.add(new JScrollPane(taSzoveg2 = new JTextArea()));
    taSzoveg1.getDocument().addDocumentListener(this);
    taSzoveg2.setEnabled(false);
    show();
  }

  // Beszúrtak egy karaktert:
  public void insertUpdate(DocumentEvent e) {
    // taSzoveg1 szövegét áttesszük taSzoveg2-be:
    taSzoveg2.setText(taSzoveg1.getText());
  }

  // Kitöröltek egy karaktert:
  public void removeUpdate(DocumentEvent e) {
    taSzoveg2.setText(taSzoveg1.getText());
  }

  // JTextArea esetén ilyen esemény nem keletkezik:
  public void changedUpdate(DocumentEvent e) {
  }

  public static void main(String[] args) {
    new TukorSzoveg();
  }
}
