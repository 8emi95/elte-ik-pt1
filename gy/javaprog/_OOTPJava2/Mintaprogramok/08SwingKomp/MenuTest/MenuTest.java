/*
 * Mintaprogramok/8. fejezet
 * MenuTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// A CloseableFrame becsuk�sakor csak akkor fejez�dik be a program fut�sa, ha
// � volt az utols� "fut�" keret az alkalmaz�sban�:
import extra.frame.CloseableFrame;    // mert sok keret van

class MenuFrame extends CloseableFrame implements ActionListener {
  JMenuBar mb;
  JMenuItem miFelvitelFiuk;
  JMenuItem miLista1, miLista2;
  JCheckBoxMenuItem cmiNyomtatora;
  JMenuItem miHasznalat, miNevjegy;

  public MenuFrame(String title) {
    super(title);
    setBounds(400,200,250,120);
    // Men�
    setJMenuBar(mb = new JMenuBar());
    JMenu mFelvitel = new JMenu("Felvitel");
    mb.add(mFelvitel);
    JMenu mFelvitelHallgatok = new JMenu("Hallgat�k");
    mFelvitel.add(mFelvitelHallgatok);
    mFelvitel.add(new JMenu("Tan�rok"));
    mFelvitelHallgatok.add(miFelvitelFiuk = new JMenuItem("Fi�k",'F'));
    mFelvitelHallgatok.add(new JMenuItem("L�nyok",'L'));

    JMenu mLista = new JMenu("Lista");
    mb.add(mLista);
    mLista.add(miLista1 = new JMenuItem("Lista1"));
    mLista.add(miLista2 = new JMenuItem("Lista2"));
    mLista.addSeparator();
    mLista.add(cmiNyomtatora = new JCheckBoxMenuItem("Nyomtat�ra"));

    JMenu mSugo;
    mb.add(mSugo = new JMenu("S�g�"));
    mSugo.add(miHasznalat = new JMenuItem("Haszn�lat",
                       new ImageIcon("icons/help.gif")));
    mSugo.add(miNevjegy = new JMenuItem("N�vjegy"));

    miFelvitelFiuk.addActionListener(this);
    miLista1.addActionListener(this);
    miLista2.addActionListener(this);
    cmiNyomtatora.addActionListener(this);

    show();
  }

  public void lista1() {
    JFrame frList = new CloseableFrame("Lista1");
    frList.setLocation(getX()+10,getY()+10);
    frList.setSize(200,100);
    frList.show();
  }

  public void lista2() {
    JFrame frList = new CloseableFrame("Lista2");
    frList.setLocation(getX()+50,getY()+10);
    frList.setSize(300,50);
    frList.show();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == miLista1)
      lista1();
    else if (e.getSource() == miLista2)
      lista2();
    else if (e.getSource() == miFelvitelFiuk)
      System.out.println("Fi�k felvitele");
    else if (e.getSource() == cmiNyomtatora) {
      if (cmiNyomtatora.getState())
        System.out.println("Nyomtat�ra");
      else
        System.out.println("Nem nyomtat�ra");
    }
  }
}

public class MenuTest {
  public static void main (String args[]) {
    new MenuFrame("Men� pr�ba");
  } // main
} // MenuTest
