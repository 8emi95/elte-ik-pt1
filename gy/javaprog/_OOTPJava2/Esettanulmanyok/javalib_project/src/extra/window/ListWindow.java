/*
 * Projekt: Tilitoli
 *
 * Csomag: gui
 * ListWindow.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Dialógus ablak, mely egy listát képes megjeleníteni.
 * A konstruktorban megadható a lista fejléce. A megjelenítés a
 * showList(Vector list) metódussal történik.
 * A lista a Törlés gombbal törölhetõ. Törlés vissza gombra marad az eredeti lista.
 */

package extra.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import extra.*;

public class ListWindow extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private Vector list;    // a megjelenítendõ lista
  private Vector tmpList; // lista másolata (törlés vissza miatt)
  private boolean firstShow = true;

  private JLabel lbListHeader;
  private DefaultListModel mdList = new DefaultListModel();
  private JList lstList = new JList(mdList);
  private JButton btClear;
  private JButton btUndoClear;
  private JButton btOk;

  public ListWindow(JFrame owner, String title, String header) {
    super(owner,title,true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    cp.add(lbListHeader = new JLabel(header),"North");
    lbListHeader.setFont(new Font("Monospaced",Font.PLAIN,14));
    lstList.setFont(new Font("Monospaced",Font.PLAIN,14));
    cp.add(new JScrollPane(lstList));
    JPanel pnGombok = new JPanel();
    pnGombok.add(btClear = new JButton("Törlés"));
    pnGombok.add(btUndoClear = new JButton("Törlés vissza"));
    pnGombok.add(btOk = new JButton("Rendben"));
    cp.add(pnGombok,"South");

    btOk.addActionListener(this);
    btOk.setMnemonic('K');

    btClear.addActionListener(this);
    btClear.setMnemonic('T');

    btUndoClear.addActionListener(this);
    btUndoClear.setMnemonic('M');
  }

  /* Megjeleníti az ablakban a megadott listát.
   * A listát lehet törölni, de ha a Mégse gombbal lépnek ki,
   * akkor megmarad az eredeti lista.
   */
  public void showList(Vector aList) {
    list = aList;
    // Készítünk egy másolatot, hogy Töröl vissza esetén a listát visszaállíthassuk:
    tmpList = (Vector)list.clone();
    // A list megjelenítése:
    setList(list);
    pack();

    // Elsõ megjelenéskor igazítás a szülõhöz:
    if (firstShow) {
      firstShow = false;
      setLocationRelativeTo(getParent());
    }
    show();
  }

  // Listaelemek megjelenítése sorszámokkal:
  protected void setList(Vector list) {
    mdList.clear();
    for (int i=0; i<list.size(); i++)
      mdList.addElement(Format.right(i+1,2)+". "+list.get(i)+" ");
  }

  // A nyomógombok lekezelése:
  public void actionPerformed(ActionEvent e) {
    // Törlés esetén a list vektort és a hozzátartozó modellt kiürítjük:
    if (e.getSource() == btClear) {
      list.clear();
      mdList.clear();
    }
    // Törlés vissza esetén az eredeti lista visszaállítása:
    else if (e.getSource() == btUndoClear) {
      list.clear();
      for (int i = 0; i < tmpList.size(); i++) {
        list.add(tmpList.get(i));
      }
      setList(list);
    }
    // Ok esetén az ablak eltüntetése. list marad.
    else if (e.getSource() == btOk) {
      hide();
    }
  }
} // ListWindow
