/*
 * Mintaprogramok/5. fejezet
 * KetKeret.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.JFrame;
import java.awt.Frame;

public class KetKeret {
  public static void main(String[] args) {
    JFrame fr = new JFrame("Els�");
    fr.setSize(500,200);  // m�rete 500*200
    fr.setLocationRelativeTo(null); // a k�perny� k�zep�n lesz
    fr.setResizable(false);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.show();

    fr = new JFrame("M�sodik");
    fr.setBounds(0,0,200,200);
    fr.setState(JFrame.ICONIFIED);
    fr.show();

    System.out.println("Keretek az alkalmaz�sban");
    Frame[] frames = Frame.getFrames();
    for (int i=0; i<frames.length; i++)
      System.out.println(frames[i]);
  }
}

