/*
 * Feladatmegold�sok/8. fejezet
 * Villogas1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (A): Tegyen a keretbe egy �temesen villog� (megjelen�,
 * elt�n�) feliratot!
 *
 * 1. megold�s: Az id�z�t�t a keret kezeli le.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Villogas1 extends JFrame implements ActionListener {
  private Timer villogtato;
  private JLabel lbFelirat;

  public Villogas1() {
    setTitle("Villog�s");
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(lbFelirat = new JLabel("    Ez itt a rekl�m helye...    "));
    lbFelirat.setFont(new Font("Arial",Font.BOLD,30));
    lbFelirat.setForeground(Color.red);

    villogtato = new Timer(1000,this);

    villogtato.start();
    pack();
    show();
  }

  public void actionPerformed(ActionEvent e) {
    lbFelirat.setVisible(!lbFelirat.isVisible());
  }

  public static void main(String[] args) {
    new Villogas1();
  }
}




