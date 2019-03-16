/*
 * Feladatmegoldások/9. fejezet
 * KepSzonyeg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

class KepSzonyegPanel extends JPanel {
  private Image minta;
  private int w = 30;
  private int h = 0; //  a konstruktor számolja ki
  MediaTracker tr;

  public KepSzonyegPanel(String fileName) {
    // A fileName kép betöltése:
    System.out.println(fileName);
    minta = Toolkit.getDefaultToolkit().createImage(fileName);
    tr = new MediaTracker(this);
    tr.addImage(minta,0);
    try {
      tr.waitForID(0);
    }
    catch (InterruptedException ex) {
    }
    // A kép szélessége 30 pontos lesz. Arányos nagyítás vagy kicsinyítés:
    minta = minta.getScaledInstance(30,-1,Image.SCALE_FAST);
    tr.addImage(minta,0);
    try {
      tr.waitForID(0);
    }
    catch (InterruptedException ex) {
    }
    h = minta.getHeight(this);
  }

  // Az egész panelt telerajzoljuk a képpel, másolással:
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    gr.drawImage(minta,0,0,this);
    for (int i=0; i*h<getHeight();i++)
      for (int j=0; j*w<getWidth();j++)
        gr.copyArea(0,0,w,h,j*w,i*h);
  }
}

// Fõ keret. A szõnyegminta képét menübõl választhatóan töltjük be:
public class KepSzonyeg extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private MenuBar mb;
  private Menu mFile;
  private MenuItem miReadFile;
  private MenuItem miExitProgram;
  private KepSzonyegPanel kepSzonyeg = null;

  public KepSzonyeg() {
    setTitle("Szonyeg");
    setBounds(100,100,400,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setMenuBar(mb = new MenuBar());
    mb.add(mFile = new Menu("File"));
    mFile.add(miReadFile = new MenuItem("Open image file"));
    mFile.add(miExitProgram = new MenuItem("Exit"));
    miReadFile.addActionListener(this);
    miExitProgram.addActionListener(this);

    show();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == miReadFile) {
      String fileName = JOptionPane.showInputDialog(this,
          "File neve (pl. amhappy.jpg, Java2Borito.jpg stb.): ");
      if (fileName == null || fileName.equals(""))
        return;

      // A kép létezésének ellenõrzése:
      fileName = "images/"+fileName;
      File f = new File(fileName);
      if (!f.exists()) {
        JOptionPane.showMessageDialog(this,"Nincs ilyen kép");
        return;
      }

      // A szõnyeg létrehozása. Ha már volt szõnyeg, azt elõbb kivesszük a tartalompanelbõl:
      if (kepSzonyeg != null)
        cp.remove(kepSzonyeg);
      cp.add(kepSzonyeg = new KepSzonyegPanel(fileName));
      validate();
      // Különben ottmarad a JOptionPane ablakának helye. Talán a Java hibája?!
      setSize(getWidth()+1,getHeight()+1);
    }
    else if (e.getSource() == miExitProgram)
      System.exit(0);
  }

  public static void main (String args[]) {
    new KepSzonyeg();
  }
}
