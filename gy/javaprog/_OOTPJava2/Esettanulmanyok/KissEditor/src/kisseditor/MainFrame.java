/*
 * Projekt: KissEditor
 *
 * Csomag: kisseditor
 * MainFrame.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2003.04.01.
 */

package kisseditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import extra.util.*;

public class MainFrame extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private final String appName = "Kiss Editor";
  private String baseDir = ""; // aktu�lis k�nyvt�r
  private String[] extensions = {"txt","java","properties","bat","html","htm","xml"};
  private String description = "Text files";

  // Kezdeti font:
  private Font font = new Font("Monospaced",Font.PLAIN,12);

  // St�tuszsor �s kijelz�i:
  private JPanel statusBar = new JPanel();
  private JLabel lbFileName = new JLabel(" ");
  private JLabel lbModified = new JLabel(" ",JLabel.CENTER);
  private JLabel lbLineCol = new JLabel(" ",JLabel.CENTER);

  // Sz�vegter�let �s f�jlkapcsolata:
  private EditArea editArea = new EditArea();
  private FileManager fileManager;

  // N�vjegy:
  private SplashScreen splashScreen;
  private AboutDialog aboutDialog;

  // Men�:
  private JMenuBar menubar = new JMenuBar();

  // F�jl men�:
  private JMenu mFile = new JMenu();
  private JMenuItem miNew = new JMenuItem();
  private JMenuItem miOpen = new JMenuItem();
  private JMenuItem miSave = new JMenuItem();
  private JMenuItem miSaveAs = new JMenuItem();
  private JMenuItem miPrint = new JMenuItem();
  private JMenuItem miExit = new JMenuItem();

  // Szerkeszt�s men�:
  private JMenu mEdit = new JMenu();
  private JMenuItem miCut = new JMenuItem();
  private JMenuItem miCopy = new JMenuItem();
  private JMenuItem miPaste = new JMenuItem();
  private JMenuItem miSelectAll = new JMenuItem();
  private JMenuItem miDelete = new JMenuItem();

  // Be�ll�t�s men�:
  private JMenu mOptions = new JMenu();

  private JMenu mColor = new JMenu();
  private JMenuItem miBackground = new JMenuItem();
  private JMenuItem miForeground = new JMenuItem();

  private JMenuItem miFont = new JMenuItem();

  private JMenu mLook = new JMenu();
  private JMenuItem miWindows = new JRadioButtonMenuItem();
  private JMenuItem miMotif = new JRadioButtonMenuItem();
  private JMenuItem miMetal = new JRadioButtonMenuItem();

  // S�g� men�:
  private JMenu mHelp = new JMenu();
  private JMenuItem miSplash = new JMenuItem(); // nyit�k�p
  private JMenuItem miAbout = new JMenuItem();

  public MainFrame() {
    setTitle(appName);

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

    /* Ha a sz�vegter�leten a kurzor poz�ci�ja megv�ltozhatott,
     * akkor friss�tj�k a ki�r�sokat:
     */
    // Klikkeltek a sz�vegter�leten:
    editArea.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        updateStatusBar();
      }
    });
    // Mozgatt�k a kurzort:
    editArea.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        updateStatusBar();
      }
    });

    // A sz�vegter�letet k�z�pre tessz�k egy g�rget�panelre:
    cp.add(new JScrollPane(editArea));
    editArea.setFont(font);

    // St�tuszsor l�trehoz�sa �s fel�p�t�se:
    cp.add(statusBar,"South");
    buildStatusBar(statusBar);

    // A f�jlmenedzser a sz�vegter�let ment�s�t/bet�lt�s�t fel�gyeli:
    fileManager = new FileManager(this,editArea);
    // A f�jlmenedzser konfigur�l�sa:
    fileManager.setCurrentDirectory(baseDir);
    fileManager.setExtension(extensions);
    fileManager.setDescription(description);

    // Men� fel�p�t�se:
    buildMenu();

    // N�vjegy:
    aboutDialog = new AboutDialog(this);
    splashScreen = new SplashScreen(this);

    /* Kezdetben a kin�zet metal lesz (mintha az miMetal
     * men�t lenyomt�k volna):
     */
    miMetal.doClick();
    show();
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

  // A men� fel�p�t�se:
  void buildMenu() {
    setJMenuBar(menubar);

    // F�jl men�:
    menubar.add(mFile);
    mFile.setText("File");
    mFile.setMnemonic('F');

    mFile.add(miNew);
    miNew.setText("New");
    miNew.setMnemonic('N');
    miNew.setActionCommand("new");
    miNew.addActionListener(this);
    miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK));

    mFile.add(miOpen);
    miOpen.setText("Open...");
    miOpen.setMnemonic('O');
    miOpen.setActionCommand("open");
    miOpen.addActionListener(this);
    miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));

    mFile.addSeparator();

    mFile.add(miSave);
    miSave.setText("Save");
    miSave.setMnemonic('S');
    miSave.setActionCommand("save");
    miSave.addActionListener(this);
    miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));

    mFile.add(miSaveAs);
    miSaveAs.setText("Save as...");
    miSaveAs.setMnemonic('A');
    miSaveAs.setActionCommand("saveas");
    miSaveAs.addActionListener(this);

    mFile.addSeparator();

    mFile.add(miPrint);
    miPrint.setText("Print...");
    miPrint.setMnemonic('P');
    miPrint.setActionCommand("print");
    miPrint.addActionListener(this);
    miPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,Event.CTRL_MASK));

    mFile.addSeparator();

    mFile.add(miExit);
    miExit.setText("Exit");
    miExit.setActionCommand("exit");
    miExit.setMnemonic('X');
    miExit.addActionListener(this);
    miExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.ALT_MASK));

    // Szerkeszt�s men�:
    menubar.add(mEdit);
    mEdit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        updateEnabled();
      }
    });
    mEdit.setText("Edit");
    mEdit.setMnemonic('E');

    mEdit.add(miCut);
    miCut.setText("Cut");
    miCut.setActionCommand("cut");
    miCut.addActionListener(this);
    miCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.CTRL_MASK));

    mEdit.add(miCopy);
    miCopy.setText("Copy");
    miCopy.setActionCommand("copy");
    miCopy.addActionListener(this);
    miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,Event.CTRL_MASK));

    mEdit.add(miPaste);
    miPaste.setText("Paste");
    miPaste.setActionCommand("paste");
    miPaste.addActionListener(this);
    miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,Event.CTRL_MASK));

    mEdit.addSeparator();

    mEdit.add(miSelectAll);
    miSelectAll.setText("Select All");
    miSelectAll.setActionCommand("selectAll");
    miSelectAll.addActionListener(this);
    miSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,Event.CTRL_MASK));

    mEdit.add(miDelete);
    miDelete.setText("Delete selected");
    miDelete.setActionCommand("delete");
    miDelete.addActionListener(this);
    miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));

    // Be�ll�t�s men�:
    menubar.add(mOptions);
    mOptions.setText("Options");
    mOptions.setMnemonic('O');

    // Options - Color
    mOptions.add(mColor);
    mColor.setText("Color");
    mColor.setMnemonic('C');

    mColor.add(miBackground);
    miBackground.setText("Background");
    miBackground.setActionCommand("background");
    miBackground.addActionListener(this);

    mColor.add(miForeground);
    miForeground.setText("Foreground");
    miForeground.setActionCommand("foreground");
    miForeground.addActionListener(this);

    // Options - Font
    mOptions.add(miFont);
    miFont.setText("Font");
    miFont.setMnemonic('F');
    miFont.setActionCommand("font");
    miFont.addActionListener(this);

    // Options - Look and feel
    mOptions.add(mLook);
    mLook.setText("Look & feel");
    mLook.setMnemonic('L');

    mLook.add(miWindows);
    miWindows.setText("Windows");
    miWindows.setActionCommand("windows");
    miWindows.addActionListener(this);

    mLook.add(miMotif);
    miMotif.setText("Motif");
    miMotif.setActionCommand("motif");
    miMotif.addActionListener(this);

    mLook.add(miMetal);
    miMetal.setText("Metal");
    miMetal.setActionCommand("metal");
    miMetal.addActionListener(this);

    ButtonGroup bg = new ButtonGroup();
    bg.add(miWindows);
    bg.add(miMotif);
    bg.add(miMetal);

    // S�g� men�:
    menubar.add(mHelp);
    mHelp.setText("Help");
    mHelp.setMnemonic('H');

    mHelp.add(miSplash);
    miSplash.setText("Splash");
    miSplash.setMnemonic('S');
    miSplash.setActionCommand("splash");
    miSplash.addActionListener(this);

    mHelp.addSeparator();

    mHelp.add(miAbout);
    miAbout.setText("About");
    miAbout.setMnemonic('A');
    miAbout.setActionCommand("about");
    miAbout.addActionListener(this);
  }

  // A st�tuszsor (statusbar) fel�p�t�se:
  void buildStatusBar(JPanel sb) {
    sb.setLayout(new GridLayout(1,2));
    lbFileName.setBorder(BorderFactory.createLoweredBevelBorder());
    lbModified.setBorder(BorderFactory.createLoweredBevelBorder());
    lbLineCol.setBorder(BorderFactory.createLoweredBevelBorder());

    sb.add(lbFileName);
    JPanel pnRight = new JPanel();
    pnRight.setLayout(new GridLayout(1,3));
    pnRight.add(lbModified);
    pnRight.add(lbLineCol);
    sb.add(pnRight);
  }

  void updateStatusBar() {
    lbFileName.setText(fileManager.getFileName());
    lbModified.setText(editArea.isModified()?"Modified":"");
    lbLineCol.setText(editArea.getCaretLineCol());
  }

  // Men�pont letilt�sok, enged�lyez�sek:
  void updateEnabled() {
    String selectedText = editArea.getSelectedText();
    boolean selected = selectedText!=null;
    miCut.setEnabled(selected);
    miCopy.setEnabled(selected);
    boolean allSelected = (selected &&
       selectedText.length()==editArea.getText().length());
    miSelectAll.setEnabled(!allSelected);
    miDelete.setEnabled(selected);
  }

  // Esem�nyek lekezel�se:
  public void actionPerformed(ActionEvent e) {
    String com = e.getActionCommand();
    updateEnabled();

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
    else if (com.equals("print")) {
      editArea.print();
    }
    else if (com.equals("exit")) {
      exitProgram();
    }
    else if (com.equals("cut")) {
      editArea.cut();
    }
    else if (com.equals("copy")) {
      editArea.copy();
    }
    else if (com.equals("paste")) {
      editArea.paste();
    }
    else if (com.equals("selectAll")) {
      editArea.selectAll();
    }
    else if (com.equals("delete")) {
      editArea.replaceSelection("");
    }

    else if (com.equals("background")) {
      Color color = editArea.getBackground();
      color = JColorChooser.showDialog(this,"Text background",color);
      if (color != null)
        editArea.setBackground(color);
    }

    else if (com.equals("foreground")) {
      Color color = editArea.getForeground();
      color = JColorChooser.showDialog(this, "Text foreground", color);
      if (color != null)
        editArea.setForeground(color);
    }
    else if (com.equals("font")) {
      font = FontChooser.showDialog(this,editArea.getFont());
      editArea.setFont(font);
    }
    else if (com.equals("windows")) {
      try {
        UIManager.setLookAndFeel(
            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
      }
      catch (Exception ex) {
      }
    }
    if (com.equals("motif")) {
      try {
        UIManager.setLookAndFeel(
            "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
      }
      catch (Exception ex) {
      }
    }
    if (com.equals("metal")) {
      try {
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
      }
      catch (Exception ex) {
      }
    }

    else if (com.equals("splash")) {
      splashScreen.show();
    }
    else if (com.equals("about")) {
      aboutDialog.show();
    }

    updateStatusBar();
  }

}
