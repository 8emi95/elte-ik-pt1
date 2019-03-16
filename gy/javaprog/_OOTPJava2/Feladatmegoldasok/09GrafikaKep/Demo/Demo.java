/*
 * Feladatmegoldások/9. fejezet
 * Demo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Képet tartó panel:
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

/* A keret a megadott képeket sorban megjeleníti egy idõzítõ segítségével.
 * A képeket betöltéskor skálázzuk (ha kell), késõbb a kép mérete nem változik.
 * A keretet nem lehet méretezni.
 */
public class Demo extends JFrame implements ActionListener {
  private boolean skalazas = true; // true esetén van skálázás
  private String[] fileNames = {"PecsTV.jpg","BelvTempEste.jpg",
           "PosterChild.jpg","SanFran.jpg","En.jpg"};
  private Image[] images = new Image[fileNames.length];
  private Kep kep;
  private int index=0;    // a soron következõ kép indexe
  // Idõzítõ a képváltáshoz:
  private Timer timer = new Timer(5000,this);

  public Demo(boolean skalazas) {
    this.skalazas = skalazas;

    // A keret magasságát kicsit lerövidítjük a teljes képernyõhöz képest:
    Dimension frameDim = Toolkit.getDefaultToolkit().getScreenSize();
    frameDim = new Dimension(frameDim.width,frameDim.height-20);
    setSize(frameDim);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // A képek betöltése a fájlokból:
    MediaTracker tr = new MediaTracker(this);
    for (int i=0; i<fileNames.length; i++) {
      images[i] = Toolkit.getDefaultToolkit().createImage("images/"+fileNames[i]);
      tr.addImage(images[i],0);
    }
    // Megvárjuk, míg az összes kép betöltõdik:
    try {
      tr.waitForAll();
    }
    catch (InterruptedException ex) {
    }

    /* A képek skálázása a médiakövetõ segítségével.
     * A képeket csak akkor skálázzuk, ha skalazas==true.
     * Úgy skálázunk, hogy a képek a frameDim-be beférjenek:
     */
    tr = new MediaTracker(this);
    for (int i=0; i<images.length; i++) {
      if (skalazas)
        images[i] = scaledImage(images[i], frameDim.width, frameDim.height);
      tr.addImage(images[i],0);
    }
    // Megvárjuk, míg az összes kép skálázása kész:
    try {
      tr.waitForAll();
    }
    catch (InterruptedException ex) {
    }

    getContentPane().add(kep = new Kep());

    // Az elsõ kép megjelenítése:
    kep.setImage(images[0]);
    timer.start();

    show();
  }

  // Az img kép skálázása úgy, hogy az adott keretbe beférjen:
  private Image scaledImage(Image img, int width, int height) {
    double arany = 1.0*img.getWidth(this)/img.getHeight(this);
    int x, y;
    // A kép skálázása:
    if (getHeight()*arany>getWidth())
      // A kép szélessége a komponens szélessége lesz:
      return img.getScaledInstance(getWidth(),-1,Image.SCALE_DEFAULT);
    else
      // A kép magassága a komponens magassága lesz:
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
