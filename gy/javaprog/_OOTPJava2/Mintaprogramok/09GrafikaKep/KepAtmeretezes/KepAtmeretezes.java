/*
 * Mintaprogramok/9. fejezet
 * KepAtmeretezess.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Kep extends JPanel {                                 //1
  private Image img;              // eredeti kép
  private Image fittedImg = null; // kicsinyített/nagyított kép
  private double ratio;           // arány: szélesség/magasság
  private String fileName;        // a képállomány neve
  private MediaTracker tr;

  public Kep(String fileName) {
    // A kép betöltése file-ból a médiakövetõ segítségével:
    this.fileName = fileName;
    img = Toolkit.getDefaultToolkit().createImage(fileName);//2
    tr = new MediaTracker(this);
    tr.addImage(img,0);
    try {
      tr.waitForID(0);
    }
    catch (InterruptedException ex) {
    }
    finally {
      tr.removeImage(img,0);
    }

    // Arány (ratio) számítása. Csak akkor jó, ha betöltõdött a kép:
    ratio = 1.0*img.getWidth(this)/img.getHeight(this);
    System.out.println("ratio= " + ratio);

    addComponentListener(new ComponentAdapter() {          //3
      // Átméretezték a panelt:
      public void componentResized(ComponentEvent e) {
        // A kép átméretezése a mediakövetõ segítségével.
        // Igazítás a komponens szélességéhez vagy magasságához:
        if (getHeight()*ratio>getWidth())                  //4
          // A kép szélessége a komponens szélessége lesz:
          fittedImg = img.getScaledInstance(getWidth(),-1,Image.SCALE_DEFAULT);
        else
          // A kép magassága a komponens magassága lesz:
          fittedImg = img.getScaledInstance(-1,getHeight(),Image.SCALE_DEFAULT);

        tr = new MediaTracker(e.getComponent());           //5
        tr.addImage(fittedImg,0);
        try {
          tr.waitForID(0);
        }
        catch (InterruptedException ex) {
        }
        finally {
          tr.removeImage(img,0);
        }
      }
    });
  }

  protected void paintComponent(Graphics gr) {             //6
    super.paintComponent(gr);
    // A kép kirajzolása:
    gr.drawImage(fittedImg,0,0,this);

    // A képfájl nevének megjelenítése egy szürke téglalapban:
    gr.setColor(Color.LIGHT_GRAY);
    gr.fillRoundRect(0,getHeight()-30,300,30,5,5);
    gr.setColor(Color.BLACK);
    gr.drawRoundRect(0,getHeight()-30,300,30,5,5);
    gr.setFont(new Font("TimesRoman",Font.PLAIN,20));
    gr.drawString(fileName,10,getHeight()-10);
  }
}

public class KepAtmeretezes extends JFrame {

  public KepAtmeretezes() {                                   //7
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0,0,dim.width,dim.height-50);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(new Kep("images/SanFran.jpg"));
    //getContentPane().add(new Kep("images/auto.jpg"));
    //getContentPane().add(new Kep("images/PosterChild.jpg"));
    show();
  }

  public static void main (String args[]) {
    new KepAtmeretezes();
  }
}
