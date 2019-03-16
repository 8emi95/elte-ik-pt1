/*
 * Feladatmegold�sok/8. fejezet
 * Szovegek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Szovegek extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private JTextArea taSzovegek;
  private JTextField tfSzoveg;
  private JButton btKilep, btUjsor;

  public Szovegek() {
    setLocation(300,200);
    setTitle("Sz�vegek");
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    /* A keret fel�p�t�se:
     * A tartalompanel k�t panelb�l �ll: taSzoveg (k�z�pen) �s pnAlso (alul).
     * pnAlso r�csos elrendez�s�, melynek fels� r�sze a pnBevitel,
     * als� r�sze a pnGomb.
     */
    cp.add(taSzovegek = new JTextArea(30,50));
    taSzovegek.setEditable(false);

    JPanel pnAlso = new JPanel();
    cp.add(pnAlso,BorderLayout.SOUTH);
    pnAlso.setLayout(new GridLayout(2,1));
    JPanel pnBevitel = new JPanel();
    pnAlso.add(pnBevitel);
    pnBevitel.add(new JLabel("Sz�veg"));
    pnBevitel.add(tfSzoveg = new JTextField(15));

    JPanel pnGomb = new JPanel();
    pnGomb.setBorder(BorderFactory.createRaisedBevelBorder());
    pnAlso.add(pnGomb);
    pnGomb.add(btUjsor = new JButton("�j sor"));
    pnGomb.add(btKilep = new JButton("Kil�p"));

    tfSzoveg.addActionListener(this);
    btUjsor.addActionListener(this);
    btKilep.addActionListener(this);
    pack();
    show();
    tfSzoveg.requestFocus();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==tfSzoveg) {
      taSzovegek.append(tfSzoveg.getText()+" ");
      tfSzoveg.setText("");
    }
    else if (e.getSource()==btUjsor) {
      taSzovegek.append("\n");
      tfSzoveg.requestFocus();
    }
    else if (e.getSource()==btKilep)
      System.exit(0);
  }

  public static void main(String[] args) {
    new Szovegek();
  }
}
