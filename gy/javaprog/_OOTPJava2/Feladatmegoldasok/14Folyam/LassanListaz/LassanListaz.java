/*
 * Feladatmegold�sok/14. fejezet
 * LassanListaz.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LassanListaz extends JFrame implements ActionListener {
  private JTextArea taLista;
  private String fNev = null;

  // Az list�z�st az id�z�t� vez�rli:
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
    // Megnyitjuk az �llom�nyt, �s elind�tjuk az id�z�t�t:
    megnyit(fNev);
    idozito.start();
  }

  // Az �llom�ny megnyit�sa:
  void megnyit(String fNev) {
    try {
      fr = new FileReader(fNev);
    }
    catch (FileNotFoundException e) {
      System.out.println("A megadott �llom�ny ("+fNev+") nem l�tezik!");
      System.exit(0);
    }
  }

  // Az �llom�ny bez�r�sa:
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

  // Ha az esem�nyt az id�z�t� gener�lta, akkor olvasunk egy karaktert
  // az �llom�nyb�l. Az �llom�ny v�g�hez �rve le�ll�tjuk az id�z�t�t,
  // �s lez�rjuk az �llom�nyt:
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
    // M�g egyet list�zunk az el�z�vel p�rhuzamosan (n�zzen a keret al�!):
    new LassanListaz("c:/javaprog/work/proba/FileAttributes.java");
  } // main
} // ListFile
