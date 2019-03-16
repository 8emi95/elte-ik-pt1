import javax.swing.UIManager;
import java.awt.*;

/**
 * A mikrohull�m� s�t� f�oszt�lya.
 * L�trehozza a MikroVezerlo f�ablakot.
 * @author Angster Erzs�bet
 * @version 1.0
 */

public class Mikro {
  boolean packFrame = false;

  /** Konstruktor. */
  public Mikro() {
    MikroVezerlo frame = new MikroVezerlo();
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    // Ablak k�z�pre helyez�se
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }

  // Main met�dus. L�trehozza a Mikro alkalmaz�st.
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new Mikro();
  }
}
