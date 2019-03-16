/*
 * Feladatmegoldások/14. fejezet
 * Vakon.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
    setTitle("Gépelés ellenõrzés");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.add(new JLabel("Gépelj vakon!",JLabel.CENTER),"North");
    cp.add(new JLabel("Ctrl-Z után megjelenítem a szöveget.",JLabel.CENTER));
    // A billentyûesemény a kereten keletkezik:
    addKeyListener(this);
    try {
      out = new FileWriter(fNev);
    }
    catch(IOException e) {
      System.out.println(e);
    }
    show();
  }

  // Megjeleníti a vakon gépelt szöveget egy szövegterületen.
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
    // A címkéket levesszük a tartalompanelrõl, és feltesszük a szövegterületet:
    cp.removeAll();
    taSzoveg.setEditable(false);
    cp.add(taSzoveg);
    validate();
  }

  // A begépelt karaktereket elmentjük a szöveges állományba:
  public void keyTyped(KeyEvent e) {
    try {
      out.write(e.getKeyChar());
    }
    catch(IOException ex) {
      System.out.println(ex);
    }
  }

  // Ctrl+Z lenyomására befejezõdik a bevitel:
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
