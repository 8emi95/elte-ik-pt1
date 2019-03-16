/*
 * Mintaprogramok/10. fejezet
 * KeyTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.event.*;
import javax.swing.*;

public class KeyTest extends JFrame
                    implements KeyListener {          //1
  public KeyTest() {
    setBounds(100,100,500,100);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addKeyListener(this);                             //2
    show();
  }

  public void keyTyped(KeyEvent e) {                  //3
    setTitle(getTitle()+e.getKeyChar());
  }

  public void keyPressed(KeyEvent e) {                //4
    if (e.getKeyCode()==KeyEvent.VK_F4 &&
      e.getModifiers()==InputEvent.ALT_MASK)
      System.exit(0);
  }

  public void keyReleased(KeyEvent e) {               //5
  }

  public static void main (String args[]) {
    new KeyTest();
  } // main
} // KeyTest
