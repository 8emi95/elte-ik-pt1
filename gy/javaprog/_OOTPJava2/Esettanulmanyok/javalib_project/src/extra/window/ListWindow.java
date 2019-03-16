/*
 * Projekt: Tilitoli
 *
 * Csomag: gui
 * ListWindow.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Dial�gus ablak, mely egy list�t k�pes megjelen�teni.
 * A konstruktorban megadhat� a lista fejl�ce. A megjelen�t�s a
 * showList(Vector list) met�dussal t�rt�nik.
 * A lista a T�rl�s gombbal t�r�lhet�. T�rl�s vissza gombra marad az eredeti lista.
 */

package extra.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import extra.*;

public class ListWindow extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private Vector list;    // a megjelen�tend� lista
  private Vector tmpList; // lista m�solata (t�rl�s vissza miatt)
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
    pnGombok.add(btClear = new JButton("T�rl�s"));
    pnGombok.add(btUndoClear = new JButton("T�rl�s vissza"));
    pnGombok.add(btOk = new JButton("Rendben"));
    cp.add(pnGombok,"South");

    btOk.addActionListener(this);
    btOk.setMnemonic('K');

    btClear.addActionListener(this);
    btClear.setMnemonic('T');

    btUndoClear.addActionListener(this);
    btUndoClear.setMnemonic('M');
  }

  /* Megjelen�ti az ablakban a megadott list�t.
   * A list�t lehet t�r�lni, de ha a M�gse gombbal l�pnek ki,
   * akkor megmarad az eredeti lista.
   */
  public void showList(Vector aList) {
    list = aList;
    // K�sz�t�nk egy m�solatot, hogy T�r�l vissza eset�n a list�t vissza�ll�thassuk:
    tmpList = (Vector)list.clone();
    // A list megjelen�t�se:
    setList(list);
    pack();

    // Els� megjelen�skor igaz�t�s a sz�l�h�z:
    if (firstShow) {
      firstShow = false;
      setLocationRelativeTo(getParent());
    }
    show();
  }

  // Listaelemek megjelen�t�se sorsz�mokkal:
  protected void setList(Vector list) {
    mdList.clear();
    for (int i=0; i<list.size(); i++)
      mdList.addElement(Format.right(i+1,2)+". "+list.get(i)+" ");
  }

  // A nyom�gombok lekezel�se:
  public void actionPerformed(ActionEvent e) {
    // T�rl�s eset�n a list vektort �s a hozz�tartoz� modellt ki�r�tj�k:
    if (e.getSource() == btClear) {
      list.clear();
      mdList.clear();
    }
    // T�rl�s vissza eset�n az eredeti lista vissza�ll�t�sa:
    else if (e.getSource() == btUndoClear) {
      list.clear();
      for (int i = 0; i < tmpList.size(); i++) {
        list.add(tmpList.get(i));
      }
      setList(list);
    }
    // Ok eset�n az ablak elt�ntet�se. list marad.
    else if (e.getSource() == btOk) {
      hide();
    }
  }
} // ListWindow
