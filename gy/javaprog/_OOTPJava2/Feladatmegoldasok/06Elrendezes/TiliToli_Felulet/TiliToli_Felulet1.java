/*
 * Feladatmegoldások/6. fejezet
 * TiliToli_Felulet1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;

public class TiliToli_Felulet1 extends JFrame {
  private Container cp = getContentPane();
  private int oszlop, sor;

  public TiliToli_Felulet1(int sor, int oszlop) {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.oszlop = oszlop;
    this.sor = sor;
    cp.setLayout(new GridLayout(sor,oszlop,1,1));
    for (int szam=1; szam<=sor*oszlop-1; szam++) {
      cp.add(new JButton(""+szam));
    }

    pack();
    show();
  }

  public static void main (String args[]) {
    new TiliToli_Felulet1(4,4);
  }
}
