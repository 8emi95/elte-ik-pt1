/*
 * Feladatmegold�sok/9. fejezet
 * KepSzonyeg.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

class KepSzonyegPanel extends JPanel {
  private Image minta;
  private int w = 30;
  private int h = 0; //  a konstruktor sz�molja ki
  MediaTracker tr;

  public KepSzonyegPanel(String fileName) {
    // A fileName k�p bet�lt�se:
    System.out.println(fileName);
    minta = Toolkit.getDefaultToolkit().createImage(fileName);
    tr = new MediaTracker(this);
    tr.addImage(minta,0);
    try {
      tr.waitForID(0);
    }
    catch (InterruptedException ex) {
    }
    // A k�p sz�less�ge 30 pontos lesz. Ar�nyos nagy�t�s vagy kicsiny�t�s:
    minta = minta.getScaledInstance(30,-1,Image.SCALE_FAST);
    tr.addImage(minta,0);
    try {
      tr.waitForID(0);
    }
    catch (InterruptedException ex) {
    }
    h = minta.getHeight(this);
  }

  // Az eg�sz panelt telerajzoljuk a k�ppel, m�sol�ssal:
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    gr.drawImage(minta,0,0,this);
    for (int i=0; i*h<getHeight();i++)
      for (int j=0; j*w<getWidth();j++)
        gr.copyArea(0,0,w,h,j*w,i*h);
  }
}

// F� keret. A sz�nyegminta k�p�t men�b�l v�laszthat�an t�ltj�k be:
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

      // A k�p l�tez�s�nek ellen�rz�se:
      fileName = "images/"+fileName;
      File f = new File(fileName);
      if (!f.exists()) {
        JOptionPane.showMessageDialog(this,"Nincs ilyen k�p");
        return;
      }

      // A sz�nyeg l�trehoz�sa. Ha m�r volt sz�nyeg, azt el�bb kivessz�k a tartalompanelb�l:
      if (kepSzonyeg != null)
        cp.remove(kepSzonyeg);
      cp.add(kepSzonyeg = new KepSzonyegPanel(fileName));
      validate();
      // K�l�nben ottmarad a JOptionPane ablak�nak helye. Tal�n a Java hib�ja?!
      setSize(getWidth()+1,getHeight()+1);
    }
    else if (e.getSource() == miExitProgram)
      System.exit(0);
  }

  public static void main (String args[]) {
    new KepSzonyeg();
  }
}
