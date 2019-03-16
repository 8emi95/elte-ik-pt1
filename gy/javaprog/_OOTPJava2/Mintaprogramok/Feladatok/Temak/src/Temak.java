/*
 * Mintaprogramok/Feladatok
 * Projekt: Temak
 * Temak.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import extra.hu.*;

public class Temak extends JFrame implements ActionListener, ListSelectionListener {
  Container cp = getContentPane();
  DefaultListModel mdTemak = new DefaultListModel(); // lista modellje
  JList lstTemak; // a lista
  JButton btKilep, btUj, btTorol, btFel, btLe; // gombok

  public Temak() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocation(100,100);
    setTitle("Témák");

    lstTemak = new JList(mdTemak); // lista a tartalompanelre
    cp.add(new JScrollPane(lstTemak));  // lehet görgetni
    lstTemak.setSelectionMode(   // csak egyet lehet kiválasztani
        ListSelectionModel.SINGLE_SELECTION);

    JPanel pnGombok = new JPanel(); // gombok felpakolása
    pnGombok.setLayout(new GridLayout(0,1));
    pnGombok.add(btUj = new JButton("Új"));
    pnGombok.add(btTorol = new JButton("Töröl"));
    pnGombok.add(new JLabel(" "));
    pnGombok.add(btFel = new JButton("Fel"));
    pnGombok.add(btLe = new JButton("Le"));
    pnGombok.add(new JLabel(" "));
    pnGombok.add(btKilep = new JButton("Kilép"));
    cp.add(pnGombok,"East");

    btUj.addActionListener(this);   // figyelõk felfûzése
    btTorol.addActionListener(this);
    btFel.addActionListener(this);
    btLe.addActionListener(this);
    btKilep.addActionListener(this);
    lstTemak.addListSelectionListener(this);
    enableUpdate();
    pack();
    show();
  }
  /** Engedélyezések beállítása */
  void enableUpdate() {
    int n = lstTemak.getSelectedIndex();
    btFel.setEnabled(n>0); // ha fent van, nem mehet feljebb
    btLe.setEnabled(n<mdTemak.getSize()-1); // ha lent van, nem mehet lejjebb
    btTorol.setEnabled(n>=0); //törlés eng., ha van kijelölés
  }
  // Ha mozogtak a listában, újraértékeljük az engedélyezéseket:
  public void valueChanged(ListSelectionEvent e) {
    enableUpdate();
  }
  // A használati eset indítása:
  public void actionPerformed(ActionEvent e) {
    // Új téma:
    if (e.getSource()==btUj) {
      String tema = HuOptionPane.showInputDialog(this,"Új téma");
      if (tema != null) // ha beütöttek valamit, bevisszük
        mdTemak.addElement(tema);
      lstTemak.setSelectedValue(tema,true); // elem kiválasztása
    }
    // Kiválasztott téma törlése:
    else if (e.getSource()==btTorol) {
      int poz = lstTemak.getSelectedIndex(); // kiv. elem indexe
      if (poz==-1)  // üres a lista
        return;
      mdTemak.remove(poz); // poz. téma törlése
      if (mdTemak.getSize() != 0) { // ha van még téma
        if (poz == mdTemak.getSize()) // ha utolsó volt
          poz--;
        lstTemak.setSelectedIndex(poz); // elem kijelölése
      }
    }

    // Téma mozgatása eggyel feljebb:
    else if (e.getSource()==btFel) {
      int poz = lstTemak.getSelectedIndex();
      if (poz > 0) {
        mdTemak.add(poz-1,mdTemak.remove(poz));
        lstTemak.setSelectedIndex(poz-1);
      }
    }
    // Téma mozgatása eggyel lejjebb:
    else if (e.getSource()==btLe) {
      int poz = lstTemak.getSelectedIndex();
      if (poz < mdTemak.getSize()-1) {
        mdTemak.add(poz+1,mdTemak.remove(poz));
        lstTemak.setSelectedIndex(poz+1);
      }
    }
    // Kilépés:
    else if (e.getSource()==btKilep)
      System.exit(0);
  }

  public static void main(String[] args) {
    new Temak();
  }
}
