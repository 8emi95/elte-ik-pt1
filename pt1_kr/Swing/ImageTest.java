
import java.awt.*;
import javax.swing.*;

/**
 * A <code>Kep</code> egy speci�lis panel, mely meg tud jelen�teni egy k�pet.
 * 
 * @version 2017. m�jus 9.
 * encoding: windows-1250
 */
class Kep extends JPanel {
  /** A <code>Kep</code>-en megjelen� k�p objektum. */    
  private Image img;                                       //1

  /**
   * Bet�lt egy k�pet a <code>MediaTracker</code> haszn�lat�val.
   * Az <code>img</code> objektumot l�trehozza.
   */
  public Kep() {
    // A k�p bet�lt�se egy k�l�n programsz�lon. Azonnal visszat�r.
    img = Toolkit.getDefaultToolkit().createImage( // jpg, gif, png
            "images/PH02829J.jpg");
            //"images/AG00126_.gif");
            //"images/SecurityAndMaintenance.png");
    // MediaTracker n�lk�l is m�k�dik, de �gy biztons�gosabb.      
    MediaTracker tr = new MediaTracker(this);    
    tr.addImage(img, 0);
    try {
      tr.waitForID(0); // V�r, am�g a k�p bet�lt�dik a k�l�n sz�lon.
    }
    catch(InterruptedException e) {
    }
    finally {
      tr.removeImage(img, 0);
    }
    // A k�p bet�lt�d�tt.
  } // konstruktor

  /**
   * Automatikusan megh�v�dik, ha �jra kell rajzolni a <code>Kep</code>
   * komponenst.
   * A <code>Kep</code> fel�let�re kirajzolja az <code>img</code>-ben
   * t�rolt k�pet.
   * @param g Az oper�ci�s rendszert�l kapott grafikus objektum,
   *          erre rajzol�dik ki a k�p.
   */
  @Override  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, 5, 5, this);                          //3
  }
} // class Kep

/**
 * Az alkalmaz�s ablaka.
 * @version 2017. m�jus 9.
 */
public class ImageTest extends JFrame {
  /**
   * Be�ll�tja a keret tulajdons�gait; majd megjelen�ti a keretet.
   * A keret tartalom-panelj�hez hozz�adja a <code>Kep</code>-et.
   */
  public ImageTest() {
    setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Teljes k�perny�
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new Kep());
    setVisible(true);
  }

  /**
   * Az alkalmaz�s bel�p�si pontja.
   * @param args Parancssori param�terek
   */
  public static void main (String args[]) {
    new ImageTest();
  }
} // class ImageTest
