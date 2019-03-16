/*
 * Mintaprogramok/Esettanulmányok
 * Projekt: KissEditor
 * Csomag: kisseditor
 * SplashScreen.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2003.04.01.
 *
 * Megjelenít egy keret nélküli ablakot, benne a nyitóképpel. Kattintásra eltûnik.
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

    // Azért Frisco, mert ez jutott eszembe, és ez alapos indok:
    cp.add(lbTitle = new JLabel("Frisco, the funfair",JLabel.CENTER),"South");
    lbTitle.setBackground(Color.white);
    lbTitle.setOpaque(true);
    lbTitle.setForeground(new Color(50,50,100));
    lbTitle.setFont(new Font("Dialog",Font.PLAIN,20));

    // A képet a szülõ ablak közepére igazítjuk:
    int width = imgSplash.getIconWidth();
    int height = imgSplash.getIconHeight()+20; // a címke is helyet foglal
    setSize(width,height);
    setLocationRelativeTo(getParent());

    // Kattintásra és billentyûleütésre eltûnik:
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

  // Csak akkor fogadja a billentyûeseményeket, ha rajta van a fókusz:
  public void show() {
    super.show();
    requestFocus();
  }
}
