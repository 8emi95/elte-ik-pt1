/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: gui
 * MainFrame.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
  // Konténer, a "szemelyek.dat" állományt kezeli:
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
    // GUI felépítése:
    setTitle("Címjegyzék");
    setBounds(200,200,300,200);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    JMenuBar mb;
    JMenu mFajl, mSegitseg;
    setJMenuBar(mb = new JMenuBar());
    mb.add(mFajl = new JMenu("Fájl"));
    mFajl.setMnemonic('F');
    mFajl.add(miHozzaad = new JMenuItem("Hozzáad",'H'));
    mFajl.add(miModosit = new JMenuItem("Módosít",'M'));
    mFajl.add(miTorol = new JMenuItem("Töröl",'T'));
    mFajl.addSeparator();
    mFajl.add(miKilep = new JMenuItem("Kilép",'K'));
    mb.add(mSegitseg = new JMenu("Súgó"));
    mSegitseg.setMnemonic('S');
    mSegitseg.add(miSegitseg = new JMenuItem("Segítség",'S'));
    mSegitseg.addSeparator();
    mSegitseg.add(miNevjegy = new JMenuItem("Névjegy",'N'));

    miHozzaad.addActionListener(this);
    miModosit.addActionListener(this);
    miTorol.addActionListener(this);
    miKilep.addActionListener(this);
    miSegitseg.addActionListener(this);
    miNevjegy.addActionListener(this);

    JPanel pnButtons;
    cp.add(pnButtons = new JPanel(),"South");
    pnButtons.add(btHozzaad = new JButton("Hozzáad"));
    pnButtons.add(btModosit = new JButton("Módosít"));
    pnButtons.add(btTorol = new JButton("Töröl"));
    btHozzaad.setMnemonic('H');
    btModosit.setMnemonic('M');
    btTorol.setMnemonic('T');
    btHozzaad.addActionListener(this);
    btModosit.addActionListener(this);
    btTorol.addActionListener(this);

    // File kapcsolat kiépítése, a lista elkészítése:
    try {
      szemelyek = new Szemelyek("adatok/szemelyek.dat");
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(this,
        "Hiba a fájl megnyitásakor!","",JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }

    // A lista adatmodelljét a kulcsbejegyzésekkel inicializáljuk:
    lstSzemelyek = new JList(szemelyek.keyEntries);
    // Rátesszük egy görgetõpanelre:
    cp.add(new JScrollPane(lstSzemelyek),"Center");
    // Csak egy tételt lehet kiválasztani egyszerre:
    lstSzemelyek.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    // Kezdetben az elsõ elem a kiválasztott, ha van ilyen:
    if (lstSzemelyek.getModel().getSize()!=0)
      lstSzemelyek.setSelectedIndex(0);

    // A felvitel, a módosítás és a törlés billentyûkre is hívható:
    this.addKeyListener(this);
    show();
    lstSzemelyek.requestFocus();

    // A dialógusokat létrehozzuk, majd igény szerint mutogatjuk õket:
    diaNevjegy = new NevjegyDialog(this);
    diaSegitseg = new SegitsegDialog(this);
    diaSzemely = new SzemelyDialog(this);
  }

  // Új személy adatainak felvitele:
  public void hozzaad() {
    Szemely szemely = new Szemely();
    // Egy személy objektum összeállítása:
    if (diaSzemely.showDialog(szemely)) {
      try {
        // A személy eltárolása:
        szemelyek.addSzemely(szemely);
        // A lista adatmodelljének frissítése:
        lstSzemelyek.setListData(szemelyek.keyEntries);
      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(this,
          "Hiba a fájl írásakor!","",JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  // Már létezõ személy adatainak módosítása:
  public void modosit() {
    // index a kiválasztott listaelem indexe:
    int index = lstSzemelyek.getSelectedIndex();
    // Ha nem választottak ki semmit, nem módosítunk:
    if (index == -1)
      return;
    try {
      // Elkérjük a tárolótól a névsorban az indexedik személyt:
      Szemely szemely = szemelyek.getSzemely(index);
      // Felkínáljuk a szmélyt módosításra:
      if (diaSzemely.showDialog(szemely)) {
        try {
          // Kicseréljük a tárolóban az index. személyt.
          // Ezután lehet, hogy más lesz az indexe:
          szemelyek.replaceSzemely(szemely,index);
          // A lista adatmodelljének frissítése:
          lstSzemelyek.setListData(szemelyek.keyEntries);
          // Ugyanaz a sorszámú elem marad kiválasztva:
          lstSzemelyek.setSelectedIndex(index);
        }
        catch (IOException ex) {
          JOptionPane.showMessageDialog(this,
            "Hiba a fájl írásakor!","",JOptionPane.ERROR_MESSAGE);
        }
      }
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(this,
        "Hiba a fájl írásakor!","",JOptionPane.ERROR_MESSAGE);
    }
  }

  // Már létezõ személy törlése
  public void torol() {
    // Az index. személyt akarják tötölni:
    int index = lstSzemelyek.getSelectedIndex();
    if (index == -1)
      return;
    if (tenyleg("Biztosan törölni akarja?")) {
      try {
        // Kitöröljük a személyt a tárolóból:
        szemelyek.removeSzemely(index);
        // A lista adatmodelljének frissítése:
        lstSzemelyek.setListData(szemelyek.keyEntries);
      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(this,
          "Hiba a fájl írásakor!","",JOptionPane.ERROR_MESSAGE);
      }
      // A kiválasztást szükség esetén módosítjuk.
      // Ha a lista nem üres, és az utolsó elemt töröltük,
      // akkor eggyel elõrébb állunk.
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

  // INSERT-re felvitel, ENTER-er módosítás, DELETE billentyûre törlés:
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

  // Az message kérdésre Igen/Nem választ vár. true, ha igen:
  boolean tenyleg(String message) {
    Object[] opciok = {"Igen","Nem"};
    int valasz = JOptionPane.showOptionDialog(this,
      message,"",JOptionPane.DEFAULT_OPTION,
      JOptionPane.WARNING_MESSAGE,null,opciok,opciok[1]);
    return valasz==0;
  }
}
