/*
 * Mintaprogramok/Feladatok
 * Projekt: Temak
 * Temak.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    setTitle("T�m�k");

    lstTemak = new JList(mdTemak); // lista a tartalompanelre
    cp.add(new JScrollPane(lstTemak));  // lehet g�rgetni
    lstTemak.setSelectionMode(   // csak egyet lehet kiv�lasztani
        ListSelectionModel.SINGLE_SELECTION);

    JPanel pnGombok = new JPanel(); // gombok felpakol�sa
    pnGombok.setLayout(new GridLayout(0,1));
    pnGombok.add(btUj = new JButton("�j"));
    pnGombok.add(btTorol = new JButton("T�r�l"));
    pnGombok.add(new JLabel(" "));
    pnGombok.add(btFel = new JButton("Fel"));
    pnGombok.add(btLe = new JButton("Le"));
    pnGombok.add(new JLabel(" "));
    pnGombok.add(btKilep = new JButton("Kil�p"));
    cp.add(pnGombok,"East");

    btUj.addActionListener(this);   // figyel�k felf�z�se
    btTorol.addActionListener(this);
    btFel.addActionListener(this);
    btLe.addActionListener(this);
    btKilep.addActionListener(this);
    lstTemak.addListSelectionListener(this);
    enableUpdate();
    pack();
    show();
  }
  /** Enged�lyez�sek be�ll�t�sa */
  void enableUpdate() {
    int n = lstTemak.getSelectedIndex();
    btFel.setEnabled(n>0); // ha fent van, nem mehet feljebb
    btLe.setEnabled(n<mdTemak.getSize()-1); // ha lent van, nem mehet lejjebb
    btTorol.setEnabled(n>=0); //t�rl�s eng., ha van kijel�l�s
  }
  // Ha mozogtak a list�ban, �jra�rt�kelj�k az enged�lyez�seket:
  public void valueChanged(ListSelectionEvent e) {
    enableUpdate();
  }
  // A haszn�lati eset ind�t�sa:
  public void actionPerformed(ActionEvent e) {
    // �j t�ma:
    if (e.getSource()==btUj) {
      String tema = HuOptionPane.showInputDialog(this,"�j t�ma");
      if (tema != null) // ha be�t�ttek valamit, bevissz�k
        mdTemak.addElement(tema);
      lstTemak.setSelectedValue(tema,true); // elem kiv�laszt�sa
    }
    // Kiv�lasztott t�ma t�rl�se:
    else if (e.getSource()==btTorol) {
      int poz = lstTemak.getSelectedIndex(); // kiv. elem indexe
      if (poz==-1)  // �res a lista
        return;
      mdTemak.remove(poz); // poz. t�ma t�rl�se
      if (mdTemak.getSize() != 0) { // ha van m�g t�ma
        if (poz == mdTemak.getSize()) // ha utols� volt
          poz--;
        lstTemak.setSelectedIndex(poz); // elem kijel�l�se
      }
    }

    // T�ma mozgat�sa eggyel feljebb:
    else if (e.getSource()==btFel) {
      int poz = lstTemak.getSelectedIndex();
      if (poz > 0) {
        mdTemak.add(poz-1,mdTemak.remove(poz));
        lstTemak.setSelectedIndex(poz-1);
      }
    }
    // T�ma mozgat�sa eggyel lejjebb:
    else if (e.getSource()==btLe) {
      int poz = lstTemak.getSelectedIndex();
      if (poz < mdTemak.getSize()-1) {
        mdTemak.add(poz+1,mdTemak.remove(poz));
        lstTemak.setSelectedIndex(poz+1);
      }
    }
    // Kil�p�s:
    else if (e.getSource()==btKilep)
      System.exit(0);
  }

  public static void main(String[] args) {
    new Temak();
  }
}
