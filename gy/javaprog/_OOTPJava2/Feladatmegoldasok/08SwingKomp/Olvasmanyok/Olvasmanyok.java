/*
 * Feladatmegoldások/8. fejezet
 * Olvasmanyok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Vector;

class OlvasmanyokFrame extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private JTextField tfOlvasando;
  private DefaultListModel mdOlvasandok = new DefaultListModel();
  private DefaultListModel mdOlvasottak = new DefaultListModel();
  private JList lstOlvasandok, lstOlvasottak;
  private JButton btAttesz;

  public OlvasmanyokFrame() {
    setTitle("Olvasmányok");
    setBounds(200,100,500,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Olvasandók: lista és címke elkészítése:
    JPanel pnOlvasandok = new JPanel();
    pnOlvasandok.setLayout(new BorderLayout());
    pnOlvasandok.add(new JLabel("Olvasandók",JLabel.CENTER),"North");
    pnOlvasandok.add(lstOlvasandok = new JList(mdOlvasandok));

    // Olvasottak: lista és címke elkészítése:
    JPanel pnOlvasottak = new JPanel();
    pnOlvasottak.setLayout(new BorderLayout());
    pnOlvasottak.add(new JLabel("Olvasottak",JLabel.CENTER),"North");
    pnOlvasottak.add(lstOlvasottak = new JList(mdOlvasottak));

    // Felsõ panel a szövegterületekkel:
    JPanel pnFelso = new JPanel();
    pnFelso.setLayout(new GridLayout(1,0));
    pnFelso.add(new JScrollPane(pnOlvasandok));
    pnFelso.add(new JScrollPane(pnOlvasottak));
    cp.add(pnFelso);

    // Alsó panel elkészítése:
    JPanel pnAlso = new JPanel();
    pnAlso.setLayout(new GridLayout(1,2));
    cp.add(pnAlso,"South");

    // Balra az "Új olvasmány" szövegmezõ:
    JPanel pnOlvasando = new JPanel();
    pnOlvasando.add(new JLabel("Új olvasmány: "));
    pnOlvasando.add(tfOlvasando = new JTextField(10));
    pnAlso.add(pnOlvasando);

    // Jobbra az "Olvasottba" gomb:
    JPanel pnAttesz = new JPanel();
    pnAttesz.add(btAttesz = new JButton("Olvasottba"));
    pnAlso.add(pnAttesz);

    btAttesz.addActionListener(this);
    tfOlvasando.addActionListener(this);
    tfOlvasando.requestFocus();

    show();
  }

  public void actionPerformed(ActionEvent ev) {
    // Az Olvasandó szöveget betesszük az Olvasandók listába:
    if (ev.getSource() == tfOlvasando) {
      mdOlvasandok.addElement(tfOlvasando.getText());
      tfOlvasando.setText("");
    }
    // A kiválasztott olvasmányokat áttesszük az Olvasottak listájába:
    else if ((ev.getSource() == btAttesz) &&
           lstOlvasandok.getSelectedIndex() >= 0) {
      Object[] kiv = lstOlvasandok.getSelectedValues();
      for (int i = 0; i < kiv.length; i++) {
        mdOlvasottak.addElement(kiv[i]);
        mdOlvasandok.removeElement(kiv[i]);
      } // for
    } // if
  } // actionPerformed
}

public class Olvasmanyok {
  public static void main (String args[]) {
    new OlvasmanyokFrame();
  } // main
} // Olvasmanyok
