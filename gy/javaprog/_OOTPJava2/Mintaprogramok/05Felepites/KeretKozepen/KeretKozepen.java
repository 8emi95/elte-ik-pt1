/*
 * Mintaprogramok/5. fejezet
 * KeretKozepen.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

/* A keretre írt adatok csak addig érvényesek, amíg az ablakot
 * el nem mozdítják vagy át nem méretezik.
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
    setTitle("Keret a képernyõ közepén");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp = getContentPane();
    JLabel lbInfo = new JLabel("("+x+","+y+","+
        width+","+height+")",JLabel.CENTER);
    lbInfo.setFont(new Font("Dialog",Font.PLAIN,35)); // Hogy jobban lássalak
    cp.add(lbInfo);

    show();
  }

  public static void main (String args[]) {
    new KeretKozepen();
  }
}
