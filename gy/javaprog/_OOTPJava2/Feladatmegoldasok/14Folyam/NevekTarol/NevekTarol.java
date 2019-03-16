/*
 * Feladatmegold�sok/14. fejezet
 * NevekTarol.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (B):
 * K�sz�tsen egy alkalmaz�st, mely seg�ts�g�vel neveket lehet elt�rolni.
 * A keretben van egy lista, mely egy rendezetlen n�vsort tartalmaz.
 * A keret fels� r�sz�n egy beviteli mez� tal�lhat�, melyb�l
 * nevet lehet a list�hoz hozz�adni.
 * A keret als� r�sz�n n�gy gomb van:
 *   - Elment: N�vsor lemezre ment�se f�jl dial�gus seg�ts�g�vel.
 *   - Bet�lt: N�vsor bet�lt�se f�jl dial�gus seg�ts�g�vel.
 *   - T�r�l: N�vsor t�rl�se.
 *   - Kil�p: Program befejez�se.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

class ListFilter extends FileFilter {
  public boolean accept(File f) {
    return f.isDirectory() ||
       f.getName().toUpperCase().endsWith(".LST");
  }
  public String getDescription() {
    return "N�vsorok";
  }
}

public class  NevekTarol extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private JFileChooser fc = new JFileChooser();

  private JTextField tfNev;
  private DefaultListModel mdNevek = new DefaultListModel();
  private JList lstNevek;
  private JButton btElment;
  private JButton btBetolt;
  private JButton btTorol;
  private JButton btKilep;

  public NevekTarol() {
    setLocation(100,100);
    setTitle("N�vsorok");
    setResizable(false);
    fc.setCurrentDirectory(new File("."));
    fc.setFileFilter(new ListFilter());

    JPanel pnNev = new JPanel();
    pnNev.add(new JLabel("N�v: "));
    pnNev.add(tfNev=new JTextField(20));
    cp.add(pnNev,"North");

    lstNevek = new JList(mdNevek);
    lstNevek.setVisibleRowCount(10);
    cp.add(new JScrollPane(lstNevek));

    JPanel pnGombok = new JPanel();
    pnGombok.add(btElment = new JButton("ELment"));
    pnGombok.add(btBetolt = new JButton("Bet�lt"));
    pnGombok.add(btTorol = new JButton("T�r�l"));
    pnGombok.add(btKilep = new JButton("Kil�p"));
    cp.add(pnGombok,"South");

    tfNev.addActionListener(this);
    btElment.addActionListener(this);
    btBetolt.addActionListener(this);
    btTorol.addActionListener(this);
    btKilep.addActionListener(this);
    pack();
    show();
  }

  void elment() {
    if (fc.showSaveDialog(this)==fc.APPROVE_OPTION) {
      File f = fc.getSelectedFile();
      try {
        ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream(f));
        out.writeObject(mdNevek);
        out.close();
      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(this,"IO hiba!");
      }
    }
  }

  void betolt() {
    if (fc.showOpenDialog(this)==fc.APPROVE_OPTION) {
      File f = fc.getSelectedFile();
      try {
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream(f));
        mdNevek = (DefaultListModel)in.readObject();
        lstNevek.setModel(mdNevek);
        in.close();
      }
      catch (Exception ex) {
        JOptionPane.showMessageDialog(this,"Nincs ilyen lista!");
      }
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==tfNev) {                   // Felvisz
      mdNevek.addElement(tfNev.getText());
      tfNev.setText("");
    }
    else if (e.getSource()==btElment)             // Elment
      elment();
    else if (e.getSource()==btBetolt)             // Bet�lt
      betolt();
    else if (e.getSource()==btTorol) {            // T�r�l
      mdNevek.clear();
      tfNev.requestFocus();
    }
    else if (e.getSource()==btKilep)              // Kil�p
      System.exit(0);
  }

  public static void main(String[] args) {
    new NevekTarol();
  }
}
