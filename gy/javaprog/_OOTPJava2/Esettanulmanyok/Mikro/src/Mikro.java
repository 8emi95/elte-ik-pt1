import javax.swing.UIManager;
import java.awt.*;

/**
 * A mikrohullámú sütõ fõosztálya.
 * Létrehozza a MikroVezerlo fõablakot.
 * @author Angster Erzsébet
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
    // Ablak középre helyezése
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

  // Main metódus. Létrehozza a Mikro alkalmazást.
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
