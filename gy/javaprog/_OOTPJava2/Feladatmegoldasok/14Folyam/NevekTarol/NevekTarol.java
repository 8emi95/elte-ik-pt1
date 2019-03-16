/*
 * Feladatmegoldások/14. fejezet
 * NevekTarol.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (B):
 * Készítsen egy alkalmazást, mely segítségével neveket lehet eltárolni.
 * A keretben van egy lista, mely egy rendezetlen névsort tartalmaz.
 * A keret felsõ részén egy beviteli mezõ található, melybõl
 * nevet lehet a listához hozzáadni.
 * A keret alsó részén négy gomb van:
 *   - Elment: Névsor lemezre mentése fájl dialógus segítségével.
 *   - Betölt: Névsor betöltése fájl dialógus segítségével.
 *   - Töröl: Névsor törlése.
 *   - Kilép: Program befejezése.
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
    return "Névsorok";
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
    setTitle("Névsorok");
    setResizable(false);
    fc.setCurrentDirectory(new File("."));
    fc.setFileFilter(new ListFilter());

    JPanel pnNev = new JPanel();
    pnNev.add(new JLabel("Név: "));
    pnNev.add(tfNev=new JTextField(20));
    cp.add(pnNev,"North");

    lstNevek = new JList(mdNevek);
    lstNevek.setVisibleRowCount(10);
    cp.add(new JScrollPane(lstNevek));

    JPanel pnGombok = new JPanel();
    pnGombok.add(btElment = new JButton("ELment"));
    pnGombok.add(btBetolt = new JButton("Betölt"));
    pnGombok.add(btTorol = new JButton("Töröl"));
    pnGombok.add(btKilep = new JButton("Kilép"));
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
    else if (e.getSource()==btBetolt)             // Betölt
      betolt();
    else if (e.getSource()==btTorol) {            // Töröl
      mdNevek.clear();
      tfNev.requestFocus();
    }
    else if (e.getSource()==btKilep)              // Kilép
      System.exit(0);
  }

  public static void main(String[] args) {
    new NevekTarol();
  }
}
