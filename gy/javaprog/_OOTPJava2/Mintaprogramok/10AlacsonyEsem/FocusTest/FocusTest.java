/*
 * Mintaprogramok/10. fejezet
 * FocusTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import extra.frame.CloseableFrame;

class FocusTestPanel extends JPanel
                               implements FocusListener {  //1
  private JTextField tf1, tf2, tf3;

  public FocusTestPanel() {
    add(tf1 = new JTextField(10));
    add(tf2 = new JTextField(10));
    add(tf3 = new JTextField(10));

    tf1.setBackground(SystemColor.LIGHT_GRAY);
    tf2.setBackground(SystemColor.LIGHT_GRAY);
    tf3.setBackground(SystemColor.LIGHT_GRAY);

    tf1.addFocusListener(this);                            //2
    tf2.addFocusListener(this);
    tf3.addFocusListener(this);
  }

  public void focusGained(FocusEvent e) {                  //3
    e.getComponent().setBackground(SystemColor.info);
  }
  public void focusLost(FocusEvent e) {                    //4
    e.getComponent().setBackground(SystemColor.LIGHT_GRAY);
  }
}

public class FocusTest extends CloseableFrame {            //5
  public FocusTest(int x, int y) {
    getContentPane().add(new FocusTestPanel());
    setLocation(x,y);
    pack();
    show();
  }
  public static void main (String args[]) {
    new FocusTest(100,100);                                //6
    new FocusTest(500,100);
  } // main
} // FocusTest
