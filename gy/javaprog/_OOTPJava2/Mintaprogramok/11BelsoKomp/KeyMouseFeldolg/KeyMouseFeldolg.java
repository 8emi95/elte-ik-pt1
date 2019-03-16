/*
 * Mintaprogramok/11. fejezet
 * KeyMouseFeldolg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyMouseFeldolg extends JFrame {
  private Container cp = getContentPane();
  private JTextArea taSzoveg = new JTextArea("",10,40);

  public KeyMouseFeldolg() {
    setLocation(200,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));
    cp.add(new JScrollPane(taSzoveg));
    taSzoveg.setEnabled(false);
    enableEvents(AWTEvent.KEY_EVENT_MASK);            //1
    enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    pack();
    show();
  }

  public void processKeyEvent(KeyEvent e) {           //2
    taSzoveg.append("Bill, id="+e.getID()+
       " karakter:"+e.getKeyChar()+"\n");
    if (e.getKeyCode() == e.VK_ESCAPE)
      System.exit(0);
    super.processKeyEvent(e);
  }

  public void processMouseEvent(MouseEvent e) {       //3
    taSzoveg.append("Egér, id="+e.getID()+
      " x="+e.getX()+" y="+e.getY()+"\n");
    super.processMouseEvent(e);
  }

  public static void main (String args[]) {
    new KeyMouseFeldolg();
  } // main
} // KeyMouseFeldolg
