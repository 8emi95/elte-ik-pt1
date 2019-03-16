/*
 * Feladatmegold�sok/8. fejezet
 * Villogas2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (A): Tegyen a keretbe egy �temesen villog� (megjelen�,
 * elt�n�) feliratot!
 *
 * 2. megold�s: Az id�z�t�t egy n�vtelen oszt�ly p�ld�nya kezeli le.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Villogas2 extends JFrame {
  private Timer villogtato;
  private JLabel lbFelirat;

  public Villogas2() {
    setTitle("Villog�s");
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(lbFelirat = new JLabel("    Ez itt a rekl�m helye...    "));
    lbFelirat.setFont(new Font("Arial",Font.BOLD,30));
    lbFelirat.setForeground(Color.red);

    villogtato = new Timer(1000,new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        lbFelirat.setVisible(!lbFelirat.isVisible());
      }
    });

    villogtato.start();
    pack();
    show();
  }

  public static void main(String[] args) {
    new Villogas2();
  }
}




