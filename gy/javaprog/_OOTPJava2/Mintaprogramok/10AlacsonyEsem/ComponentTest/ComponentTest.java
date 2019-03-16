/*
 * Mintaprogramok/10. fejezet
 * ComponentTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComponentTest extends JFrame {
  public ComponentTest() {
    setBounds(100,100,200,80);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addComponentListener(new ComponentManager());     //1
    show();
    setTitle();
  }

  void setTitle() {                                   //2
    setTitle("("+getX()+","+getY()+","+
      getWidth()+","+getHeight()+")");
  }

  class ComponentManager extends ComponentAdapter {   //3
    public void componentMoved(ComponentEvent e) {
      setTitle();
      if (getX()<0)
        System.exit(0);
    }
    public void componentResized(ComponentEvent e) {
      setTitle();
    }
  }

  public static void main (String args[]) {
    new ComponentTest();
  } // main
}
