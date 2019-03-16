/*
 * Feladatmegoldások/6. fejezet
 * NegyGomb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;
import extra.Console;

public class NegyGomb extends JFrame {
  Container cp = getContentPane();

  public NegyGomb() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    String strFelso = Console.readLine("Felsõ gomb szövege: ");
    String strAlso = Console.readLine("Alsó gomb szövege: ");
    String strBal = Console.readLine("Bal gomb szövege: ");
    String strJobb = Console.readLine("Jobb gomb szövege: ");

    setLocation(200,100);
    cp.add(new JButton(strFelso),"North");
    cp.add(new JButton(strAlso),"South");
    cp.add(new JButton(strBal),"West");
    cp.add(new JButton(strJobb),"East");

    pack();
    show();
  }

  public static void main (String args[]) {
    new NegyGomb();
  }
}
