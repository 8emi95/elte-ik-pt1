/*
 * Feladatmegold�sok/8. fejezet
 * Fenyujsagok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

public class Fenyujsagok extends JFrame {
  public Fenyujsagok() {
    setLocation(100,100);
    setTitle("F�ny�js�g kavalk�d");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(0,1));

    cp.add(new Fenyujsag(
      "Ez a f�ny�js�g nagyon lass�, �s nem is �ll�that�. Mindenesetre egyszer�.",Color.blue,1000));
    cp.add(new GyorsithatoFenyujsag(
      "Ez a f�ny�js�g gyors�that�, lass�that�. Gyorsolvas�k nem unatkoznak.",Color.red,60));
    cp.add(new AllithatoFenyujsag("Ez az igazi! B�rmit be�ll�thatsz. Ne mond, hogy nem tetszik, mert nem hiszem el!",Color.black,100));

    pack();
    show();
  }

  public static void main (String args[]) {
    new Fenyujsagok();
  }
}
