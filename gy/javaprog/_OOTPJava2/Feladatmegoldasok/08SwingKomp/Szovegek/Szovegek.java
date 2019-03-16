/*
 * Feladatmegoldások/8. fejezet
 * Szovegek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
    setTitle("Szövegek");
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    /* A keret felépítése:
     * A tartalompanel két panelbõl áll: taSzoveg (középen) és pnAlso (alul).
     * pnAlso rácsos elrendezésû, melynek felsõ része a pnBevitel,
     * alsó része a pnGomb.
     */
    cp.add(taSzovegek = new JTextArea(30,50));
    taSzovegek.setEditable(false);

    JPanel pnAlso = new JPanel();
    cp.add(pnAlso,BorderLayout.SOUTH);
    pnAlso.setLayout(new GridLayout(2,1));
    JPanel pnBevitel = new JPanel();
    pnAlso.add(pnBevitel);
    pnBevitel.add(new JLabel("Szöveg"));
    pnBevitel.add(tfSzoveg = new JTextField(15));

    JPanel pnGomb = new JPanel();
    pnGomb.setBorder(BorderFactory.createRaisedBevelBorder());
    pnAlso.add(pnGomb);
    pnGomb.add(btUjsor = new JButton("Új sor"));
    pnGomb.add(btKilep = new JButton("Kilép"));

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
