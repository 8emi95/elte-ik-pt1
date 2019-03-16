/*
 * Mintaprogramok/9. fejezet
 * KepAtmeretezess.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Kep extends JPanel {                                 //1
  private Image img;              // eredeti k�p
  private Image fittedImg = null; // kicsiny�tett/nagy�tott k�p
  private double ratio;           // ar�ny: sz�less�g/magass�g
  private String fileName;        // a k�p�llom�ny neve
  private MediaTracker tr;

  public Kep(String fileName) {
    // A k�p bet�lt�se file-b�l a m�diak�vet� seg�ts�g�vel:
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

    // Ar�ny (ratio) sz�m�t�sa. Csak akkor j�, ha bet�lt�d�tt a k�p:
    ratio = 1.0*img.getWidth(this)/img.getHeight(this);
    System.out.println("ratio= " + ratio);

    addComponentListener(new ComponentAdapter() {          //3
      // �tm�retezt�k a panelt:
      public void componentResized(ComponentEvent e) {
        // A k�p �tm�retez�se a mediak�vet� seg�ts�g�vel.
        // Igaz�t�s a komponens sz�less�g�hez vagy magass�g�hoz:
        if (getHeight()*ratio>getWidth())                  //4
          // A k�p sz�less�ge a komponens sz�less�ge lesz:
          fittedImg = img.getScaledInstance(getWidth(),-1,Image.SCALE_DEFAULT);
        else
          // A k�p magass�ga a komponens magass�ga lesz:
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
    // A k�p kirajzol�sa:
    gr.drawImage(fittedImg,0,0,this);

    // A k�pf�jl nev�nek megjelen�t�se egy sz�rke t�glalapban:
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
