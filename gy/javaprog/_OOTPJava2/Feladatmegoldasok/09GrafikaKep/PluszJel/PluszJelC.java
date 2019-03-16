/*
 * Feladatmegoldások/9. fejezet
 * PluszJelC.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Rajz extends JPanel {
  private Color szin;
  private int vastagsag;

  public Rajz(Color szin, int vastagsag) {
    this.szin = szin;
    this.vastagsag = vastagsag;
  }

  public void paint(Graphics g) {
    super.paintComponent(g);
    g.setColor(szin);
    int x = getWidth();
    int y = getHeight();
    for (int i = 0; i<vastagsag; i++)
      g.drawLine(x/2-vastagsag/2+i,0,x/2-vastagsag/2+i,y);

    for (int i = 0; i<vastagsag; i++)
      g.drawLine(0,y/2-vastagsag/2+i,x,y/2-vastagsag/2+i);
  }
}

public class PluszJelC extends JFrame {
  public PluszJelC() {
    setBounds(100,100,500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // A vonal vastagságának bekérése:
    int vastagsag = 0;
    String strVastagsag = JOptionPane.showInputDialog(null,"A vonal vastagsága: ");
    if (strVastagsag == null)
      System.exit(0);
    try {
      vastagsag = Integer.parseInt(strVastagsag);
    }
    catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null,"Ez nem szám!");
      System.exit(0);
    }

    // A vonal színének bekérése:
    Color szin = Color.black;
    szin = JColorChooser.showDialog(null,"A vonal színe: ",szin);
    if (szin == null)
      System.exit(0);

    // A rajz elkészítése:
    getContentPane().add(new Rajz(szin,vastagsag));
    show();
  }

  public static void main (String args[]) {
    new PluszJelC();
  }
}
