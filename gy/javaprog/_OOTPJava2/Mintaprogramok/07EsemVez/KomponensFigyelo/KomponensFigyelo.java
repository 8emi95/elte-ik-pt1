/*
 * Mintaprogramok/7. fejezet
 * KomponensFigyelo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KomponensFigyelo extends JFrame
                              implements ComponentListener {
  private JLabel lbInfo;

  public KomponensFigyelo () {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(lbInfo =
          new JLabel(" ",JLabel.CENTER));              //1
    addComponentListener(this);                        //2
    pack();
    show();
  }

  public void componentResized(ComponentEvent ev) {    //3
    lbInfo.setText("�tm�reteztek!");
  }

  public void componentMoved(ComponentEvent ev) {      //4
    lbInfo.setText("Elmozd�tottak!");
  }

  public void componentShown(ComponentEvent ev) {      //5
  }

  public void componentHidden(ComponentEvent ev) {     //6
  }

  public static void main (String args[]) {
    new KomponensFigyelo();
  }
}
