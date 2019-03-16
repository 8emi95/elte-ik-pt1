/*
 * Feladatmegoldások/6. fejezet
 * TiliToli_Felulet2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TiliToli_Felulet2 extends JFrame {
  Container cp = getContentPane();
  JButton btLyuk;
  private int oszlop, sor;

  public TiliToli_Felulet2(int sor, int oszlop, int lyukSor, int lyukOszlop) {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(oszlop*50,sor*50);
    this.sor = sor;
    this.oszlop = oszlop;
    cp.setLayout(new GridLayout(sor,oszlop,1,1));
    JButton btGomb;
    for (int szam=1; szam<=sor*oszlop-1; szam++) {
      cp.add(btGomb=new JButton(""+szam));
      btGomb.setBorder(new BevelBorder(BevelBorder.RAISED));
    }
    // Az üres hely koordinátája 1-tõl számozással
    int poz = (lyukSor-1)*oszlop+lyukOszlop-1;
    cp.add(btLyuk=new JButton(""),poz);
    btLyuk.setBackground(Color.white);
    btLyuk.setBorder(new BevelBorder(BevelBorder.LOWERED));

    // Nincs pack, saját méretet adtunk meg.
    show();
  }

  public static void main (String args[]) {
    new TiliToli_Felulet2(3,6,2,3);
  }
}

