/*
 * Feladatmegold�sok/9. fejezet
 * PluszJelC.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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

    // A vonal vastags�g�nak bek�r�se:
    int vastagsag = 0;
    String strVastagsag = JOptionPane.showInputDialog(null,"A vonal vastags�ga: ");
    if (strVastagsag == null)
      System.exit(0);
    try {
      vastagsag = Integer.parseInt(strVastagsag);
    }
    catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null,"Ez nem sz�m!");
      System.exit(0);
    }

    // A vonal sz�n�nek bek�r�se:
    Color szin = Color.black;
    szin = JColorChooser.showDialog(null,"A vonal sz�ne: ",szin);
    if (szin == null)
      System.exit(0);

    // A rajz elk�sz�t�se:
    getContentPane().add(new Rajz(szin,vastagsag));
    show();
  }

  public static void main (String args[]) {
    new PluszJelC();
  }
}
