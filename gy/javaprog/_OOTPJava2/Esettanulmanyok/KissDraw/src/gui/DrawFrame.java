/*
 * Projekt: KissDraw
 *
 * Csomag: gui
 * DrawFrame.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import drawing.*;
import java.io.*;
import extra.hu.HuFileManager; // magyarul "beszélõ" fileManager

// Az alkalmazás fõablaka.
public class DrawFrame extends JFrame implements ActionListener, MouseMotionListener {
  private Container cp = getContentPane();
  private String dataDir = "data";       // az adatok induló könyvtára
  private String dataExtension = "draw";  // az adatok alapértelmezett kiterjesztése

  // Eszköztár és elemei:
  private JPanel toolBar = new JPanel();
  private ToolToggleButton btSelect, btLine, btRect, btOval, btFreeline;
  private ToolCheckBox cbGridVisible;
  private ToolCheckBox cbGridAlign;
  private JLabel lbBackground;  // háttérszínt mutatja
  private JLabel lbColor;       // rajzolószínt mutatja

  private DrawPanel drawPanel;     // rajzlap
  private HuFileManager fileManager; // drawPanel fájlkapcsolata

  // Státuszsor és kijelzõi:
  private JPanel statusBar = new JPanel();
  private JLabel lbX, lbY, lbFileName;

  private HelpDialog helpDialog;
  private AboutDialog aboutDialog;

  // Menü:
  private JMenuBar menubar = new JMenuBar();

  // Fájl menü:
  private JMenu mFile = new JMenu();
  private JMenuItem miNew = new JMenuItem();
  private JMenuItem miOpen = new JMenuItem();
  private JMenuItem miSave = new JMenuItem();
  private JMenuItem miSaveAs = new JMenuItem();
  private JMenuItem miExit = new JMenuItem();

  // Szerkesztés menü:
  private JMenu mEdit = new JMenu();
  private JMenuItem miUndo = new JMenuItem();
  private JMenuItem miRedo = new JMenuItem();
  private JMenuItem miSelectAll = new JMenuItem();
  private JMenuItem miDel = new JMenuItem();
  private JMenuItem miDelAll = new JMenuItem();
  private JCheckBoxMenuItem cmiGridVisible = new JCheckBoxMenuItem();
  private JCheckBoxMenuItem cmiGridAlign = new JCheckBoxMenuItem();

  // Rajzolási mód menü:
  private JMenu mDrawingMode = new JMenu();
  private JRadioButtonMenuItem rbmSelect = new JRadioButtonMenuItem();
  private JRadioButtonMenuItem rbmLine = new JRadioButtonMenuItem();
  private JRadioButtonMenuItem rbmRect = new JRadioButtonMenuItem();
  private JRadioButtonMenuItem rbmOval = new JRadioButtonMenuItem();
  private JRadioButtonMenuItem rbmFreeline = new JRadioButtonMenuItem();

  // Színek menü:
  private JMenu mColor = new JMenu();
  private JMenuItem miBackground = new JMenuItem();
  private JMenuItem miForeground = new JMenuItem();

  // Súgó menü:
  private JMenu mHelp = new JMenu();
  private JMenuItem miHelp = new JMenuItem();
  private JMenuItem miAbout = new JMenuItem();

  // Konstruktor:
  public DrawFrame() {
    setTitle("Kiss Draw");

   // Az alkalmazás teljes képernyõs, csak alul hagyunk egy kis helyet:
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height-50);

    // A keret becsukását a program kezeli le:
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        exitProgram();
      }
    });

    buildToolBar(toolBar);     // eszköztár felépítése
    cp.add(toolBar,"North");   // eszköztár északra

    // Létrehozzuk a rajzlapot, s középre tesszük:
    drawPanel = new DrawPanel();
    cp.add(new JScrollPane(drawPanel));

    // A rajzlapon figyeljük az egér koordinátáit:
    drawPanel.addMouseMotionListener(this);

    // Státuszsor létrehozása és felépítése:
    cp.add(statusBar,"South");
    buildStatusBar(statusBar);

    /* A fájlmenedzser a rajzpanel mentését/betöltését felügyeli.
     * Ha nem létezik a dataDir könyvtár, akkor létrehozzuk.
     */
    fileManager = new HuFileManager(this,drawPanel);
    File f = new File(dataDir);
    if (!f.exists())
      f.mkdirs();
    fileManager.setCurrentDirectory(dataDir);
    fileManager.setExtension(dataExtension);
    fileManager.setDescription("Rajzok");

    // Menü felépítése:
    buildMenu();

    // Használati útmutató és névjegy:
    helpDialog = new HelpDialog(this);
    aboutDialog = new AboutDialog(this);

    show();
    updateMenu();
    updateToolBar();
    updateStatusBar();
  }

  /* Kilépés a programból.
   * Ha volt módosítás, akkor megengedjük a mentést.
   * Ha nem gondolta meg magát, akkor tényleg kilépünk.
   */
  void exitProgram() {
    if (fileManager.exit())
      System.exit(0);
  }

  ImageIcon img(String fName) {
    /* A DrawFrame osztály könyvtárában van a resources könyvtár, és abban az fName nevû fájl.
     */
    return new ImageIcon(getClass().getResource("/resources/"+fName));

    /* Ha a képeket a Working directory-ba tennénk, akkor a
     * környezetben jó, de nem tudnánk elérni a képeket egy
     * futtatható Jar fájlban:
     // return new ImageIcon("resources/"+fName);
     */
  }

  // A menü felépítése:
  void buildMenu() {
    setJMenuBar(menubar);

    // Fájl menü:
    menubar.add(mFile);
    mFile.setText("Fájl");
    mFile.setMnemonic('F');

    mFile.add(miNew);
    miNew.setText("Új");
    miNew.setActionCommand("new");
    miNew.addActionListener(this);
    miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK));

    mFile.add(miOpen);
    miOpen.setText("Megnyitás...");
    miOpen.setActionCommand("open");
    miOpen.addActionListener(this);
    miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));

    mFile.addSeparator();

    mFile.add(miSave);
    miSave.setText("Mentés");
    miSave.setActionCommand("save");
    miSave.addActionListener(this);
    miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));

    mFile.add(miSaveAs);
    miSaveAs.setText("Mentés másként...");
    miSaveAs.setActionCommand("saveas");
    miSaveAs.addActionListener(this);

    mFile.addSeparator();

    mFile.add(miExit);
    miExit.setText("Kilépés");
    miExit.setActionCommand("exit");
    miExit.addActionListener(this);
    miExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.ALT_MASK));

    // Szerkesztés menü:
    menubar.add(mEdit);
    mEdit.setText("Szerkesztés");
    mEdit.setMnemonic('E');

    mEdit.add(miUndo);
    miUndo.setText("Visszavonás");
    miUndo.setActionCommand("undo");
    miUndo.addActionListener(this);
    miUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,Event.CTRL_MASK));

    mEdit.add(miRedo);
    miRedo.setText("Ismét");
    miRedo.setActionCommand("redo");
    miRedo.addActionListener(this);
    miRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,Event.CTRL_MASK));

    mEdit.addSeparator();

    mEdit.add(miSelectAll);
    miSelectAll.setText("Összes kijelölése");
    miSelectAll.setActionCommand("selectAll");
    miSelectAll.addActionListener(this);
    miSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,Event.CTRL_MASK));

    mEdit.addSeparator();

    mEdit.add(miDel);
    miDel.setText("Kijelöltek törlése");
    miDel.setActionCommand("del");
    miDel.addActionListener(this);
    miDel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));

    mEdit.add(miDelAll);
    miDelAll.setText("Összes törlése");
    miDelAll.setActionCommand("delAll");
    miDelAll.addActionListener(this);
    miDelAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,Event.CTRL_MASK));

    mEdit.addSeparator();

    mEdit.add(cmiGridVisible);
    cmiGridVisible.setText("Rács látszik");
    cmiGridVisible.setActionCommand("gridVisible");
    cmiGridVisible.addActionListener(this);

    mEdit.add(cmiGridAlign);
    cmiGridAlign.setText("Rácsra igazítás");
    cmiGridAlign.setActionCommand("gridAlign");
    cmiGridAlign.addActionListener(this);

    // Rajzolási mód menü:
    menubar.add(mDrawingMode);
    mDrawingMode.setText("Rajzolási mód");
    mDrawingMode.setMnemonic('R');
    ButtonGroup bg = new ButtonGroup();

    mDrawingMode.add(rbmSelect);
    rbmSelect.setText("Kijelölés");
    rbmSelect.setActionCommand("select");
    rbmSelect.addActionListener(this);
    bg.add(rbmSelect);

    mDrawingMode.addSeparator();

    mDrawingMode.add(rbmLine);
    rbmLine.setText("Egyenes");
    rbmLine.setActionCommand("line");
    rbmLine.addActionListener(this);
    rbmLine.setSelected(true);
    bg.add(rbmLine);

    mDrawingMode.add(rbmRect);
    rbmRect.setText("Téglalap");
    rbmRect.setActionCommand("rect");
    rbmRect.addActionListener(this);
    bg.add(rbmRect);

    mDrawingMode.add(rbmOval);
    rbmOval.setText("Ellipszis");
    rbmOval.setActionCommand("oval");
    rbmOval.addActionListener(this);
    bg.add(rbmOval);

    mDrawingMode.add(rbmFreeline);
    rbmFreeline.setText("Szabadkézi");
    rbmFreeline.setActionCommand("freeline");
    rbmFreeline.addActionListener(this);
    bg.add(rbmFreeline);

    // Színek menü:
    menubar.add(mColor);
    mColor.setText("Színek");
    mColor.setMnemonic('C');

    mColor.add(miBackground);
    miBackground.setText("Háttérszín");
    miBackground.setActionCommand("background");
    miBackground.addActionListener(this);

    mColor.add(miForeground);
    miForeground.setText("Rajzolószín");
    miForeground.setActionCommand("foreground");
    miForeground.addActionListener(this);

    // Súgó menü:
    menubar.add(mHelp);
    mHelp.setText("Súgó");
    mHelp.setMnemonic('S');

    mHelp.add(miHelp);
    miHelp.setText("Használati útmutató");
    miHelp.setMnemonic('H');
    miHelp.setActionCommand("help");
    miHelp.addActionListener(this);
    miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));

    mHelp.add(miAbout);
    miAbout.setText("Névjegy");
    miAbout.setActionCommand("about");
    miAbout.addActionListener(this);
  }

  // Az eszköztár (toolBar) felépítése:
  void buildToolBar(JPanel tb) {
    tb.add(new ToolButton("new", img("new.gif"), "Új rajzlap", this));
    tb.add(new ToolButton("open", img("open.gif"), "Rajzlap megnyitása", this));
    tb.add(new ToolButton("save", img("save.gif"), "Rajzlap mentése",this));
    tb.add(new JLabel("   "));  // elválasztó hézag az eszközsoron

    tb.add(new ToolButton("undo", img("undo.gif"), "Visszavonás",this));
    tb.add(new ToolButton("redo", img("redo.gif"), "Ismét",this));
    tb.add(new ToolButton("del", img("del.gif"), "Kijelöltek törlése",this));
    tb.add(new ToolButton("delAll", img("delall.gif"), "Összes alakzat törlése",this));
    tb.add(new JLabel("   "));

    tb.add(cbGridVisible = new ToolCheckBox("gridVisible","Rács látszik","Rács látszik",this));
    tb.add(cbGridAlign = new ToolCheckBox("gridAlign","Rácsra igazítás","Rácsra igazítás",this));
    tb.add(new JLabel("   "));

    // Az eszköztár rácsmûveleteit elrejtjük, mert nem fér el:
    cbGridVisible.setVisible(false);
    cbGridAlign.setVisible(false);

    ButtonGroup bg = new ButtonGroup();
    tb.add(btSelect = new ToolToggleButton("select", img("hand.gif"), "Kijelölés",bg,this));
    tb.add(btLine = new ToolToggleButton("line", img("line.gif"), "Egyenes rajzolása",bg,this));
    tb.add(btRect = new ToolToggleButton("rect",img("rect.gif"), "Téglalap rajzolása",bg,this));
    tb.add(btOval = new ToolToggleButton("oval",img("oval.gif"), "Ellipszis rajzolása",bg,this));
    tb.add(btFreeline = new ToolToggleButton("freeline",img("freeline.gif"), "Szabadkézi rajz",bg,this));
    tb.add(new JLabel("   "));

    tb.add(lbBackground = new JLabel("   "));
    lbBackground.setOpaque(true);
    tb.add(new ToolButton("background","Háttérszín","Háttérszín beállítása",this));
    tb.add(lbColor = new JLabel("   "));

    lbColor.setOpaque(true);
    tb.add(new ToolButton("foreground","Rajzszín","Rajzolószín beállítása",this));
  }

  // A státuszsor (statusbar) felépítése:
  void buildStatusBar(JPanel sb) {
    sb.setBorder(BorderFactory.createLoweredBevelBorder());
    sb.setLayout(new BorderLayout() );

    sb.add(lbFileName = new JLabel(),BorderLayout.WEST);

    JPanel pnPos = new JPanel();
    pnPos.add(new JLabel("X= ",Label.RIGHT) );
    pnPos.add(lbX=new JLabel(" 0  ") );
    pnPos.add(new JLabel("Y= ",Label.RIGHT) );
    pnPos.add(lbY = new JLabel(" 0  ") );
    sb.add(pnPos,BorderLayout.EAST);
  }

  // Beállítja az eszköztár gombokat a drawPanel értékei alapján:
  void updateToolBar() {
    switch (drawPanel.getDrawingMode()) {
      case DrawPanel.LINE_MODE: btLine.setSelected(true); break;
      case DrawPanel.RECT_MODE: btRect.setSelected(true); break;
      case DrawPanel.OVAL_MODE: btOval.setSelected(true); break;
      case DrawPanel.FREELINE_MODE: btFreeline.setSelected(true); break;
      case DrawPanel.SELECT_MODE: btSelect.setSelected(true); break;
    }
    cbGridAlign.setSelected(drawPanel.isGridAlign());
    cbGridVisible.setSelected(drawPanel.isGridVisible());
    lbBackground.setBackground(drawPanel.getBackground());
    lbColor.setBackground(drawPanel.getColor());
  }

  // Beállítja a menü gombjait a drawPanel értékei alapján:
  void updateMenu() {
    cmiGridAlign.setSelected(drawPanel.isGridAlign());
    cmiGridVisible.setSelected(drawPanel.isGridVisible());
    int mode = drawPanel.getDrawingMode();
    if (mode == drawPanel.SELECT_MODE)
      rbmSelect.setSelected(true);
    else if (mode == drawPanel.LINE_MODE)
      rbmLine.setSelected(true);
    else if (mode == drawPanel.RECT_MODE)
      rbmRect.setSelected(true);
    else if (mode == drawPanel.OVAL_MODE)
      rbmOval.setSelected(true);
    else if (mode == drawPanel.FREELINE_MODE)
      rbmFreeline.setSelected(true);
  }

  void updateStatusBar() {
    lbFileName.setText(fileManager.getFileName());
  }

  // Események lekezelése:
  public void actionPerformed(ActionEvent e) {
    AbstractButton bt = (AbstractButton)e.getSource();
    String com = e.getActionCommand();

    if (com.equals("new")) {
      fileManager.newFile();
    }
    else if (com.equals("open")) {
      fileManager.openFile();
    }
    else if (com.equals("save")) {
      fileManager.saveFile();
    }
    else if (com.equals("saveas")) {
      fileManager.saveFileAs();
    }
    else if (com.equals("exit")) {
      exitProgram();
    }

    else if (com.equals("undo")) {
      drawPanel.undo();
    }
    else if (com.equals("redo")) {
      drawPanel.redo();
    }
    else if (com.equals("del")) {
      drawPanel.removeAllSelected();
    }
    else if (com.equals("selectAll")) {
      drawPanel.selectAll();
    }
    else if (com.equals("delAll")) {
      drawPanel.removeAll();
    }
    else if (com.equals("gridVisible")) {
      drawPanel.setGridVisible(bt.isSelected());
    }
    else if (com.equals("gridAlign")) {
      drawPanel.setGridAlign(bt.isSelected());
    }

    else if (com.equals("select")) {
      drawPanel.setDrawingMode(drawPanel.SELECT_MODE);
    }
    else if (com.equals("line")) {
      drawPanel.setDrawingMode(drawPanel.LINE_MODE);
    }
    else if (com.equals("rect")) {
      drawPanel.setDrawingMode(drawPanel.RECT_MODE);
    }
    else if (com.equals("oval")) {
      drawPanel.setDrawingMode(drawPanel.OVAL_MODE);
    }
    else if (com.equals("freeline")) {
      drawPanel.setDrawingMode(drawPanel.FREELINE_MODE);
    }

    else if (com.equals("background")) {
      Color color = drawPanel.getBackground();
      color = JColorChooser.showDialog(this,"A rajzlap háttérszíne",color);
      if (color != null)
        drawPanel.setBackground(color);
    }

    else if (com.equals("foreground")) {
      Color color = drawPanel.getColor();
      color = JColorChooser.showDialog(this,"A rajzlap rajzolószíne",color);
      if (color != null)
        drawPanel.setColor(color);
    }

    else if (com.equals("help")) {
      helpDialog.show();
    }

    else if (com.equals("about")) {
      aboutDialog.show();
    }

    updateToolBar();
    updateMenu();
    updateStatusBar();
  }

  public void mouseDragged(MouseEvent e) {
  }

  public void mouseMoved(MouseEvent e) {
    lbX.setText(e.getX()+"");
    lbY.setText(e.getY()+"");
  }
}
