/*
 * Feladatmegold�sok/8. fejezet
 * TukorSzoveg.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (A): Tegyen a keretbe k�t sz�vegter�letet egym�s al�!
 * Az als� sz�veg legyen mindig ugyanaz, mint a fels�!
 * Az als� sz�veget nem lehet szerkeszteni.
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
    setTitle("T�k�r sz�veg");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));
    cp.add(new JScrollPane(taSzoveg1 = new JTextArea()));
    cp.add(new JScrollPane(taSzoveg2 = new JTextArea()));
    taSzoveg1.getDocument().addDocumentListener(this);
    taSzoveg2.setEnabled(false);
    show();
  }

  // Besz�rtak egy karaktert:
  public void insertUpdate(DocumentEvent e) {
    // taSzoveg1 sz�veg�t �ttessz�k taSzoveg2-be:
    taSzoveg2.setText(taSzoveg1.getText());
  }

  // Kit�r�ltek egy karaktert:
  public void removeUpdate(DocumentEvent e) {
    taSzoveg2.setText(taSzoveg1.getText());
  }

  // JTextArea eset�n ilyen esem�ny nem keletkezik:
  public void changedUpdate(DocumentEvent e) {
  }

  public static void main(String[] args) {
    new TukorSzoveg();
  }
}
