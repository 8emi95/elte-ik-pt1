/*
 * Feladatmegold�sok/6. fejezet
 * NegyGomb.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;
import extra.Console;

public class NegyGomb extends JFrame {
  Container cp = getContentPane();

  public NegyGomb() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    String strFelso = Console.readLine("Fels� gomb sz�vege: ");
    String strAlso = Console.readLine("Als� gomb sz�vege: ");
    String strBal = Console.readLine("Bal gomb sz�vege: ");
    String strJobb = Console.readLine("Jobb gomb sz�vege: ");

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
