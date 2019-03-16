/*
 * Feladatmegold�sok/8. fejezet
 * Nevek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Nevek extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private DefaultListModel mdNevek = new DefaultListModel();
  private JList lstNevek = new JList(mdNevek);
  private JTextField tfNev = new JTextField(15);

  public Nevek() {
    setTitle("Nevek");
    setBounds(100,100,400,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.add(new JScrollPane(lstNevek));
    JPanel pnNev = new JPanel();
    cp.add(pnNev,"South");
    pnNev.add(new JLabel("N�v: "));
    pnNev.add(tfNev);
    tfNev.addActionListener(this);

    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==e.VK_DELETE)
          torles();
      }
    });

    show();
    tfNev.requestFocus();
  }

  // A kiv�lasztott elemek t�rl�se a list�b�l:
  void torles() {
    DefaultListModel mdNevek = (DefaultListModel)lstNevek.getModel();
    int poz = lstNevek.getSelectedIndex();
    if (poz==-1)
     return;

    for (int i=mdNevek.size()-1; i>=0; i--) {
      if (lstNevek.isSelectedIndex(i))
        mdNevek.remove(i);
    }
    // Kiv�laszt�s r��ll�t�sa az eredeti els� poz�ci�ra, ha van ilyen,
    // egy�bk�nt az utols� elemre:
    if (poz <= mdNevek.size()-1)
      lstNevek.setSelectedIndex(poz);
    else
      lstNevek.setSelectedIndex(mdNevek.size()-1);
  }

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource()==tfNev) {
      String beszurNev = tfNev.getText();
      String nev = null;
      int i = 0;
      for (i = 0; i < mdNevek.size(); i++) {
        nev = (String)(mdNevek.get(i));
        if (beszurNev.compareTo(nev) <= 0)
          break;
      }

      mdNevek.add(i,beszurNev);
      lstNevek.setSelectedValue(beszurNev,true);
      tfNev.setText("");
    }
  }

  public static void main(String[] args) {
    new Nevek();
  }
}
