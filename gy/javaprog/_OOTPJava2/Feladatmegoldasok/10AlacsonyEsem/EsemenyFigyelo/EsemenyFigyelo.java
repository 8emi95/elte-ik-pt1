/*
 * Feladatmegold�sok/10. fejezet
 * EsemenyFigyelo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EsemenyFigyelo extends JFrame implements ComponentListener,
             WindowListener, KeyListener {

  private JTextArea taInfo; // Info ablak (sz�vegter�let)
  private int infoCount;    // Inform�ci�s sor sz�ml�l�

  public EsemenyFigyelo() {
    setBounds(100,100,600,500);
    setTitle("Del-Ablak t�rl�se, Ins-�j sor");
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    taInfo = new JTextArea();
    getContentPane().add(new JScrollPane(taInfo));

    // Nem keletkezhet rajta esem�ny, �gy minden a kereten keletkezik:
    taInfo.setEnabled(false);

    // A keret fog mindent figyelni:
    addComponentListener(this);
    addWindowListener(this);
    addKeyListener(this);
    show();
  }

  // �j sor hozz�ad�sa a sz�vegter�lethez:
  void info(String str) {
    taInfo.append(infoCount++ +". "+str+"\n");
  }

  // ComponentListener met�dusok:
  public void componentResized(ComponentEvent e) {
    info("�tm�reteztek! M�retem: "+getWidth()+"*"+getHeight());
  }
  public void componentMoved(ComponentEvent e) {
    info("Elmozd�tottak! Helyem: "+getX()+","+getY());
  }
  public void componentShown(ComponentEvent e) {
    // Ide nem ker�lhet a vez�rl�s, mert ha l�thatatlan, akkor
    // nem keletkezik rajta esem�ny:
    info("L�that�v� tettek!");
  }
  public void componentHidden(ComponentEvent e) {
    // Ide nem ker�lhet a vez�rl�s, mert nincs ilyen interakt�v lehet�s�g:
    info("Elrejtettek!");
  }

  // WindowListener met�dusok:
  public void windowOpened(WindowEvent e) {
    info("Megnyitottak!");
  }
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }
  public void windowClosed(WindowEvent e) {
    // Ezt m�r nem lehet kitenni az ablakba:
    System.out.println("Becsuktak!");
  }
  public void windowIconified(WindowEvent e) {
    info("Ikoniz�ltak!");
  }
  public void windowDeiconified(WindowEvent e) {
    info("Norm�lis m�ret� lettem!");
  }
  public void windowActivated(WindowEvent e) {
    info("Akt�v lettem!");
  }
  public void windowDeactivated(WindowEvent e) {
    info("Inakt�v lettem!");
  }

  // KeyListener met�dusok:
  public void keyTyped(KeyEvent e) {
    info("Le�t�ttek egy billenty�t. Kar: "+e.getKeyChar()+
      "   Mod: "+e.getKeyModifiersText(e.getModifiers()));
  }
  public void keyPressed(KeyEvent e) {
    // Info ablak t�rl�se:
    if (e.getKeyCode() == e.VK_DELETE) {
      taInfo.setText("");
    }
    // �res sor besz�r�sa az info ablakba:
    else if (e.getKeyCode() == e.VK_INSERT) {
      taInfo.append("\n");
    }
    // Ha beg�pelhet� a billenty�, a karaktert is kitessz�k:
    char c = e.getKeyChar();
    if (c==e.VK_UNDEFINED)
      c='*';
    info("Megnyomtak egy billenty�t. K�d: "+e.getKeyCode()+",   Kar: "+c+
      "   Mod: "+e.getKeyModifiersText(e.getModifiers()));
  }
  public void keyReleased(KeyEvent e) {
    char c = e.getKeyChar();
    if (c==e.VK_UNDEFINED)
      c='*';
    info("Felengedtek egy billenty�t. K�d: "+e.getKeyCode()+",   Kar: "+c+
      "   Mod: "+e.getKeyModifiersText(e.getModifiers()));
  }

  public static void main (String args[]) {
    new EsemenyFigyelo();
  } // main

} // EsemenyFigyelo
