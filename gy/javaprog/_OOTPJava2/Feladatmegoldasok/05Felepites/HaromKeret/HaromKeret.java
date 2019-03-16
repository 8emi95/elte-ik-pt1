/*
 * Feladatmegold�sok/5. fejezet
 * HaromKeret.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    cp.add(lbKor = new JLabel("H�ny �ves vagy?"));
    cp.add(tfKor = new JTextField(3));

    cp.add(lbNevek = new JLabel("Melyik n�v tetszik neked a legjobban?"));
    cp.add(cbNevek = new JComboBox());
    cbNevek.addItem("Anna");
    cbNevek.addItem("Gerg�");
    cbNevek.addItem("Matyi");

    cp.add(cbOK = new JCheckBox("OK",true));
    cp.add(btKilep = new JButton("Kil�p"));

    pack();
    show();
  }

  public static void main (String args[]) {
    new HaromKeret();
    new HaromKeret();
    new HaromKeret();
  }
}
