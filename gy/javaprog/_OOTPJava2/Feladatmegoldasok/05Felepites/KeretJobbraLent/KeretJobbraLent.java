/*
 * Feladatmegoldások/5. fejezet
 * KeretJobbraLent.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class KeretJobbraLent extends JFrame {

  public KeretJobbraLent() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(screenSize.width/2,screenSize.height/2,
      screenSize.width/2,screenSize.height/2);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(0,1));
    cp.add(new JLabel("Location=("+getX()+","+getY()+");    Size="+
      getWidth()+"x"+getHeight(),SwingConstants.CENTER));
    show();
  }

  public static void main (String args[]) {
    new KeretJobbraLent();
  }
}
