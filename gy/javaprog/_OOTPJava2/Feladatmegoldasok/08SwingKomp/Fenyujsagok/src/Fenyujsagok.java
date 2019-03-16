/*
 * Feladatmegoldások/8. fejezet
 * Fenyujsagok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class Fenyujsagok extends JFrame {
  public Fenyujsagok() {
    setLocation(100,100);
    setTitle("Fényújság kavalkád");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(0,1));

    cp.add(new Fenyujsag(
      "Ez a fényújság nagyon lassú, és nem is állítható. Mindenesetre egyszerû.",Color.blue,1000));
    cp.add(new GyorsithatoFenyujsag(
      "Ez a fényújság gyorsítható, lassítható. Gyorsolvasók nem unatkoznak.",Color.red,60));
    cp.add(new AllithatoFenyujsag("Ez az igazi! Bármit beállíthatsz. Ne mond, hogy nem tetszik, mert nem hiszem el!",Color.black,100));

    pack();
    show();
  }

  public static void main (String args[]) {
    new Fenyujsagok();
  }
}
