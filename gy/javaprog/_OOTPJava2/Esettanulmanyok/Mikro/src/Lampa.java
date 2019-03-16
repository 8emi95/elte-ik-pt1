import javax.swing.*;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *  <p>Egy címke, mely állaptától függõen más képet jelenít meg, és más a háttere:</p>
 *  <li>ha be van kapcsolva: lampabe.jpg, háttér szürke</li>
 *  <li>ha ki van kapcsolva: lampaki.jpg, háttér fekete</li>
 * @author Angster Erzsébet
 * @version 1.0
 */

public class Lampa extends JLabel {
  private boolean vilagit = false;
  private ImageIcon imgLampaBe;
  private ImageIcon imgLampaKi;

  public Lampa() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    imgLampaBe = new ImageIcon(getClass().getResource("image/lampabe.jpg"));
    imgLampaKi = new ImageIcon(getClass().getResource("image/lampaki.jpg"));
    this.setText("");
    this.setOpaque(true);
    this.setHorizontalAlignment(SwingConstants.CENTER);
    kikapcsol();
  }

  public void bekapcsol() {
    vilagit = true;
    this.setBackground(new Color(190,190,190));
    this.setIcon(imgLampaBe);
  }

  public void kikapcsol() {
    vilagit = false;
    this.setBackground(Color.black);
    this.setIcon(imgLampaKi);
  }
}
