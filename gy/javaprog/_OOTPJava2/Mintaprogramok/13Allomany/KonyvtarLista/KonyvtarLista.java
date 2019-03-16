/*
 * Mintaprogramok/13. fejezet
 * KonyvtarLista.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class KonyvtarArea extends JTextArea {
  private int maxSzint = 5; // kiírandó szintek maximális száma
  private File dir;
  private int szint;

  public void setKonyvtar(File dir) {
    this.dir = dir;
    szint = 0;
    setFont(new Font("Monospaced",Font.PLAIN,12));
    setText("");   // szövegterület törlése
    konyvtarLista(dir);
  }

  private void konyvtarLista(File f) {
    if (!f.exists()) {
      append("Nemlétezõ bejegyzés!");
      return;
    }
    append(szokoz(szint)+f.getName()+"\n");
    if (f.isFile())
      return;

    if (szint < maxSzint) {
      szint++;
      String[] fList = f.list();
      for (int i=0; i<fList.length; i++)
        konyvtarLista(new File(f.getAbsolutePath()+
                               File.separator+fList[i]));
      szint--;
    }
  }

  private String szokoz(int eltolas) {
    String str = "";
    for (int i=0; i<eltolas; i++)
      str = str+"  ";
    return str;
  }
}

public class KonyvtarLista extends JFrame
                                 implements ActionListener {
  private JMenuBar mb;
  private JMenuItem miUjKonyvtar;
  private JMenuItem miBezaras;
  private KonyvtarArea taKonyvtar;
  private JFileChooser fc = new JFileChooser();

  public KonyvtarLista() {
    setTitle("Könyvtárlista");
    setBounds(200,100,500,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setJMenuBar(mb = new JMenuBar());
    JMenu mFajl = new JMenu("Fájl");
    mb.add(mFajl);
    mFajl.add(miUjKonyvtar = new JMenuItem("Új könyvtár"));
    mFajl.add(miBezaras = new JMenuItem("Bezárás"));
    miUjKonyvtar.addActionListener(this);
    miBezaras.addActionListener(this);
    taKonyvtar = new KonyvtarArea();
    getContentPane().add(new JScrollPane(taKonyvtar));
    fc.setDialogTitle("Válasszon ki egy könyvtárat!");
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    fc.setCurrentDirectory(new File("C:/"));
    show();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==miUjKonyvtar) {
      if (fc.showOpenDialog(this)==fc.APPROVE_OPTION) {
        taKonyvtar.setKonyvtar(fc.getSelectedFile());
        setTitle(fc.getSelectedFile().getAbsolutePath());
      }
    }
    else if (e.getSource()==miBezaras)
      System.exit(0);
  }

  public static void main(String[] args) {
    new KonyvtarLista();
  }
} // KonyvtarLista
