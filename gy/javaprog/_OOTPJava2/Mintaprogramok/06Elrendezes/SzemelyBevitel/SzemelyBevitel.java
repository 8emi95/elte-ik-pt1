/*
 * Mintaprogramok/6. fejezet
 * SzemelyBevitel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;

class SzemelyPanel extends JPanel {
  JTextField tfNev;                                        //1
  JTextField tfSzulev;
  JButton btOk, btCancel;

  public SzemelyPanel() {
    setLayout(new GridLayout(3,1));                        //2

    JPanel pnNev = new JPanel();                           //3
    pnNev.add(new JLabel("N�v: "));
    pnNev.add(tfNev = new JTextField(20));
    add(pnNev);

    JPanel pnSzulev = new JPanel();
    pnSzulev.add(new JLabel("Sz�l. �v: "));
    pnSzulev.add(tfSzulev = new JTextField(6));
    add(pnSzulev);

    JPanel pnGomb = new JPanel();
    pnGomb.setBorder(BorderFactory.createEtchedBorder());
    pnGomb.add(btOk = new JButton("OK"));
    pnGomb.add(btCancel = new JButton("Cancel"));
    add(pnGomb);
  }
}

public class SzemelyBevitel extends JFrame {
  public SzemelyBevitel() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Szem�ly beviteli ablak");
    getContentPane().add(new SzemelyPanel());
    pack();
    show();
  }
  public static void main (String args[]) {
    new SzemelyBevitel();
  }
}
