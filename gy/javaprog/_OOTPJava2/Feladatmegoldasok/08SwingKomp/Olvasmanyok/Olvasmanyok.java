/*
 * Feladatmegold�sok/8. fejezet
 * Olvasmanyok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    setTitle("Olvasm�nyok");
    setBounds(200,100,500,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Olvasand�k: lista �s c�mke elk�sz�t�se:
    JPanel pnOlvasandok = new JPanel();
    pnOlvasandok.setLayout(new BorderLayout());
    pnOlvasandok.add(new JLabel("Olvasand�k",JLabel.CENTER),"North");
    pnOlvasandok.add(lstOlvasandok = new JList(mdOlvasandok));

    // Olvasottak: lista �s c�mke elk�sz�t�se:
    JPanel pnOlvasottak = new JPanel();
    pnOlvasottak.setLayout(new BorderLayout());
    pnOlvasottak.add(new JLabel("Olvasottak",JLabel.CENTER),"North");
    pnOlvasottak.add(lstOlvasottak = new JList(mdOlvasottak));

    // Fels� panel a sz�vegter�letekkel:
    JPanel pnFelso = new JPanel();
    pnFelso.setLayout(new GridLayout(1,0));
    pnFelso.add(new JScrollPane(pnOlvasandok));
    pnFelso.add(new JScrollPane(pnOlvasottak));
    cp.add(pnFelso);

    // Als� panel elk�sz�t�se:
    JPanel pnAlso = new JPanel();
    pnAlso.setLayout(new GridLayout(1,2));
    cp.add(pnAlso,"South");

    // Balra az "�j olvasm�ny" sz�vegmez�:
    JPanel pnOlvasando = new JPanel();
    pnOlvasando.add(new JLabel("�j olvasm�ny: "));
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
    // Az Olvasand� sz�veget betessz�k az Olvasand�k list�ba:
    if (ev.getSource() == tfOlvasando) {
      mdOlvasandok.addElement(tfOlvasando.getText());
      tfOlvasando.setText("");
    }
    // A kiv�lasztott olvasm�nyokat �ttessz�k az Olvasottak list�j�ba:
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
