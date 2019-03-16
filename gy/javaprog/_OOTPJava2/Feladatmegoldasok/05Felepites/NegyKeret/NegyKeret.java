/*
 * Feladatmegoldások/5. fejezet
 * NegyKeret.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import extra.frame.*;

public class NegyKeret {
  public static void main (String args[]) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = screenSize.width/2;
    int h = screenSize.height/2;

    CloseableFrame fr1, fr2, fr3, fr4;

    fr1 = new CloseableFrame();
    fr1.setBounds(0,0,w,h);
    fr1.show();

    fr2 = new CloseableFrame();
    fr2.setBounds(0,h,w,h);
    fr2.show();

    fr3 = new CloseableFrame();
    fr3.setBounds(w,0,w,h);
    fr3.show();

    fr4 = new CloseableFrame();
    fr4.setBounds(w,h,w,h);
    fr4.show();
  }
}
