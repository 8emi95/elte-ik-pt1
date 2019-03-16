/*
 * Mintaprogramok/8. fejezet
 * ListTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class KarbantartFrame extends JFrame implements
         ActionListener, ListSelectionListener {           //1
  DefaultListModel mdSzovegek;
  JList lstSzovegek;
  JButton btUj, btTorol, btKilep;
  JLabel lbInfo;

  public KarbantartFrame() {
    super("Sz�vegek karbantart�sa");
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setLocation(200,200);
    lbInfo = new JLabel(" ");

    mdSzovegek = new DefaultListModel();                   //2
    mdSzovegek.addElement("Hossz�het�ny");
    mdSzovegek.addElement("R�vidkaraj");

    lstSzovegek = new JList(mdSzovegek);                   //3
    lstSzovegek.setSelectionMode(
      ListSelectionModel.SINGLE_SELECTION);
    lstSzovegek.setSelectedIndex(0);
    lstSzovegek.addListSelectionListener(this);
    JScrollPane spSzovegek = new JScrollPane(lstSzovegek);

    btUj = new JButton("�j",new ImageIcon("icons/insert.gif"));
    btUj.addActionListener(this);
    btTorol = new JButton("T�rl�s",
                      new ImageIcon("icons/delete.gif"));
    btTorol.addActionListener(this);
    btKilep = new JButton("Kil�p",
                      new ImageIcon("icons/exit.gif"));
    btKilep.addActionListener(this);

    JPanel pnVezer = new JPanel();
    pnVezer.add(btUj);
    pnVezer.add(btTorol);
    pnVezer.add(btKilep);

    Container contentPane = getContentPane();
    contentPane.add(lbInfo,"North");
    contentPane.add(spSzovegek,"Center");
    contentPane.add(pnVezer,"South");

    pack();
    setVisible(true);
    valasztasFigyelo();
  }

  void valasztasFigyelo() {                                //4
    int index = lstSzovegek.getSelectedIndex();
    lbInfo.setText(" ");
    if (index==-1)
      // Nincs kiv�lasztott elem, t�rl�s gomb letilt�sa
      btTorol.setEnabled(false);
    else {
      // Van kiv�lasztott elem, t�rl�s gomb enged�lyez�se:
      btTorol.setEnabled(true);
      if (index==0)
        lbInfo.setText("Els�");
      else if (index==mdSzovegek.getSize()-1)
        lbInfo.setText("Utols�");
    }
  }

  void torles() {                                          //5
    // Kiv�lasztott sz�veg t�rl�se:
    int index = lstSzovegek.getSelectedIndex();
    mdSzovegek.remove(index);
    // A kiv�laszt�s �jra�rt�kel�se:
    if (mdSzovegek.getSize()!=0) {
      if (index==mdSzovegek.getSize())
        index--;
      lstSzovegek.setSelectedIndex(index);
    }
    valasztasFigyelo();
  }

  void uj() {                                              //6
    String szoveg = JOptionPane.showInputDialog(this,"Sz�veg:");
    if (szoveg==null)
      return;
    if (szoveg.equals(""))
      Toolkit.getDefaultToolkit().beep();
    else {
      mdSzovegek.addElement(szoveg);
      lstSzovegek.setSelectedValue(szoveg,true);
      valasztasFigyelo();
    }
  }

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource()==btUj)
      uj();
    else if (ev.getSource()==btTorol)
      torles();
    else if (ev.getSource()==btKilep)
      System.exit(0);
  }

  public void valueChanged(ListSelectionEvent e) {         //7
    valasztasFigyelo();
  }
}

public class ListTest {
  public static void main(String[] args) {
    new KarbantartFrame() ;
  }
}
