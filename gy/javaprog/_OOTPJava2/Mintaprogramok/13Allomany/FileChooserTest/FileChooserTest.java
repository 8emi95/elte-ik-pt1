/*
 * Mintaprogramok/13. fejezet
 * FileChooserTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class JavaFilter extends FileFilter {                      //1

  public boolean accept(File f) {
    return f.getName().toUpperCase().endsWith(".JAVA") ||
           f.isDirectory();
  }

  public String getDescription() {
    return "Java-állományok";
  }
}

public class FileChooserTest extends JFrame
                                 implements ActionListener {
  private Container cp = getContentPane();
  private JTextField tfDir, tfFile;
  private JButton btValaszt, btKilep;
  private JFileChooser fc = new JFileChooser();            //2

  public FileChooserTest() {
    setLocation(100,100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    fc.setCurrentDirectory(new File("."));                 //3
    fc.setFileFilter(new JavaFilter());

    JPanel pnInfo = new JPanel();                          //4
    pnInfo.add(new JLabel("Könyvtár: "));
    pnInfo.add(tfDir = new JTextField(40));
    pnInfo.add(new JLabel("Állománynév: "));
    pnInfo.add(tfFile = new JTextField(15));
    tfDir.setEnabled(false);
    tfFile.setEnabled(false);
    cp.add(pnInfo);

    JPanel pnGombok = new JPanel();
    pnGombok.add(btValaszt = new JButton("Választ"));
    pnGombok.add(btKilep= new JButton("Kilép"));
    cp.add(pnGombok,"South");
    btValaszt.addActionListener(this);
    btKilep.addActionListener(this);

    pack();
    show();
  }

  void update() {                                          //5
    File sf = fc.getSelectedFile();
    if (sf != null) {
      tfDir.setText(fc.getCurrentDirectory().getAbsolutePath());
      tfFile.setText(sf.getName());
      setTitle(sf.getAbsolutePath());
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==btValaszt) {
      if (fc.showOpenDialog(this)==
           JFileChooser.APPROVE_OPTION) {                  //6
        update();
      }
    }
    else if (e.getSource()==btKilep)
      System.exit(0);
  }

  public static void main(String[] args) {
    new FileChooserTest();
  }
} // FileChooserTest
