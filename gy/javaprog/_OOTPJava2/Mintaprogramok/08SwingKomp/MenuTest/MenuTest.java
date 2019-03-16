/*
 * Mintaprogramok/8. fejezet
 * MenuTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// A CloseableFrame becsukásakor csak akkor fejezõdik be a program futása, ha
// õ volt az utolsó "futó" keret az alkalmazásbaní:
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
    // Menü
    setJMenuBar(mb = new JMenuBar());
    JMenu mFelvitel = new JMenu("Felvitel");
    mb.add(mFelvitel);
    JMenu mFelvitelHallgatok = new JMenu("Hallgatók");
    mFelvitel.add(mFelvitelHallgatok);
    mFelvitel.add(new JMenu("Tanárok"));
    mFelvitelHallgatok.add(miFelvitelFiuk = new JMenuItem("Fiúk",'F'));
    mFelvitelHallgatok.add(new JMenuItem("Lányok",'L'));

    JMenu mLista = new JMenu("Lista");
    mb.add(mLista);
    mLista.add(miLista1 = new JMenuItem("Lista1"));
    mLista.add(miLista2 = new JMenuItem("Lista2"));
    mLista.addSeparator();
    mLista.add(cmiNyomtatora = new JCheckBoxMenuItem("Nyomtatóra"));

    JMenu mSugo;
    mb.add(mSugo = new JMenu("Súgó"));
    mSugo.add(miHasznalat = new JMenuItem("Használat",
                       new ImageIcon("icons/help.gif")));
    mSugo.add(miNevjegy = new JMenuItem("Névjegy"));

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
      System.out.println("Fiúk felvitele");
    else if (e.getSource() == cmiNyomtatora) {
      if (cmiNyomtatora.getState())
        System.out.println("Nyomtatóra");
      else
        System.out.println("Nem nyomtatóra");
    }
  }
}

public class MenuTest {
  public static void main (String args[]) {
    new MenuFrame("Menü próba");
  } // main
} // MenuTest
