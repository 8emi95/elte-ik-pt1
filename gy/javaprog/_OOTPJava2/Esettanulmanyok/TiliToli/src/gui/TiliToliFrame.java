/*
 * Projekt: Tilitoli
 *
 * Csomag: gui
 * TiliToliFrame.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * A j�k�k f�ablaka. Tartalmazza a men�t a j�t�kot �s a dial�gusokat.
 */

package gui;

import play.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import extra.util.Files; // objektumot lemezre ki�r� �s beolvas� rutinok
import extra.hu.HuOptionPane;    // magyar dial�gusok
import extra.window.ListWindow;  // list�t megjelen�t� ablak

/* A f� ablak egy PlayObserver (megfigyel�). Ha a j�t�k befejez�dik,
 * megh�v�sra ker�l az endOfPlay met�dusa.
 */
public class TiliToliFrame extends JFrame implements ActionListener, PlayObserver {
  private int nameN = 0;
  private Container cp = getContentPane();
  private String dataDir = "data";
  private String configFileName = "config.dat";
  private String resultFileName = "results.dat";

  private Config config = new Config(); // konfigur�ci�s objektum

  // H�rom fajta eredm�nylista a 3*3, 4*4 �s 5*5-�s j�t�kokhoz:
  private Vector[] results = new Vector[3];
  { // A h�rom vektor l�trehoz�sa:
    for (int i=0; i<3; i++)
      results[i] = new Vector();
  }

  private int playMode = 0; // aktu�lis eredm�nylista sorsz�ma
  private PlayPanel play;   // j�t�kpanel

  // Men�pontok:
  private JMenuItem miNewPlay;
  private JMenuItem miResult;
  private JMenuItem miConfig;
  private JMenuItem miExit;
  private JMenuItem miHelp;
  private JMenuItem miAbout;

  // Dial�gus- �s eredm�nyablakok:
  private HelpDialog helpDialog;
  private ConfigDialog configDialog;
  private AboutDialog aboutDialog;
  private NameDialog nameDialog;
  private ListWindow resultWindow;

   // Konstruktor:
  public TiliToliFrame() {
    setTitle("Tili-toli j�t�k");

    // A konfigur�ci� �s az eredm�nyek beolvas�sa:
    try {
      config = (Config)Files.readObject(dataDir + "/" + configFileName);
      results = (Vector[])Files.readObject(dataDir + "/" + resultFileName);
    }
    catch (Exception ex) {
      // Ha nem siker�lt, az �rt�kek alap�rtelmezettek lesznek.
    }
    // Az aktu�lis eredm�nylista sorsz�m�nak meghat�roz�sa:
    playMode = config.playMode; // 3*3 eset�n 0, 4*4 eset�n 1, ...

    // Ablak m�ret�nek be�ll�t�sa a legut�bb elmentett �llapot alapj�n:
    setBounds(config.bounds);

    // Men� fel�p�t�se:
    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);

    JMenu mPlay = new JMenu("J�t�k");
    mPlay.setMnemonic('J');
    mb.add(mPlay);
    mPlay.add(miNewPlay = new JMenuItem("�j j�t�k",'�'));
    mPlay.addSeparator();
    mPlay.add(miResult = new JMenuItem("Eredm�nylista",'E'));
    mPlay.add(miConfig = new JMenuItem("Be�ll�t�sok",'B'));
    mPlay.addSeparator();
    mPlay.add(miExit = new JMenuItem("Kil�p�s",'K'));

    JMenu mHelp = new JMenu("S�g�");
    mHelp.setMnemonic('S');
    mb.add(mHelp);
    mHelp.add(miHelp = new JMenuItem("Seg�ts�g",'S'));
    mHelp.addSeparator();
    mHelp.add(miAbout = new JMenuItem("N�vjegy"));

    miNewPlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));

    // Esem�nyforr�sok hallgat�sa:
    miNewPlay.addActionListener(this);
    miResult.addActionListener(this);
    miConfig.addActionListener(this);
    miExit.addActionListener(this);
    miHelp.addActionListener(this);
    miAbout.addActionListener(this);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        endOfProgram();
      }
    });

    /* Ablakok l�trehoz�sa. Minden ablakot egyszer hozunk l�tre,
     * ezut�n csak elrejtj�k/megmutatjuk azokat.
     */
    helpDialog = new HelpDialog(this);
    aboutDialog = new AboutDialog(this);
    configDialog = new ConfigDialog(this);
    nameDialog = new NameDialog(this);
    resultWindow = new ListWindow(this,"","    J�t�kos neve           Id�   L�p�ssz�m ");

    // A j�t�k l�trehoz�sa �s elind�t�sa:
    cp.add(play = new PlayPanel(this,config.rows(),config.cols()));
    show();
    play.start();
  }

  // Az aktu�lis eredm�nylista ki�r�sa tesztel�skor:
  void kiir() {
    for (int j = 0; j < results[playMode].size(); j++) {
      System.out.println(results[playMode].get(j));
    }
  }

  /* J�t�k v�ge. A j�t�k eredm�nye result. K�t eset lehets�ges:
   * - az eredm�ny nem ker�lhet be a top list�ba. Ekkor a program sajn�lkozik.
   * - az eredm�ny beker�lhet a top list�ba. Ekkor bek�ri a j�t�kos nev�t,
   *   �s ha azt t�nyleg be�t�tt�k, akkor az eredm�ny rendezve beker�l
   *   a results[playMode] list�ba.
   */
  public void endOfPlay(Result result) {
    Vector res = results[playMode];  // ideiglenes referencia
    boolean bekerulhet = true;  // bekerulhet-e a list�ba az eredm�ny

    // Ha tele van a lista, hasonl�t�s az utols� eredm�nyhez:
    if (res.size()>=config.maxNumberOfResults[playMode]) {
      Result lastResult = (Result)(res.get(res.size()-1));
      if (result.compareTo(lastResult)>0) {
        // Az eddigi utols� ut�n van:
        HuOptionPane.showMessageDialog(this,"J�, de nincs a legjobbak k�zt!");
        bekerulhet = false;
      }
    }
    if (bekerulhet) {
      /* Az eredm�ny beker�lhet a list�ba. Ha a lista nagyobb a
       * maxim�lis m�retn�l, az utols� eredm�nyt lev�gjuk.
       */

      String name = nameDialog.getName();
      if (name==null)
        return;
      result.setName(name);

      // result besz�r�sa res-be rendezetten:
      int pos=0;
      for (; pos<res.size(); pos++)
        if (result.compareTo(res.get(pos))<0)
          break;
      res.add(pos,result);

      // Ha res hosszabb, mint a maxim�lis m�ret, lev�g�s:
      if (res.size()>config.maxNumberOfResults[playMode])
        res.setSize(config.maxNumberOfResults[playMode]);
    }
  }

  /* Program v�ge. A konfigur�ci� �s az eredm�nyek elment�se.
   */
  void endOfProgram() {
    File f = new File(dataDir);
    if (!f.exists())
      f.mkdir();

    config.bounds = getBounds();
    try {
      Files.writeObject(dataDir + "/" + configFileName,config);
      Files.writeObject(dataDir + "/" + resultFileName,results);
    }
    catch (Exception ex) {
      HuOptionPane.showMessageDialog(this,"Hiba a f�jl �r�s�n�l! "+ex);
    }
    System.exit(0);
  }

  // Esem�nyek lekezel�se:
  public void actionPerformed(ActionEvent e) {

    // �j j�t�k:
    if (e.getSource() == miNewPlay) {
      play.start();
    }

    /* Eredm�nylista. Az aktu�lis m�d toplist�j�nak megjelen�t�se
     * egy ListWindow-ban. Az ablak mod�lis. Az ablakban t�r�lhetik a list�t.
     */
    else if (e.getSource() == miResult) {
      resultWindow.setTitle("Eredm�nyek. "+config.rows()+"x"+config.cols()+
           ",  "+config.maxNumberOfResults[playMode]+" legjobb");
      resultWindow.showList(results[playMode]);
    }

    // Be�ll�t�sok (konfigur�ci� szerkeszt�se):
    else if (e.getSource() == miConfig) {
      Config newConfig = configDialog.getConfig(config);
      if (newConfig==null)
        return;
      else {
        config = newConfig;
        // A list�k hossz�nak lecsap�sa, ha sz�ks�ges:
        for (int i = 0; i < results.length; i++)
          if (results[i].size() > config.maxNumberOfResults[i])
            results[i].setSize(config.maxNumberOfResults[i]);

        playMode = config.playMode;

        // A konfigur�ci� megv�ltoztat�sa ut�n �j j�t�k indul:
        cp.remove(play);
        cp.add(play = new PlayPanel(this,config.rows(),config.cols()));
        validate();
        play.start();
      }
    }

    // Kil�p�s a programb�l:
    else if (e.getSource() == miExit) {
      endOfProgram();
    }

    // Help ablak megjelen�t�se:
    else if (e.getSource() == miHelp) {
      helpDialog.show();
    }

    // N�vjegy ablak megjelen�t�se:
    else if (e.getSource() == miAbout) {
      aboutDialog.show();
    }
  } // actionPerformed

} // TiliToliFrame
