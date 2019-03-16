/*
 * Feladatmegoldások/10. fejezet
 * EsemenyFigyelo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EsemenyFigyelo extends JFrame implements ComponentListener,
             WindowListener, KeyListener {

  private JTextArea taInfo; // Info ablak (szövegterület)
  private int infoCount;    // Információs sor számláló

  public EsemenyFigyelo() {
    setBounds(100,100,600,500);
    setTitle("Del-Ablak törlése, Ins-Új sor");
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    taInfo = new JTextArea();
    getContentPane().add(new JScrollPane(taInfo));

    // Nem keletkezhet rajta esemény, így minden a kereten keletkezik:
    taInfo.setEnabled(false);

    // A keret fog mindent figyelni:
    addComponentListener(this);
    addWindowListener(this);
    addKeyListener(this);
    show();
  }

  // Új sor hozzáadása a szövegterülethez:
  void info(String str) {
    taInfo.append(infoCount++ +". "+str+"\n");
  }

  // ComponentListener metódusok:
  public void componentResized(ComponentEvent e) {
    info("Átméreteztek! Méretem: "+getWidth()+"*"+getHeight());
  }
  public void componentMoved(ComponentEvent e) {
    info("Elmozdítottak! Helyem: "+getX()+","+getY());
  }
  public void componentShown(ComponentEvent e) {
    // Ide nem kerülhet a vezérlés, mert ha láthatatlan, akkor
    // nem keletkezik rajta esemény:
    info("Láthatóvá tettek!");
  }
  public void componentHidden(ComponentEvent e) {
    // Ide nem kerülhet a vezérlés, mert nincs ilyen interaktív lehetõség:
    info("Elrejtettek!");
  }

  // WindowListener metódusok:
  public void windowOpened(WindowEvent e) {
    info("Megnyitottak!");
  }
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }
  public void windowClosed(WindowEvent e) {
    // Ezt már nem lehet kitenni az ablakba:
    System.out.println("Becsuktak!");
  }
  public void windowIconified(WindowEvent e) {
    info("Ikonizáltak!");
  }
  public void windowDeiconified(WindowEvent e) {
    info("Normális méretû lettem!");
  }
  public void windowActivated(WindowEvent e) {
    info("Aktív lettem!");
  }
  public void windowDeactivated(WindowEvent e) {
    info("Inaktív lettem!");
  }

  // KeyListener metódusok:
  public void keyTyped(KeyEvent e) {
    info("Leütöttek egy billentyût. Kar: "+e.getKeyChar()+
      "   Mod: "+e.getKeyModifiersText(e.getModifiers()));
  }
  public void keyPressed(KeyEvent e) {
    // Info ablak törlése:
    if (e.getKeyCode() == e.VK_DELETE) {
      taInfo.setText("");
    }
    // Üres sor beszúrása az info ablakba:
    else if (e.getKeyCode() == e.VK_INSERT) {
      taInfo.append("\n");
    }
    // Ha begépelhetõ a billentyû, a karaktert is kitesszük:
    char c = e.getKeyChar();
    if (c==e.VK_UNDEFINED)
      c='*';
    info("Megnyomtak egy billentyût. Kód: "+e.getKeyCode()+",   Kar: "+c+
      "   Mod: "+e.getKeyModifiersText(e.getModifiers()));
  }
  public void keyReleased(KeyEvent e) {
    char c = e.getKeyChar();
    if (c==e.VK_UNDEFINED)
      c='*';
    info("Felengedtek egy billentyût. Kód: "+e.getKeyCode()+",   Kar: "+c+
      "   Mod: "+e.getKeyModifiersText(e.getModifiers()));
  }

  public static void main (String args[]) {
    new EsemenyFigyelo();
  } // main

} // EsemenyFigyelo
