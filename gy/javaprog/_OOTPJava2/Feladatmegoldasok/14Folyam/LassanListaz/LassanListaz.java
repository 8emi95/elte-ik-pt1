/*
 * Feladatmegoldások/14. fejezet
 * LassanListaz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LassanListaz extends JFrame implements ActionListener {
  private JTextArea taLista;
  private String fNev = null;

  // Az listázást az idõzítõ vezérli:
  private Timer idozito = new Timer(50,this);
  private FileReader fr = null;

  public LassanListaz(String fNev) {
    setBounds(100,100,800,600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.fNev = fNev;
    setTitle(fNev);
    taLista = new JTextArea();
    getContentPane().add(new JScrollPane(taLista));
    taLista.setEditable(false);
    taLista.setFont(new Font("Courier",Font.PLAIN,14));
    show();
    // Megnyitjuk az állományt, és elindítjuk az idõzítõt:
    megnyit(fNev);
    idozito.start();
  }

  // Az állomány megnyitása:
  void megnyit(String fNev) {
    try {
      fr = new FileReader(fNev);
    }
    catch (FileNotFoundException e) {
      System.out.println("A megadott állomány ("+fNev+") nem létezik!");
      System.exit(0);
    }
  }

  // Az állomány bezárása:
  void bezar() {
    try {
      fr.close();
      taLista.setCaretPosition(taLista.getText().length());
    }
    catch (IOException ex) {
      System.out.println("I/O hiba!");
      System.exit(0);
    }
  }

  // Ha az eseményt az idõzítõ generálta, akkor olvasunk egy karaktert
  // az állományból. Az állomány végéhez érve leállítjuk az idõzítõt,
  // és lezárjuk az állományt:
  public void actionPerformed(ActionEvent e) {
    if (e.getSource()!=idozito)
      return;
    int b;
    try {
      b = fr.read();
      if (b != -1)
        taLista.append(""+(char)b);
      else {
        idozito.stop();
        bezar();
      }
    }
    catch (IOException ex) {
      System.out.println("I/O hiba!");
      System.exit(0);
    }
  } // actionPerformed

  public static void main (String[] args) {
    if (args.length>0)
      new LassanListaz(args[0]);
    else
      new LassanListaz("c:/javaprog/readme.txt");
    // Még egyet listázunk az elõzõvel párhuzamosan (nézzen a keret alá!):
    new LassanListaz("c:/javaprog/work/proba/FileAttributes.java");
  } // main
} // ListFile
