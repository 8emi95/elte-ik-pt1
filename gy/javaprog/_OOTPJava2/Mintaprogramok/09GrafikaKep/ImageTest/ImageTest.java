/*
 * Mintaprogramok/9. fejezet
 * ImageTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

class Kep extends JPanel {
  private Image img;                                       //1

  public Kep() {
    MediaTracker tr = new MediaTracker(this);
    img = Toolkit.getDefaultToolkit().createImage(
                 "images/BelvTempEste.jpg");               //2
    tr.addImage(img,0);
    try {
      tr.waitForID(0);
    }
    catch(InterruptedException e) {
    }
    finally {
      tr.removeImage(img,0);
    }
  }

  protected void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    gr.drawImage(img,10,10,this);                          //3
  }
}

public class ImageTest extends JFrame {
  public ImageTest() {
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new Kep());                       //4
    show();
  }

  public static void main (String args[]) {
    new ImageTest();
  }
}
