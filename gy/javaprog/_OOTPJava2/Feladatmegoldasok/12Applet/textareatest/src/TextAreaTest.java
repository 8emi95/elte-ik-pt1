/*
 * Feladatmegold�sok/12. fejezet
 * Projekt: textareatest
 * TextAreaTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class Oneletrajz extends JPanel implements
                        ActionListener, DocumentListener {
  JLabel lbNev;
  JTextArea taCV; // Curriculum Vitae = �n�letrajz (latin)
  JButton btNyugtaz;
  Font fntItalic = new Font("Dialog",Font.ITALIC+Font.BOLD,12);
  Font fntNormal = new Font("Dialog",Font.PLAIN+Font.BOLD,12);

  public Oneletrajz(String nev) {
    setLayout(new BorderLayout());
    add(lbNev = new JLabel(nev),"North");
    lbNev.setFont(fntNormal);
    taCV = new JTextArea(6,30);
    taCV.setText("�n�letrajz\n\nN�v: " + nev + "\n\n");
    add(new JScrollPane(taCV));

    add(btNyugtaz = new JButton("Nyugt�z"),"South");

    taCV.getDocument().addDocumentListener(this);
    btNyugtaz.addActionListener(this);
    taCV.setCaretPosition(taCV.getText().length());
  }

  public void actionPerformed(ActionEvent ev) {
    lbNev.setFont(fntNormal);
    taCV.requestFocus();
  }

  public void insertUpdate(DocumentEvent e) {
    lbNev.setFont(fntItalic); // besz�rtak egy karaktert
  }
  public void removeUpdate(DocumentEvent e) {
    lbNev.setFont(fntItalic); // t�r�ltek egy karaktert
  }
  public void changedUpdate(DocumentEvent e) {
  }
}

public class TextAreaTest extends JApplet {                //1
  public TextAreaTest() {
    //setDefaultCloseOperation(EXIT_ON_CLOSE);
    //setTitle("�n�letrajz");
    //setLocation(300,200);
    getContentPane().add(new Oneletrajz("Dud�s Mari"));
    //pack();
    //show();
  }

  //public static void main (String args[]) {              //2
  //  new TextAreaTest();
  //} // main

} // TextAreaTest
