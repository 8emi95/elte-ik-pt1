/*
 * Feladatmegoldások/5. fejezet
 * HaromKeret.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import extra.frame.CloseableFrame;

public class HaromKeret extends CloseableFrame {
  private Container cp = getContentPane();
  private JLabel lbKor;
  private JTextField tfKor;
  private JLabel lbNevek;
  private JComboBox cbNevek;
  private JCheckBox cbOK;
  private JButton btKilep;

  public HaromKeret() {
    setLocation (200,200);

    cp.setLayout(new FlowLayout());
    cp.add(lbKor = new JLabel("Hány éves vagy?"));
    cp.add(tfKor = new JTextField(3));

    cp.add(lbNevek = new JLabel("Melyik név tetszik neked a legjobban?"));
    cp.add(cbNevek = new JComboBox());
    cbNevek.addItem("Anna");
    cbNevek.addItem("Gergõ");
    cbNevek.addItem("Matyi");

    cp.add(cbOK = new JCheckBox("OK",true));
    cp.add(btKilep = new JButton("Kilép"));

    pack();
    show();
  }

  public static void main (String args[]) {
    new HaromKeret();
    new HaromKeret();
    new HaromKeret();
  }
}
