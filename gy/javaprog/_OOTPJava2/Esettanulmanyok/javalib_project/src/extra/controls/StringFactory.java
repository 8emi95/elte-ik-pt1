/*
 * Feladatmegoldások/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * StringsDialog.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat: Készítsen egy rendezett szövegeket összeállító dialógust!
 * A dialógust interaktív módon lehet szerkeszteni.
 *   - Enter: szöveg módosítása
 *   - Delete: szöveg törlése
 *   - Ins: új szöveg beszúrása
 *
 * A dialógust a showDialog statikus metódussal lehet megjeleníteni,
 * visszatérési értéke egy szövegeket tartalmazó vektor.
 * A dialógus a hívó komponens legfelsõ keret tulajdonosának közepére kerül.
 *
 * Hívása például:
 *   Vector strings = StringFactory.showDialog(this,"Szövegek");
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
  private JLabel lbInfo = new JLabel("Insert-új  Delete-törlés  Enter-módosítás");
  private JButton btOk = new JButton("OK");
  private JButton btMegse = new JButton("Mégse");

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

  // Visszaadja a lista szövegeit egy vektorban:
  public Vector getStrings() {
    Vector strings = new Vector();
    for (int i = 0; i < md.getSize(); i++) {
      strings.add(md.getElementAt(i));
    }
    return strings;
  }

  // A vektor szövegeit beteszi a listába rendezetten:
  public void setStrings(Vector strings) {
    md.clear();
    for (int i = 0; i < strings.size(); i++) {
      md.add(i,strings.get(i));
    }
  }

  // str beszúrása a listába rendezetten:
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

  // Ins, Delete és Enter billentyûk feldolgozása:
  public void keyPressed(KeyEvent e) {
      // Új szöveg bekérése és beszúrása a listába:
      if (e.getKeyCode() == e.VK_INSERT) {
        String str = "";
        str = JOptionPane.showInputDialog(this,"Szöveg: ");
        if (str != null)
          addString(str);
      }
      // Az aktuális listaelem törlése:
      else if (e.getKeyCode() == e.VK_DELETE) {
        int index = list.getSelectedIndex();
        if (index >= 0) {
          md.remove(index);
          if (index <= md.size())
            list.setSelectedIndex(index);
        }
      }
      // Az aktuális listaelem módosítása:
      else if (e.getKeyCode() == e.VK_ENTER) {
        int index = list.getSelectedIndex();
        if (!md.isEmpty() && index >= 0) {
          String str = (String)md.get(index);
          str = JOptionPane.showInputDialog(this,"Szöveg: ");
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
