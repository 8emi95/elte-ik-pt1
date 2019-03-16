/*
 * Feladatmegoldások/10. fejezet
 * HercegFokusz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HercegFokusz extends JFrame implements FocusListener {
  private Container cp = getContentPane();
  private JLabel lbHerceg = new JLabel(new ImageIcon("icons/dukewave.gif"));

  /* Ha egy komponens fókuszba kerül, akkor megjelenítjük a herceget, és
   * ezt az idõzítõt elindítjuk. Ha eltelt egy egységnyi idõ, akkor
   * eltüntetjük a herceget és leállítjuk az idõzítõt.
   */
  private Timer timer = new Timer(200,
    new ActionListener() {
      int count=0;
      public void actionPerformed(ActionEvent e) {
        if (++count >= 2) {
          timer.stop();
          count=0;
          lbHerceg.setVisible(false);
        }
      }
    });

  public HercegFokusz() {
     setLocation(100,100);
     setResizable(false);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     cp.setLayout(new GridLayout(1,0));
     JButton bt;
     for (int i=0; i<5; i++) {
       cp.add(bt=new JButton(""+i));
       bt.addFocusListener(this);
     }
     cp.add(lbHerceg);
     lbHerceg.setVisible(false);

     pack();
     show();
  }

  public void focusGained(FocusEvent e) {
    lbHerceg.setVisible(true);
    timer.start();
  }

  public void focusLost(FocusEvent e) {
  }

  public static void main (String args[]) {
    new HercegFokusz();
  } // main
} // HercegFokusz
