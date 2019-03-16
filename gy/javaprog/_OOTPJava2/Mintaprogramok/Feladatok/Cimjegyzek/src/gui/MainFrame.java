/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: gui
 * MainFrame.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package gui;
import db.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainFrame extends JFrame implements
                       ActionListener, KeyListener {
  // Kont�ner, a "szemelyek.dat" �llom�nyt kezeli:
  private Szemelyek szemelyek;

  private Container cp = getContentPane();
  private JMenuItem miHozzaad, miModosit, miTorol, miKilep;
  private JMenuItem miSegitseg, miNevjegy;

  private JButton btHozzaad, btModosit, btTorol;
  private NevjegyDialog diaNevjegy = null;
  private SegitsegDialog diaSegitseg = null ;
  private SzemelyDialog diaSzemely = null;

  private JList lstSzemelyek;

  public MainFrame() {
    // GUI fel�p�t�se:
    setTitle("C�mjegyz�k");
    setBounds(200,200,300,200);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    JMenuBar mb;
    JMenu mFajl, mSegitseg;
    setJMenuBar(mb = new JMenuBar());
    mb.add(mFajl = new JMenu("F�jl"));
    mFajl.setMnemonic('F');
    mFajl.add(miHozzaad = new JMenuItem("Hozz�ad",'H'));
    mFajl.add(miModosit = new JMenuItem("M�dos�t",'M'));
    mFajl.add(miTorol = new JMenuItem("T�r�l",'T'));
    mFajl.addSeparator();
    mFajl.add(miKilep = new JMenuItem("Kil�p",'K'));
    mb.add(mSegitseg = new JMenu("S�g�"));
    mSegitseg.setMnemonic('S');
    mSegitseg.add(miSegitseg = new JMenuItem("Seg�ts�g",'S'));
    mSegitseg.addSeparator();
    mSegitseg.add(miNevjegy = new JMenuItem("N�vjegy",'N'));

    miHozzaad.addActionListener(this);
    miModosit.addActionListener(this);
    miTorol.addActionListener(this);
    miKilep.addActionListener(this);
    miSegitseg.addActionListener(this);
    miNevjegy.addActionListener(this);

    JPanel pnButtons;
    cp.add(pnButtons = new JPanel(),"South");
    pnButtons.add(btHozzaad = new JButton("Hozz�ad"));
    pnButtons.add(btModosit = new JButton("M�dos�t"));
    pnButtons.add(btTorol = new JButton("T�r�l"));
    btHozzaad.setMnemonic('H');
    btModosit.setMnemonic('M');
    btTorol.setMnemonic('T');
    btHozzaad.addActionListener(this);
    btModosit.addActionListener(this);
    btTorol.addActionListener(this);

    // File kapcsolat ki�p�t�se, a lista elk�sz�t�se:
    try {
      szemelyek = new Szemelyek("adatok/szemelyek.dat");
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(this,
        "Hiba a f�jl megnyit�sakor!","",JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }

    // A lista adatmodellj�t a kulcsbejegyz�sekkel inicializ�ljuk:
    lstSzemelyek = new JList(szemelyek.keyEntries);
    // R�tessz�k egy g�rget�panelre:
    cp.add(new JScrollPane(lstSzemelyek),"Center");
    // Csak egy t�telt lehet kiv�lasztani egyszerre:
    lstSzemelyek.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    // Kezdetben az els� elem a kiv�lasztott, ha van ilyen:
    if (lstSzemelyek.getModel().getSize()!=0)
      lstSzemelyek.setSelectedIndex(0);

    // A felvitel, a m�dos�t�s �s a t�rl�s billenty�kre is h�vhat�:
    this.addKeyListener(this);
    show();
    lstSzemelyek.requestFocus();

    // A dial�gusokat l�trehozzuk, majd ig�ny szerint mutogatjuk �ket:
    diaNevjegy = new NevjegyDialog(this);
    diaSegitseg = new SegitsegDialog(this);
    diaSzemely = new SzemelyDialog(this);
  }

  // �j szem�ly adatainak felvitele:
  public void hozzaad() {
    Szemely szemely = new Szemely();
    // Egy szem�ly objektum �ssze�ll�t�sa:
    if (diaSzemely.showDialog(szemely)) {
      try {
        // A szem�ly elt�rol�sa:
        szemelyek.addSzemely(szemely);
        // A lista adatmodellj�nek friss�t�se:
        lstSzemelyek.setListData(szemelyek.keyEntries);
      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(this,
          "Hiba a f�jl �r�sakor!","",JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  // M�r l�tez� szem�ly adatainak m�dos�t�sa:
  public void modosit() {
    // index a kiv�lasztott listaelem indexe:
    int index = lstSzemelyek.getSelectedIndex();
    // Ha nem v�lasztottak ki semmit, nem m�dos�tunk:
    if (index == -1)
      return;
    try {
      // Elk�rj�k a t�rol�t�l a n�vsorban az indexedik szem�lyt:
      Szemely szemely = szemelyek.getSzemely(index);
      // Felk�n�ljuk a szm�lyt m�dos�t�sra:
      if (diaSzemely.showDialog(szemely)) {
        try {
          // Kicser�lj�k a t�rol�ban az index. szem�lyt.
          // Ezut�n lehet, hogy m�s lesz az indexe:
          szemelyek.replaceSzemely(szemely,index);
          // A lista adatmodellj�nek friss�t�se:
          lstSzemelyek.setListData(szemelyek.keyEntries);
          // Ugyanaz a sorsz�m� elem marad kiv�lasztva:
          lstSzemelyek.setSelectedIndex(index);
        }
        catch (IOException ex) {
          JOptionPane.showMessageDialog(this,
            "Hiba a f�jl �r�sakor!","",JOptionPane.ERROR_MESSAGE);
        }
      }
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(this,
        "Hiba a f�jl �r�sakor!","",JOptionPane.ERROR_MESSAGE);
    }
  }

  // M�r l�tez� szem�ly t�rl�se
  public void torol() {
    // Az index. szem�lyt akarj�k t�t�lni:
    int index = lstSzemelyek.getSelectedIndex();
    if (index == -1)
      return;
    if (tenyleg("Biztosan t�r�lni akarja?")) {
      try {
        // Kit�r�lj�k a szem�lyt a t�rol�b�l:
        szemelyek.removeSzemely(index);
        // A lista adatmodellj�nek friss�t�se:
        lstSzemelyek.setListData(szemelyek.keyEntries);
      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(this,
          "Hiba a f�jl �r�sakor!","",JOptionPane.ERROR_MESSAGE);
      }
      // A kiv�laszt�st sz�ks�g eset�n m�dos�tjuk.
      // Ha a lista nem �res, �s az utols� elemt t�r�lt�k,
      // akkor eggyel el�r�bb �llunk.
      int size = lstSzemelyek.getModel().getSize();
      if (size > 0) {
        if (index==size)
          index--;
        lstSzemelyek.setSelectedIndex(index);
      }
    }
  }

  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src==miNevjegy) {
      diaNevjegy.setVisible(true);
    }
    else if (src==miSegitseg) {
      diaSegitseg.setVisible(true);
    }
    else if (src==btHozzaad || src==miHozzaad) {
      hozzaad();
    }
    else if (src==btModosit || src==lstSzemelyek) {
      modosit();
    }
    else if (src==btTorol) {
      torol();
    }
    else if (src==miKilep) {
      try {
        szemelyek.close();
      }
      catch (IOException ex) {
        System.out.println(ex);
      }
      System.exit(0);
    }
    lstSzemelyek.requestFocus();
  }

  public void keyTyped(KeyEvent e) {
  }

  // INSERT-re felvitel, ENTER-er m�dos�t�s, DELETE billenty�re t�rl�s:
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_INSERT)
      hozzaad();
    else if (e.getKeyCode()==KeyEvent.VK_ENTER)
      modosit();
    else if (e.getKeyCode()==KeyEvent.VK_DELETE)
      torol();
  }

  public void keyReleased(KeyEvent e) {
  }

  // Az message k�rd�sre Igen/Nem v�laszt v�r. true, ha igen:
  boolean tenyleg(String message) {
    Object[] opciok = {"Igen","Nem"};
    int valasz = JOptionPane.showOptionDialog(this,
      message,"",JOptionPane.DEFAULT_OPTION,
      JOptionPane.WARNING_MESSAGE,null,opciok,opciok[1]);
    return valasz==0;
  }
}
