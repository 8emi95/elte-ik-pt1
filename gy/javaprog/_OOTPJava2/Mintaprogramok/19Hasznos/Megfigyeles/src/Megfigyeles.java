/*
 * Mintaprogramok/19. fejezet
 * Projekt: Megfigyeles
 * Csomag: -
 * Megfigyeles.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import gui.*;
import db.BetuStatisztika;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.text.Document;

public class Megfigyeles extends JFrame
                                 implements DocumentListener {
  private Container cp = getContentPane();
  private JTextArea taSzoveg = new JTextArea("",5,20);
  private BetuStatisztika betuStatisztika = new BetuStatisztika();
  private LeutesekSzamaKijelzo leutesekSzamaKijelzo = new LeutesekSzamaKijelzo();
  private BetukSzamaKijelzo betukSzamaKijelzo = new BetukSzamaKijelzo();

  public Megfigyeles() {
    setLocation(150,150);
    cp.add(betukSzamaKijelzo,"North");
    cp.add(new JScrollPane(taSzoveg),"Center");
    cp.add(leutesekSzamaKijelzo,"South");
    betuStatisztika.addObserver(betukSzamaKijelzo);
    betuStatisztika.addObserver(leutesekSzamaKijelzo);
    taSzoveg.setFont(new Font("Dialog",Font.PLAIN,20));
    taSzoveg.getDocument().addDocumentListener(this);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    pack();
    show();
  }

  void update(DocumentEvent e) {
    Document d = e.getDocument();
    try {
      betuStatisztika.stat(d.getText(0,d.getLength()));
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }

  public void insertUpdate(DocumentEvent e) {
    update(e);
  }
  public void removeUpdate(DocumentEvent e) {
    update(e);
  }
  public void changedUpdate(DocumentEvent e) {
  }

  public static void main(String[] args) {
    new Megfigyeles();
  }
}
