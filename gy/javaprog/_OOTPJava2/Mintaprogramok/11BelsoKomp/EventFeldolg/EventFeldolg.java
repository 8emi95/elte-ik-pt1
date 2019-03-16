/*
 * Mintaprogramok/11. fejezet
 * EventFeldolg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventFeldolg extends JFrame {
  private Container cp = getContentPane();
  private JTextArea taSzoveg = new JTextArea("",10,40);

  public EventFeldolg() {
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));
    cp.add(new JScrollPane(taSzoveg));
    taSzoveg.setEnabled(false);
    enableEvents(AWTEvent.KEY_EVENT_MASK);
    enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    pack();
    show();
  }

  public void processEvent(AWTEvent e) {
    if (e instanceof KeyEvent) {
      KeyEvent ke = (KeyEvent)e;
      taSzoveg.append("Bill, id="+ke.getID()+
                      " karakter:"+ke.getKeyChar()+"\n");
      if (ke.getKeyCode() == ke.VK_ESCAPE)
        System.exit(0);
    }
    else if (e instanceof MouseEvent) {
      MouseEvent me = (MouseEvent)e;
      if (me.getID()!=MouseEvent.MOUSE_DRAGGED &&
          me.getID()!=MouseEvent.MOUSE_MOVED) {
        taSzoveg.append("Egér, id="+me.getID()+
                        " x="+me.getX()+" y="+me.getY()+"\n");
      }
    }
    super.processEvent(e);
  }

  public static void main (String args[]) {
    new EventFeldolg();
  } // main
} // EventFeldolg
