/*
 * Feladatmegoldások/8. fejezet
 * Szorzas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Szorzas extends JFrame implements ActionListener {
  private JTextField tfSzam1, tfSzam2, tfSzorzat;
  private JButton btSzoroz;
  private Container cp = getContentPane();

  public Szorzas() {
    setTitle("Szorzas");
    setBounds(200,200,200,100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));

    JPanel pn = new JPanel();
    cp.add(pn);
    pn.add(tfSzam1 = new JTextField(8));
    pn.add(new JLabel(" * "));
    pn.add(tfSzam2 = new JTextField(8));
    pn.add(new JLabel(" = "));
    pn.add(tfSzorzat = new JTextField(10));
    tfSzorzat.setEditable(false);

    pn = new JPanel();
    cp.add(pn);
    pn.add(btSzoroz = new JButton("Szoroz"));
    btSzoroz.addActionListener(this);

    pack();
    show();
  }

  public void actionPerformed(ActionEvent e) {
    try {
      int szam1 = Integer.parseInt(tfSzam1.getText());
      int szam2 = Integer.parseInt(tfSzam2.getText());
      tfSzorzat.setText(""+szam1*szam2);
    }
    catch (Exception ex) {
      Toolkit.getDefaultToolkit().beep();
      tfSzorzat.setText("Hiba!");
    }
  }

  public static void main(String[] args) {
    new Szorzas();
  }
}
