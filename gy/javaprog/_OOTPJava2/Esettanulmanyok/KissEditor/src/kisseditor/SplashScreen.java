/*
 * Mintaprogramok/Esettanulm�nyok
 * Projekt: KissEditor
 * Csomag: kisseditor
 * SplashScreen.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2003.04.01.
 *
 * Megjelen�t egy keret n�lk�li ablakot, benne a nyit�k�ppel. Kattint�sra elt�nik.
 */

package kisseditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplashScreen extends JWindow {
  private Container cp = getContentPane();
  private JLabel lbTitle;
  private ImageIcon imgSplash = new ImageIcon(
      getClass().getResource("resources/sanfran.jpg"));

  public SplashScreen(JFrame parent) {
    super(parent);
    cp.add(new JLabel(imgSplash));

    // Az�rt Frisco, mert ez jutott eszembe, �s ez alapos indok:
    cp.add(lbTitle = new JLabel("Frisco, the funfair",JLabel.CENTER),"South");
    lbTitle.setBackground(Color.white);
    lbTitle.setOpaque(true);
    lbTitle.setForeground(new Color(50,50,100));
    lbTitle.setFont(new Font("Dialog",Font.PLAIN,20));

    // A k�pet a sz�l� ablak k�zep�re igaz�tjuk:
    int width = imgSplash.getIconWidth();
    int height = imgSplash.getIconHeight()+20; // a c�mke is helyet foglal
    setSize(width,height);
    setLocationRelativeTo(getParent());

    // Kattint�sra �s billenty�le�t�sre elt�nik:
    addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        hide();
      }
    });
    addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        hide();
      }
    });
  }

  // Csak akkor fogadja a billenty�esem�nyeket, ha rajta van a f�kusz:
  public void show() {
    super.show();
    requestFocus();
  }
}
