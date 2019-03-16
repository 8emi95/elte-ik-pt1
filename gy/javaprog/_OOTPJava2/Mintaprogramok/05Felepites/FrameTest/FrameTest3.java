/*
 * Mintaprogramok/5. fejezet
 * FrameTest3.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

class SpecFrame extends JFrame {
  public SpecFrame() {
    setTitle("Frame-teszt");
    setBounds(100,50,300,100);

    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());

    cp.add(new JLabel("Döntsd el:"));
    cp.add(new JButton("OK"));
    cp.add(new JButton("Nem OK"));
    pack();
    show();
  }
}

public class FrameTest3 {
  public static void main (String args[]) {
    new SpecFrame();
  } // main
} // FrameTest3
