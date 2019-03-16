/*
 * Projekt: KissDraw
 *
 * Csomag: gui
 * DrawFrame.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import drawing.*;
import java.io.*;
import extra.hu.HuFileManager; // magyarul "besz�l�" fileManager

// Az alkalmaz�s f�ablaka.
public class DrawFrame extends JFrame implements ActionListener, MouseMotionListener {
  private Container cp = getContentPane();
  private String dataDir = "data";       // az adatok indul� k�nyvt�ra
  private String dataExtension = "draw";  // az adatok alap�rtelmezett kiterjeszt�se

  // Eszk�zt�r �s elemei:
  private JPanel toolBar = new JPanel();
  private ToolToggleButton btSelect, btLine, btRect, btOval, btFreeline;
  private ToolCheckBox cbGridVisible;
  private ToolCheckBox cbGridAlign;
  private JLabel lbBackground;  // h�tt�rsz�nt mutatja
  private JLabel lbColor;       // rajzol�sz�nt mutatja

  private DrawPanel drawPanel;     // rajzlap
  private HuFileManager fileManager; // drawPanel f�jlkapcsolata

  // St�tuszsor �s kijelz�i:
  private JPanel statusBar = new JPanel();
  private JLabel lbX, lbY, lbFileName;

  private HelpDialog helpDialog;
  private AboutDialog aboutDialog;

  // Men�:
  private JMenuBar menubar = new JMenuBar();

  // F�jl men�:
  private JMenu mFile = new JMenu();
  private JMenuItem miNew = new JMenuItem();
  private JMenuItem miOpen = new JMenuItem();
  private JMenuItem miSave = new JMenuItem();
  private JMenuItem miSaveAs = new JMenuItem();
  private JMenuItem miExit = new JMenuItem();

  // Szerkeszt�s men�:
  private JMenu mEdit = new JMenu();
  private JMenuItem miUndo = new JMenuItem();
  private JMenuItem miRedo = new JMenuItem();
  private JMenuItem miSelectAll = new JMenuItem();
  private JMenuItem miDel = new JMenuItem();
  private JMenuItem miDelAll = new JMenuItem();
  private JCheckBoxMenuItem cmiGridVisible = new JCheckBoxMenuItem();
  private JCheckBoxMenuItem cmiGridAlign = new JCheckBoxMenuItem();

  // Rajzol�si m�d men�:
  private JMenu mDrawingMode = new JMenu();
  private JRadioButtonMenuItem rbmSelect = new JRadioButtonMenuItem();
  private JRadioButtonMenuItem rbmLine = new JRadioButtonMenuItem();
  private JRadioButtonMenuItem rbmRect = new JRadioButtonMenuItem();
  private JRadioButtonMenuItem rbmOval = new JRadioButtonMenuItem();
  private JRadioButtonMenuItem rbmFreeline = new JRadioButtonMenuItem();

  // Sz�nek men�:
  private JMenu mColor = new JMenu();
  private JMenuItem miBackground = new JMenuItem();
  private JMenuItem miForeground = new JMenuItem();

  // S�g� men�:
  private JMenu mHelp = new JMenu();
  private JMenuItem miHelp = new JMenuItem();
  private JMenuItem miAbout = new JMenuItem();

  // Konstruktor:
  public DrawFrame() {
    setTitle("Kiss Draw");

   // Az alkalmaz�s teljes k�perny�s, csak alul hagyunk egy kis helyet:
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height-50);

    // A keret becsuk�s�t a program kezeli le:
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        exitProgram();
      }
    });

    buildToolBar(toolBar);     // eszk�zt�r fel�p�t�se
    cp.add(toolBar,"North");   // eszk�zt�r �szakra

    // L�trehozzuk a rajzlapot, s k�z�pre tessz�k:
    drawPanel = new DrawPanel();
    cp.add(new JScrollPane(drawPanel));

    // A rajzlapon figyelj�k az eg�r koordin�t�it:
    drawPanel.addMouseMotionListener(this);

    // St�tuszsor l�trehoz�sa �s fel�p�t�se:
    cp.add(statusBar,"South");
    buildStatusBar(statusBar);

    /* A f�jlmenedzser a rajzpanel ment�s�t/bet�lt�s�t fel�gyeli.
     * Ha nem l�tezik a dataDir k�nyvt�r, akkor l�trehozzuk.
     */
    fileManager = new HuFileManager(this,drawPanel);
    File f = new File(dataDir);
    if (!f.exists())
      f.mkdirs();
    fileManager.setCurrentDirectory(dataDir);
    fileManager.setExtension(dataExtension);
    fileManager.setDescription("Rajzok");

    // Men� fel�p�t�se:
    buildMenu();

    // Haszn�lati �tmutat� �s n�vjegy:
    helpDialog = new HelpDialog(this);
    aboutDialog = new AboutDialog(this);

    show();
    updateMenu();
    updateToolBar();
    updateStatusBar();
  }

  /* Kil�p�s a programb�l.
   * Ha volt m�dos�t�s, akkor megengedj�k a ment�st.
   * Ha nem gondolta meg mag�t, akkor t�nyleg kil�p�nk.
   */
  void exitProgram() {
    if (fileManager.exit())
      System.exit(0);
  }

  ImageIcon img(String fName) {
    /* A DrawFrame oszt�ly k�nyvt�r�ban van a resources k�nyvt�r, �s abban az fName nev� f�jl.
     */
    return new ImageIcon(getClass().getResource("/resources/"+fName));

    /* Ha a k�peket a Working directory-ba tenn�nk, akkor a
     * k�rnyezetben j�, de nem tudn�nk el�rni a k�peket egy
     * futtathat� Jar f�jlban:
     // return new ImageIcon("resources/"+fName);
     */
  }

  // A men� fel�p�t�se:
  void buildMenu() {
    setJMenuBar(menubar);

    // F�jl men�:
    menubar.add(mFile);
    mFile.setText("F�jl");
    mFile.setMnemonic('F');

    mFile.add(miNew);
    miNew.setText("�j");
    miNew.setActionCommand("new");
    miNew.addActionListener(this);
    miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK));

    mFile.add(miOpen);
    miOpen.setText("Megnyit�s...");
    miOpen.setActionCommand("open");
    miOpen.addActionListener(this);
    miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));

    mFile.addSeparator();

    mFile.add(miSave);
    miSave.setText("Ment�s");
    miSave.setActionCommand("save");
    miSave.addActionListener(this);
    miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));

    mFile.add(miSaveAs);
    miSaveAs.setText("Ment�s m�sk�nt...");
    miSaveAs.setActionCommand("saveas");
    miSaveAs.addActionListener(this);

    mFile.addSeparator();

    mFile.add(miExit);
    miExit.setText("Kil�p�s");
    miExit.setActionCommand("exit");
    miExit.addActionListener(this);
    miExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.ALT_MASK));

    // Szerkeszt�s men�:
    menubar.add(mEdit);
    mEdit.setText("Szerkeszt�s");
    mEdit.setMnemonic('E');

    mEdit.add(miUndo);
    miUndo.setText("Visszavon�s");
    miUndo.setActionCommand("undo");
    miUndo.addActionListener(this);
    miUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,Event.CTRL_MASK));

    mEdit.add(miRedo);
    miRedo.setText("Ism�t");
    miRedo.setActionCommand("redo");
    miRedo.addActionListener(this);
    miRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,Event.CTRL_MASK));

    mEdit.addSeparator();

    mEdit.add(miSelectAll);
    miSelectAll.setText("�sszes kijel�l�se");
    miSelectAll.setActionCommand("selectAll");
    miSelectAll.addActionListener(this);
    miSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,Event.CTRL_MASK));

    mEdit.addSeparator();

    mEdit.add(miDel);
    miDel.setText("Kijel�ltek t�rl�se");
    miDel.setActionCommand("del");
    miDel.addActionListener(this);
    miDel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));

    mEdit.add(miDelAll);
    miDelAll.setText("�sszes t�rl�se");
    miDelAll.setActionCommand("delAll");
    miDelAll.addActionListener(this);
    miDelAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,Event.CTRL_MASK));

    mEdit.addSeparator();

    mEdit.add(cmiGridVisible);
    cmiGridVisible.setText("R�cs l�tszik");
    cmiGridVisible.setActionCommand("gridVisible");
    cmiGridVisible.addActionListener(this);

    mEdit.add(cmiGridAlign);
    cmiGridAlign.setText("R�csra igaz�t�s");
    cmiGridAlign.setActionCommand("gridAlign");
    cmiGridAlign.addActionListener(this);

    // Rajzol�si m�d men�:
    menubar.add(mDrawingMode);
    mDrawingMode.setText("Rajzol�si m�d");
    mDrawingMode.setMnemonic('R');
    ButtonGroup bg = new ButtonGroup();

    mDrawingMode.add(rbmSelect);
    rbmSelect.setText("Kijel�l�s");
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
    rbmRect.setText("T�glalap");
    rbmRect.setActionCommand("rect");
    rbmRect.addActionListener(this);
    bg.add(rbmRect);

    mDrawingMode.add(rbmOval);
    rbmOval.setText("Ellipszis");
    rbmOval.setActionCommand("oval");
    rbmOval.addActionListener(this);
    bg.add(rbmOval);

    mDrawingMode.add(rbmFreeline);
    rbmFreeline.setText("Szabadk�zi");
    rbmFreeline.setActionCommand("freeline");
    rbmFreeline.addActionListener(this);
    bg.add(rbmFreeline);

    // Sz�nek men�:
    menubar.add(mColor);
    mColor.setText("Sz�nek");
    mColor.setMnemonic('C');

    mColor.add(miBackground);
    miBackground.setText("H�tt�rsz�n");
    miBackground.setActionCommand("background");
    miBackground.addActionListener(this);

    mColor.add(miForeground);
    miForeground.setText("Rajzol�sz�n");
    miForeground.setActionCommand("foreground");
    miForeground.addActionListener(this);

    // S�g� men�:
    menubar.add(mHelp);
    mHelp.setText("S�g�");
    mHelp.setMnemonic('S');

    mHelp.add(miHelp);
    miHelp.setText("Haszn�lati �tmutat�");
    miHelp.setMnemonic('H');
    miHelp.setActionCommand("help");
    miHelp.addActionListener(this);
    miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));

    mHelp.add(miAbout);
    miAbout.setText("N�vjegy");
    miAbout.setActionCommand("about");
    miAbout.addActionListener(this);
  }

  // Az eszk�zt�r (toolBar) fel�p�t�se:
  void buildToolBar(JPanel tb) {
    tb.add(new ToolButton("new", img("new.gif"), "�j rajzlap", this));
    tb.add(new ToolButton("open", img("open.gif"), "Rajzlap megnyit�sa", this));
    tb.add(new ToolButton("save", img("save.gif"), "Rajzlap ment�se",this));
    tb.add(new JLabel("   "));  // elv�laszt� h�zag az eszk�zsoron

    tb.add(new ToolButton("undo", img("undo.gif"), "Visszavon�s",this));
    tb.add(new ToolButton("redo", img("redo.gif"), "Ism�t",this));
    tb.add(new ToolButton("del", img("del.gif"), "Kijel�ltek t�rl�se",this));
    tb.add(new ToolButton("delAll", img("delall.gif"), "�sszes alakzat t�rl�se",this));
    tb.add(new JLabel("   "));

    tb.add(cbGridVisible = new ToolCheckBox("gridVisible","R�cs l�tszik","R�cs l�tszik",this));
    tb.add(cbGridAlign = new ToolCheckBox("gridAlign","R�csra igaz�t�s","R�csra igaz�t�s",this));
    tb.add(new JLabel("   "));

    // Az eszk�zt�r r�csm�veleteit elrejtj�k, mert nem f�r el:
    cbGridVisible.setVisible(false);
    cbGridAlign.setVisible(false);

    ButtonGroup bg = new ButtonGroup();
    tb.add(btSelect = new ToolToggleButton("select", img("hand.gif"), "Kijel�l�s",bg,this));
    tb.add(btLine = new ToolToggleButton("line", img("line.gif"), "Egyenes rajzol�sa",bg,this));
    tb.add(btRect = new ToolToggleButton("rect",img("rect.gif"), "T�glalap rajzol�sa",bg,this));
    tb.add(btOval = new ToolToggleButton("oval",img("oval.gif"), "Ellipszis rajzol�sa",bg,this));
    tb.add(btFreeline = new ToolToggleButton("freeline",img("freeline.gif"), "Szabadk�zi rajz",bg,this));
    tb.add(new JLabel("   "));

    tb.add(lbBackground = new JLabel("   "));
    lbBackground.setOpaque(true);
    tb.add(new ToolButton("background","H�tt�rsz�n","H�tt�rsz�n be�ll�t�sa",this));
    tb.add(lbColor = new JLabel("   "));

    lbColor.setOpaque(true);
    tb.add(new ToolButton("foreground","Rajzsz�n","Rajzol�sz�n be�ll�t�sa",this));
  }

  // A st�tuszsor (statusbar) fel�p�t�se:
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

  // Be�ll�tja az eszk�zt�r gombokat a drawPanel �rt�kei alapj�n:
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

  // Be�ll�tja a men� gombjait a drawPanel �rt�kei alapj�n:
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

  // Esem�nyek lekezel�se:
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
      color = JColorChooser.showDialog(this,"A rajzlap h�tt�rsz�ne",color);
      if (color != null)
        drawPanel.setBackground(color);
    }

    else if (com.equals("foreground")) {
      Color color = drawPanel.getColor();
      color = JColorChooser.showDialog(this,"A rajzlap rajzol�sz�ne",color);
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
