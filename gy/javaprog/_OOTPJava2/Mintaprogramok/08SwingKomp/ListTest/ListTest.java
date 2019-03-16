/*
 * Mintaprogramok/8. fejezet
 * ListTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
    super("Szövegek karbantartása");
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setLocation(200,200);
    lbInfo = new JLabel(" ");

    mdSzovegek = new DefaultListModel();                   //2
    mdSzovegek.addElement("Hosszúhetény");
    mdSzovegek.addElement("Rövidkaraj");

    lstSzovegek = new JList(mdSzovegek);                   //3
    lstSzovegek.setSelectionMode(
      ListSelectionModel.SINGLE_SELECTION);
    lstSzovegek.setSelectedIndex(0);
    lstSzovegek.addListSelectionListener(this);
    JScrollPane spSzovegek = new JScrollPane(lstSzovegek);

    btUj = new JButton("Új",new ImageIcon("icons/insert.gif"));
    btUj.addActionListener(this);
    btTorol = new JButton("Törlés",
                      new ImageIcon("icons/delete.gif"));
    btTorol.addActionListener(this);
    btKilep = new JButton("Kilép",
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
      // Nincs kiválasztott elem, törlés gomb letiltása
      btTorol.setEnabled(false);
    else {
      // Van kiválasztott elem, törlés gomb engedélyezése:
      btTorol.setEnabled(true);
      if (index==0)
        lbInfo.setText("Elsõ");
      else if (index==mdSzovegek.getSize()-1)
        lbInfo.setText("Utolsó");
    }
  }

  void torles() {                                          //5
    // Kiválasztott szöveg törlése:
    int index = lstSzovegek.getSelectedIndex();
    mdSzovegek.remove(index);
    // A kiválasztás újraértékelése:
    if (mdSzovegek.getSize()!=0) {
      if (index==mdSzovegek.getSize())
        index--;
      lstSzovegek.setSelectedIndex(index);
    }
    valasztasFigyelo();
  }

  void uj() {                                              //6
    String szoveg = JOptionPane.showInputDialog(this,"Szöveg:");
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
