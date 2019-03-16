import javax.swing.*;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *  <p>Egy c�mke, mely �llapt�t�l f�gg�en m�s k�pet jelen�t meg, �s m�s a h�ttere:</p>
 *  <li>ha be van kapcsolva: lampabe.jpg, h�tt�r sz�rke</li>
 *  <li>ha ki van kapcsolva: lampaki.jpg, h�tt�r fekete</li>
 * @author Angster Erzs�bet
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
