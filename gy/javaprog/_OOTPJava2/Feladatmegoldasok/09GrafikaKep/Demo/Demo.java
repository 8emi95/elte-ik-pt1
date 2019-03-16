/*
 * Feladatmegold�sok/9. fejezet
 * Demo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// K�pet tart� panel:
class Kep extends JPanel {
  private Image img;

  void setImage(Image img) {
    this.img = img;
    repaint();
  }

  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    gr.drawImage(img,0,0,this);
  }
}

/* A keret a megadott k�peket sorban megjelen�ti egy id�z�t� seg�ts�g�vel.
 * A k�peket bet�lt�skor sk�l�zzuk (ha kell), k�s�bb a k�p m�rete nem v�ltozik.
 * A keretet nem lehet m�retezni.
 */
public class Demo extends JFrame implements ActionListener {
  private boolean skalazas = true; // true eset�n van sk�l�z�s
  private String[] fileNames = {"PecsTV.jpg","BelvTempEste.jpg",
           "PosterChild.jpg","SanFran.jpg","En.jpg"};
  private Image[] images = new Image[fileNames.length];
  private Kep kep;
  private int index=0;    // a soron k�vetkez� k�p indexe
  // Id�z�t� a k�pv�lt�shoz:
  private Timer timer = new Timer(5000,this);

  public Demo(boolean skalazas) {
    this.skalazas = skalazas;

    // A keret magass�g�t kicsit ler�vid�tj�k a teljes k�perny�h�z k�pest:
    Dimension frameDim = Toolkit.getDefaultToolkit().getScreenSize();
    frameDim = new Dimension(frameDim.width,frameDim.height-20);
    setSize(frameDim);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // A k�pek bet�lt�se a f�jlokb�l:
    MediaTracker tr = new MediaTracker(this);
    for (int i=0; i<fileNames.length; i++) {
      images[i] = Toolkit.getDefaultToolkit().createImage("images/"+fileNames[i]);
      tr.addImage(images[i],0);
    }
    // Megv�rjuk, m�g az �sszes k�p bet�lt�dik:
    try {
      tr.waitForAll();
    }
    catch (InterruptedException ex) {
    }

    /* A k�pek sk�l�z�sa a m�diak�vet� seg�ts�g�vel.
     * A k�peket csak akkor sk�l�zzuk, ha skalazas==true.
     * �gy sk�l�zunk, hogy a k�pek a frameDim-be bef�rjenek:
     */
    tr = new MediaTracker(this);
    for (int i=0; i<images.length; i++) {
      if (skalazas)
        images[i] = scaledImage(images[i], frameDim.width, frameDim.height);
      tr.addImage(images[i],0);
    }
    // Megv�rjuk, m�g az �sszes k�p sk�l�z�sa k�sz:
    try {
      tr.waitForAll();
    }
    catch (InterruptedException ex) {
    }

    getContentPane().add(kep = new Kep());

    // Az els� k�p megjelen�t�se:
    kep.setImage(images[0]);
    timer.start();

    show();
  }

  // Az img k�p sk�l�z�sa �gy, hogy az adott keretbe bef�rjen:
  private Image scaledImage(Image img, int width, int height) {
    double arany = 1.0*img.getWidth(this)/img.getHeight(this);
    int x, y;
    // A k�p sk�l�z�sa:
    if (getHeight()*arany>getWidth())
      // A k�p sz�less�ge a komponens sz�less�ge lesz:
      return img.getScaledInstance(getWidth(),-1,Image.SCALE_DEFAULT);
    else
      // A k�p magass�ga a komponens magass�ga lesz:
      return img.getScaledInstance(-1,getHeight(),Image.SCALE_DEFAULT);
  }

  public void actionPerformed(ActionEvent e) {
    index++;
    if (index==fileNames.length)
      index = 0;
    kep.setImage(images[index]);
  }

  public static void main (String args[]) {
    // a) feladat
    new Demo(false);
    // b) feladat
    new Demo(true);
  }
}
