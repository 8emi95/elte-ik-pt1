/*
 * Mintaprogramok/5. fejezet
 * KetKeret.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.JFrame;
import java.awt.Frame;

public class KetKeret {
  public static void main(String[] args) {
    JFrame fr = new JFrame("Elsõ");
    fr.setSize(500,200);  // mérete 500*200
    fr.setLocationRelativeTo(null); // a képernyõ közepén lesz
    fr.setResizable(false);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.show();

    fr = new JFrame("Második");
    fr.setBounds(0,0,200,200);
    fr.setState(JFrame.ICONIFIED);
    fr.show();

    System.out.println("Keretek az alkalmazásban");
    Frame[] frames = Frame.getFrames();
    for (int i=0; i<frames.length; i++)
      System.out.println(frames[i]);
  }
}

