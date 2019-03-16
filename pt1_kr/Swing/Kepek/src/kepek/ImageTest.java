
import java.awt.*;
import javax.swing.*;

/**
 * A Kep egy speciális panel, mely meg tud jeleníteni egy képet.
 * 
 * @version 2017. május 9.
 * encoding: windows-1250
 */
class Kep extends JPanel {
  /** A Kep-en megjelenő kép objektum. */    
  private Image img;                                       //1

  /**
   * Betölt egy képet a MediaTracker használatával.
   * Az img objektumot létrehozza.
   */
  public Kep() {
    // A kép betöltése egy külön programszálon. Azonnal visszatér.
    img = Toolkit.getDefaultToolkit().createImage( // jpg, gif, png
            "images/PH02829J.jpg");
            //"images/AG00126_.gif");
            //"images/SecurityAndMaintenance.png");
    // MediaTracker nélkül is működik, de így biztonságosabb.      
    MediaTracker tr = new MediaTracker(this);    
    tr.addImage(img, 0);
    try {
      tr.waitForID(0); // Vár, amíg a kép betöltődik a külön szálon.
    }
    catch(InterruptedException e) {
    }
    finally {
      tr.removeImage(img, 0);
    }
    // A kép betöltődött.
  } // konstruktor

  /**
   * Automatikusan meghívódik, ha újra kell rajzolni a Kep
   * komponenst.
   * A Kep felületére kirajzolja az img-ben
   * törölt képet.
   * @param g Az operációs rendszertől kapott grafikus objektum,
   *          erre rajzolódik ki a kép.
   */
  @Override  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, 5, 5, this);                          //3
  }
} // class Kep

/**
 * Az alkalmazás ablaka.
 * @version 2017. május 9.
 */
public class ImageTest extends JFrame {
  /**
   * Beállítja a keret tulajdonságait; majd megjelenőti a keretet.
   * A keret tartalom-paneljéhez hozzáadja a Kep-et.
   */
  public ImageTest() {
    setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Teljes képernyő
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new Kep());
    setVisible(true);
  }

  /**
   * Az alkalmazás belépési pontja.
   * @param args Parancssori paraméterek
   */
  public static void main (String args[]) {
    new ImageTest();
  }
} // class ImageTest
