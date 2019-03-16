/*
 * Feladatmegoldások/14. fejezet
 * SimpleEditor.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Text állományok szûrése a JFileChooser-hez:
class TextFilter extends javax.swing.filechooser.FileFilter {
  public boolean accept(File f) {
    String name = f.getName().toUpperCase();
    return f.isDirectory() ||
      name.endsWith(".TXT") ||
      name.endsWith(".JAVA") ||
      name.endsWith(".PAS");
  }

  public String getDescription() {
    return "*txt; *.java; *.pas";
  }
}

public class SimpleEditor extends JFrame implements ActionListener {
  private File filText = new File(".");
  private JMenuItem miOpen, miSave, miExit;
  private JFileChooser fc = new JFileChooser("work");
  private JTextArea taEditor = new JTextArea();

  public SimpleEditor() {
    setTitle("Egyszerû szövegszerkesztõ");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(100,100,screenSize.width-200,screenSize.height-200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    JMenuBar mb;
    JMenu mFile;
    setJMenuBar(mb = new JMenuBar());
    mb.add(mFile = new JMenu("File"));
    mFile.setMnemonic('F');
    mFile.add(miOpen = new JMenuItem("Open",'O'));
    mFile.add(miSave = new JMenuItem("Save",'S'));
    mFile.addSeparator();
    mFile.add(miExit = new JMenuItem("Exit",'X'));
    miOpen.addActionListener(this);
    miSave.addActionListener(this);
    miExit.addActionListener(this);
    taEditor.setFont(new Font("Monospaced",Font.PLAIN,14));
    getContentPane().add(new JScrollPane(taEditor));
    fc.setFileFilter(new TextFilter());
    show();
  }

  // Fájl betöltése lemezrõl:
  void open() {
    if (fc.showOpenDialog(this)==fc.APPROVE_OPTION) {
      filText = fc.getSelectedFile();
      char[] puffer = new char[(int)filText.length()];
      FileReader fr;
      try {
        fr = new FileReader(filText);
        fr.read(puffer);
        fr.close();
        taEditor.setText(String.valueOf(puffer));
        taEditor.setCaretPosition(0);
      }
      catch (IOException ex) {
      }
    }
  }

  // Fájl mentése lemezre:
  void save() {
    FileWriter fw;
    try {
      fw = new FileWriter(filText);
      String text = taEditor.getText();
      fw.write(text);
      fw.close();
    }
    catch (IOException ex) {
    }
  }

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource()==miOpen)
      open();
    else if (ev.getSource()==miSave)
      save();
    else if (ev.getSource()==miExit)
      System.exit(0);
  }

  public static void main(String[] args) {
    new SimpleEditor();
  } // main

} // SimpleEditor
