/*
 * Mintaprogramok/10. fejezet
 * MouseTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTest extends JFrame implements
                     MouseListener, MouseMotionListener {  //1
  private int exitSzam;

  public MouseTest() {
    setTitle("MouseTest");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0,0,300,150);
    addMouseListener(this);                                //2
    addMouseMotionListener(this);
    show();
  }

  void drawString(String str,int x, int y) {               //3
    Graphics gr = this.getGraphics();
    gr.clearRect(0,0,getWidth(),getHeight());
    gr.drawString(str,x,y);
    gr.dispose();
  }

  String melyikGomb(MouseEvent e) {                        //4
    if (e.getModifiers()==e.BUTTON1_MASK)
      return "Bal";
    else if (e.getModifiers()==e.BUTTON2_MASK)
      return "Középsõ";
    else if (e.getModifiers()==e.BUTTON3_MASK)
      return "Jobb";
    return "";
  }

  // Egyszerû egéresemények:
  public void mouseClicked(MouseEvent e) {                 //5
    drawString(melyikGomb(e)+" gombon "+
      e.getClickCount()+"-t kattintottál",e.getX(),e.getY());
  }

  public void mousePressed(MouseEvent e) {                 //6
    drawString(melyikGomb(e)+" gombot megnyomtad",
                    e.getX(),e.getY());
  }

  public void mouseReleased(MouseEvent e) {                //7
    drawString(melyikGomb(e)+" gombot felengedted",
                    e.getX(),e.getY());
  }

  public void mouseEntered(MouseEvent e) {                 //8
  }

  public void mouseExited(MouseEvent e) {                  //9
    if (++exitSzam==5)
      System.exit(0);
    drawString(exitSzam+
      "!  Ha ötödször is elhagysz, én is elhagylak!",20,50);
  }

  // Egérmozgás-események:
  public void mouseDragged(MouseEvent e) {                //10
    drawString(melyikGomb(e)+" gombbal vonszoltad",
                    e.getX(),e.getY());
  }

  public void mouseMoved(MouseEvent e) {                  //11
    drawString("Elmozgattad",e.getX(),e.getY());
  }

  public static void main (String args[]) {
    new MouseTest();
  } // main
} // MouseTest
