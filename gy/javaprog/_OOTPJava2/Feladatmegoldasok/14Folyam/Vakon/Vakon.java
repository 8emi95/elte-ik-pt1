/*
 * Feladatmegold�sok/14. fejezet
 * Vakon.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Vakon extends JFrame implements KeyListener {
  private Container cp = getContentPane();
  private String fNev = "work/Vakszoveg.txt";
  private JTextArea taSzoveg = new JTextArea();
  private FileWriter out;

  public Vakon() {
    setBounds(100,100,400,200);
    setTitle("G�pel�s ellen�rz�s");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.add(new JLabel("G�pelj vakon!",JLabel.CENTER),"North");
    cp.add(new JLabel("Ctrl-Z ut�n megjelen�tem a sz�veget.",JLabel.CENTER));
    // A billenty�esem�ny a kereten keletkezik:
    addKeyListener(this);
    try {
      out = new FileWriter(fNev);
    }
    catch(IOException e) {
      System.out.println(e);
    }
    show();
  }

  // Megjelen�ti a vakon g�pelt sz�veget egy sz�vegter�leten.
  void megjelenit() {
    try {
      FileReader in = new FileReader(fNev);
      int ch;
      while ((ch = in.read()) != -1)
        taSzoveg.append(""+(char)ch);
      in.close();
    }
    catch (IOException e) {
      System.out.println("I/O hiba");
    }
    // A c�mk�ket levessz�k a tartalompanelr�l, �s feltessz�k a sz�vegter�letet:
    cp.removeAll();
    taSzoveg.setEditable(false);
    cp.add(taSzoveg);
    validate();
  }

  // A beg�pelt karaktereket elmentj�k a sz�veges �llom�nyba:
  public void keyTyped(KeyEvent e) {
    try {
      out.write(e.getKeyChar());
    }
    catch(IOException ex) {
      System.out.println(ex);
    }
  }

  // Ctrl+Z lenyom�s�ra befejez�dik a bevitel:
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_Z && e.getModifiers()==KeyEvent.CTRL_MASK) {
      removeKeyListener(this);
      try {
        out.close();
      }
      catch(IOException ex) {
        System.out.println(ex);
      }
      megjelenit();
    }
  }

  public void keyReleased(KeyEvent e) {
  }

  public static void main (String[] args) {
    new Vakon();
  } // main
} // Vakon
