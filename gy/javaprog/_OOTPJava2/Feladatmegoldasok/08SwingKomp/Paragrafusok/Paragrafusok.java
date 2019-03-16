/*
 * Feladatmegoldások/8. fejezet
 * Paragrafusok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paragrafusok extends JFrame implements KeyListener {
  private Container contentPane;
  private JTextArea taPar = new JTextArea();
  private JTextArea taBe = new JTextArea();

  public Paragrafusok() {
    setBounds(200,200,500,400);
    setTitle("Paragrafusok");
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    contentPane = getContentPane();
    contentPane.setLayout(new GridLayout(2,1));
    contentPane.add(new JScrollPane(taPar));
    contentPane.add(new JScrollPane(taBe));
    taPar.setLineWrap(true);
    taBe.setLineWrap(true);
    taBe.addKeyListener(this);

    setVisible(true);
    taBe.requestFocus();
  }

  /* Az Enter leütésének lekezelése.
   * Az Enter felengedésekor kell lekezelni, mert ekkor már
   * kitette a sorvégjelet, és így az is átkerül a felsõ
   * szövegmezõbe.
   */
  public void keyPressed(KeyEvent e) {
  }
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_ENTER) {
      taPar.append(taBe.getText());
      taBe.setText("");
    }
  }
  public void keyTyped(KeyEvent e) {
  }

  public static void main(String[] args) {
    new Paragrafusok();
  }
}
