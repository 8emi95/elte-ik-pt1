
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

/**
 * @version 2017. május 16.
 */
class SpecialFilter extends FileFilter {

  public boolean accept(File f) {
    return f.getName().toUpperCase().endsWith(".JAVA") ||
           f.isDirectory();
  }

  public String getDescription() {
    return ".java állományok";
  }
} // class SpecialFilter

public class FileChooserTest extends JFrame implements ActionListener {
  private JPanel pnKiiro = new JPanel();  
  private JLabel lbKonyvtar = new JLabel("Könyvtár: ");
  private JTextField tfKonyvtar = new JTextField(40);
  private JLabel lbFajlNev = new JLabel("Fájlnév: ");  
  private JTextField tfFajlNev  = new JTextField(15);
  
  private JPanel pnGombok = new JPanel();  
  private JButton btValaszt = new JButton("Választ");
  private JButton btKilep = new JButton("Kilép");
  
  private JFileChooser fc = new JFileChooser();

  public FileChooserTest() {
    setLocation(50, 100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    fc.setCurrentDirectory(new File("."));
    fc.setFileFilter(new SpecialFilter());

    tfKonyvtar.setFocusable(false);
    tfFajlNev.setFocusable(false);    
    pnKiiro.add(lbKonyvtar);
    pnKiiro.add(tfKonyvtar);
    pnKiiro.add(lbFajlNev);
    pnKiiro.add(tfFajlNev);
    add(pnKiiro, BorderLayout.NORTH);
    
    pnGombok.add(btValaszt);
    pnGombok.add(btKilep);
    add(pnGombok, BorderLayout.SOUTH);
    
    btValaszt.addActionListener(this);
    btKilep.addActionListener(this);

    pack();
    setVisible(true);
  } // konstruktor

  private void valaszt() {
    if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {   
      File selectedFile = fc.getSelectedFile();
      tfKonyvtar.setText(fc.getCurrentDirectory().getAbsolutePath());
      tfFajlNev.setText(selectedFile.getName());
      setTitle(selectedFile.getAbsolutePath());
    }
  } // valaszt()

  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
        case "Választ":
          valaszt();       
          break;
        case "Kilép":
          System.exit(0);        
          break;
    } // switch      
  } // actionPerformed()

  public static void main(String[] args) {
    //FontSetter.setFont("Dialog", Font.BOLD, args);
    new FileChooserTest();
  }
} // class FileChooserTest
