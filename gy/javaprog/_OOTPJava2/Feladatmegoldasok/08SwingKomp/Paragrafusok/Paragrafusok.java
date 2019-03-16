/*
 * Feladatmegold�sok/8. fejezet
 * Paragrafusok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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

  /* Az Enter le�t�s�nek lekezel�se.
   * Az Enter felenged�sekor kell lekezelni, mert ekkor m�r
   * kitette a sorv�gjelet, �s �gy az is �tker�l a fels�
   * sz�vegmez�be.
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
