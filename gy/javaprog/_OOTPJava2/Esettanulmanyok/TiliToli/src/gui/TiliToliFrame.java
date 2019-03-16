/*
 * Projekt: Tilitoli
 *
 * Csomag: gui
 * TiliToliFrame.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * A jákék fõablaka. Tartalmazza a menüt a játékot és a dialógusokat.
 */

package gui;

import play.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import extra.util.Files; // objektumot lemezre kiíró és beolvasó rutinok
import extra.hu.HuOptionPane;    // magyar dialógusok
import extra.window.ListWindow;  // listát megjelenítõ ablak

/* A fõ ablak egy PlayObserver (megfigyelõ). Ha a játék befejezõdik,
 * meghívásra kerül az endOfPlay metódusa.
 */
public class TiliToliFrame extends JFrame implements ActionListener, PlayObserver {
  private int nameN = 0;
  private Container cp = getContentPane();
  private String dataDir = "data";
  private String configFileName = "config.dat";
  private String resultFileName = "results.dat";

  private Config config = new Config(); // konfigurációs objektum

  // Három fajta eredménylista a 3*3, 4*4 és 5*5-ös játékokhoz:
  private Vector[] results = new Vector[3];
  { // A három vektor létrehozása:
    for (int i=0; i<3; i++)
      results[i] = new Vector();
  }

  private int playMode = 0; // aktuális eredménylista sorszáma
  private PlayPanel play;   // játékpanel

  // Menüpontok:
  private JMenuItem miNewPlay;
  private JMenuItem miResult;
  private JMenuItem miConfig;
  private JMenuItem miExit;
  private JMenuItem miHelp;
  private JMenuItem miAbout;

  // Dialógus- és eredményablakok:
  private HelpDialog helpDialog;
  private ConfigDialog configDialog;
  private AboutDialog aboutDialog;
  private NameDialog nameDialog;
  private ListWindow resultWindow;

   // Konstruktor:
  public TiliToliFrame() {
    setTitle("Tili-toli játék");

    // A konfiguráció és az eredmények beolvasása:
    try {
      config = (Config)Files.readObject(dataDir + "/" + configFileName);
      results = (Vector[])Files.readObject(dataDir + "/" + resultFileName);
    }
    catch (Exception ex) {
      // Ha nem sikerült, az értékek alapértelmezettek lesznek.
    }
    // Az aktuális eredménylista sorszámának meghatározása:
    playMode = config.playMode; // 3*3 esetén 0, 4*4 esetén 1, ...

    // Ablak méretének beállítása a legutóbb elmentett állapot alapján:
    setBounds(config.bounds);

    // Menü felépítése:
    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);

    JMenu mPlay = new JMenu("Játék");
    mPlay.setMnemonic('J');
    mb.add(mPlay);
    mPlay.add(miNewPlay = new JMenuItem("Új játék",'Ú'));
    mPlay.addSeparator();
    mPlay.add(miResult = new JMenuItem("Eredménylista",'E'));
    mPlay.add(miConfig = new JMenuItem("Beállítások",'B'));
    mPlay.addSeparator();
    mPlay.add(miExit = new JMenuItem("Kilépés",'K'));

    JMenu mHelp = new JMenu("Súgó");
    mHelp.setMnemonic('S');
    mb.add(mHelp);
    mHelp.add(miHelp = new JMenuItem("Segítség",'S'));
    mHelp.addSeparator();
    mHelp.add(miAbout = new JMenuItem("Névjegy"));

    miNewPlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));

    // Eseményforrások hallgatása:
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

    /* Ablakok létrehozása. Minden ablakot egyszer hozunk létre,
     * ezután csak elrejtjük/megmutatjuk azokat.
     */
    helpDialog = new HelpDialog(this);
    aboutDialog = new AboutDialog(this);
    configDialog = new ConfigDialog(this);
    nameDialog = new NameDialog(this);
    resultWindow = new ListWindow(this,"","    Játékos neve           Idõ   Lépésszám ");

    // A játék létrehozása és elindítása:
    cp.add(play = new PlayPanel(this,config.rows(),config.cols()));
    show();
    play.start();
  }

  // Az aktuális eredménylista kiírása teszteléskor:
  void kiir() {
    for (int j = 0; j < results[playMode].size(); j++) {
      System.out.println(results[playMode].get(j));
    }
  }

  /* Játék vége. A játék eredménye result. Két eset lehetséges:
   * - az eredmény nem kerülhet be a top listába. Ekkor a program sajnálkozik.
   * - az eredmény bekerülhet a top listába. Ekkor bekéri a játékos nevét,
   *   és ha azt tényleg beütötték, akkor az eredmény rendezve bekerül
   *   a results[playMode] listába.
   */
  public void endOfPlay(Result result) {
    Vector res = results[playMode];  // ideiglenes referencia
    boolean bekerulhet = true;  // bekerulhet-e a listába az eredmény

    // Ha tele van a lista, hasonlítás az utolsó eredményhez:
    if (res.size()>=config.maxNumberOfResults[playMode]) {
      Result lastResult = (Result)(res.get(res.size()-1));
      if (result.compareTo(lastResult)>0) {
        // Az eddigi utolsó után van:
        HuOptionPane.showMessageDialog(this,"Jó, de nincs a legjobbak közt!");
        bekerulhet = false;
      }
    }
    if (bekerulhet) {
      /* Az eredmény bekerülhet a listába. Ha a lista nagyobb a
       * maximális méretnél, az utolsó eredményt levágjuk.
       */

      String name = nameDialog.getName();
      if (name==null)
        return;
      result.setName(name);

      // result beszúrása res-be rendezetten:
      int pos=0;
      for (; pos<res.size(); pos++)
        if (result.compareTo(res.get(pos))<0)
          break;
      res.add(pos,result);

      // Ha res hosszabb, mint a maximális méret, levágás:
      if (res.size()>config.maxNumberOfResults[playMode])
        res.setSize(config.maxNumberOfResults[playMode]);
    }
  }

  /* Program vége. A konfiguráció és az eredmények elmentése.
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
      HuOptionPane.showMessageDialog(this,"Hiba a fájl írásánál! "+ex);
    }
    System.exit(0);
  }

  // Események lekezelése:
  public void actionPerformed(ActionEvent e) {

    // Új játék:
    if (e.getSource() == miNewPlay) {
      play.start();
    }

    /* Eredménylista. Az aktuális mód toplistájának megjelenítése
     * egy ListWindow-ban. Az ablak modális. Az ablakban törölhetik a listát.
     */
    else if (e.getSource() == miResult) {
      resultWindow.setTitle("Eredmények. "+config.rows()+"x"+config.cols()+
           ",  "+config.maxNumberOfResults[playMode]+" legjobb");
      resultWindow.showList(results[playMode]);
    }

    // Beállítások (konfiguráció szerkesztése):
    else if (e.getSource() == miConfig) {
      Config newConfig = configDialog.getConfig(config);
      if (newConfig==null)
        return;
      else {
        config = newConfig;
        // A listák hosszának lecsapása, ha szükséges:
        for (int i = 0; i < results.length; i++)
          if (results[i].size() > config.maxNumberOfResults[i])
            results[i].setSize(config.maxNumberOfResults[i]);

        playMode = config.playMode;

        // A konfiguráció megváltoztatása után új játék indul:
        cp.remove(play);
        cp.add(play = new PlayPanel(this,config.rows(),config.cols()));
        validate();
        play.start();
      }
    }

    // Kilépés a programból:
    else if (e.getSource() == miExit) {
      endOfProgram();
    }

    // Help ablak megjelenítése:
    else if (e.getSource() == miHelp) {
      helpDialog.show();
    }

    // Névjegy ablak megjelenítése:
    else if (e.getSource() == miAbout) {
      aboutDialog.show();
    }
  } // actionPerformed

} // TiliToliFrame
