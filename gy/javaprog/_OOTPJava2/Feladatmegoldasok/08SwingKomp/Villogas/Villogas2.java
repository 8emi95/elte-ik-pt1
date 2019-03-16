/*
 * Feladatmegoldások/8. fejezet
 * Villogas2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (A): Tegyen a keretbe egy ütemesen villogó (megjelenõ,
 * eltûnõ) feliratot!
 *
 * 2. megoldás: Az idõzítõt egy névtelen osztály példánya kezeli le.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Villogas2 extends JFrame {
  private Timer villogtato;
  private JLabel lbFelirat;

  public Villogas2() {
    setTitle("Villogás");
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(lbFelirat = new JLabel("    Ez itt a reklám helye...    "));
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




