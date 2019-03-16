/*
 * Feladatmegold�sok/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * StringsDialog.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat: K�sz�tsen egy rendezett sz�vegeket �ssze�ll�t� dial�gust!
 * A dial�gust interakt�v m�don lehet szerkeszteni.
 *   - Enter: sz�veg m�dos�t�sa
 *   - Delete: sz�veg t�rl�se
 *   - Ins: �j sz�veg besz�r�sa
 *
 * A dial�gust a showDialog statikus met�dussal lehet megjelen�teni,
 * visszat�r�si �rt�ke egy sz�vegeket tartalmaz� vektor.
 * A dial�gus a h�v� komponens legfels� keret tulajdonos�nak k�zep�re ker�l.
 *
 * H�v�sa p�ld�ul:
 *   Vector strings = StringFactory.showDialog(this,"Sz�vegek");
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class StringFactory extends JDialog implements ActionListener, KeyListener {
  private JList list;
  private Container cp = getContentPane();
  private DefaultListModel md;
  private JLabel lbInfo = new JLabel("Insert-�j  Delete-t�rl�s  Enter-m�dos�t�s");
  private JButton btOk = new JButton("OK");
  private JButton btMegse = new JButton("M�gse");

  public StringFactory(JFrame owner, String title) {
    super((JFrame)owner,title,true);
    setTitle(title);
    setLocationRelativeTo(owner);
    cp.add(lbInfo,"North");

    md = new DefaultListModel();
    cp.add(new JScrollPane(list = new JList(md)));

    JPanel pnGombok = new JPanel();
    cp.add(pnGombok,"South");
    pnGombok.setBorder(BorderFactory.createRaisedBevelBorder());
    pnGombok.add(btOk);
    pnGombok.add(btMegse);
    btOk.addActionListener(this);
    btMegse.addActionListener(this);
    addKeyListener(this);
    pack();
  }

  public static Vector showDialog(JComponent parentComponent, String title) {
    Container top = parentComponent.getTopLevelAncestor();
    StringFactory sf;
    sf = new StringFactory((JFrame)top, title);
    sf.show();
    return sf.getStrings();
  }

  // Visszaadja a lista sz�vegeit egy vektorban:
  public Vector getStrings() {
    Vector strings = new Vector();
    for (int i = 0; i < md.getSize(); i++) {
      strings.add(md.getElementAt(i));
    }
    return strings;
  }

  // A vektor sz�vegeit beteszi a list�ba rendezetten:
  public void setStrings(Vector strings) {
    md.clear();
    for (int i = 0; i < strings.size(); i++) {
      md.add(i,strings.get(i));
    }
  }

  // str besz�r�sa a list�ba rendezetten:
  void addString(String ujSzoveg) {
    int index;
    String szoveg;
    for (index=0; index<md.getSize(); index++) {
      szoveg = (String)md.getElementAt(index);
      if (ujSzoveg.compareTo(szoveg) <= 0)
        break;
    }
    md.add(index,ujSzoveg);
    list.setSelectedIndex(index);
  }

  // Ins, Delete �s Enter billenty�k feldolgoz�sa:
  public void keyPressed(KeyEvent e) {
      // �j sz�veg bek�r�se �s besz�r�sa a list�ba:
      if (e.getKeyCode() == e.VK_INSERT) {
        String str = "";
        str = JOptionPane.showInputDialog(this,"Sz�veg: ");
        if (str != null)
          addString(str);
      }
      // Az aktu�lis listaelem t�rl�se:
      else if (e.getKeyCode() == e.VK_DELETE) {
        int index = list.getSelectedIndex();
        if (index >= 0) {
          md.remove(index);
          if (index <= md.size())
            list.setSelectedIndex(index);
        }
      }
      // Az aktu�lis listaelem m�dos�t�sa:
      else if (e.getKeyCode() == e.VK_ENTER) {
        int index = list.getSelectedIndex();
        if (!md.isEmpty() && index >= 0) {
          String str = (String)md.get(index);
          str = JOptionPane.showInputDialog(this,"Sz�veg: ");
          if (str != null) {
            md.remove(index);
            addString(str);
          }
        }
      }
    //super.processKeyEvent(e);
  }

  public void keyReleased(KeyEvent e) {}
  public void keyTyped(KeyEvent e) {}

  public void actionPerformed(ActionEvent e) {
    hide();
  }

} // StringFactory
