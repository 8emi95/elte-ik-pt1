/*
 * Mintaprogramok/5. fejezet
 * KeretKozepen.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

/* A keretre �rt adatok csak addig �rv�nyesek, am�g az ablakot
 * el nem mozd�tj�k vagy �t nem m�retezik.
 */

public class KeretKozepen extends JFrame {
  public KeretKozepen() {
    Toolkit tk = Toolkit.getDefaultToolkit();
    setIconImage(tk.createImage("icons/dukewave.gif"));
    Dimension screenSize = tk.getScreenSize();
    int width = screenSize.width/2;
    int height = screenSize.height/2;
    int x = (screenSize.width-width)/2;
    int y = (screenSize.height-height)/2;
    setBounds(x,y,width,height);
    setTitle("Keret a k�perny� k�zep�n");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp = getContentPane();
    JLabel lbInfo = new JLabel("("+x+","+y+","+
        width+","+height+")",JLabel.CENTER);
    lbInfo.setFont(new Font("Dialog",Font.PLAIN,35)); // Hogy jobban l�ssalak
    cp.add(lbInfo);

    show();
  }

  public static void main (String args[]) {
    new KeretKozepen();
  }
}
