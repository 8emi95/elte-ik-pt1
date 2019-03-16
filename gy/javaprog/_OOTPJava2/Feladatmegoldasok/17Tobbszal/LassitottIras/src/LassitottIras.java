/*
 * Feladatmegold�sok/17. fejezet
 * Projekt: LassitottIras
 * LassitottIras.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;

public class LassitottIras extends JFrame {
  Writer writer1, writer2;
  Container cp = getContentPane();

  public LassitottIras() {
    setBounds(200,100,600,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));
    writer1 = new Writer("Ez az els� sz�veg. A sz�vegter�let ezt fogja nyomatni, ar�nylag gyorsan.",80);
    cp.add(new JScrollPane(writer1));
    writer2 = new Writer("Ez a m�sodik sz�veg. Ez a m�sodik ter�leten jelenik meg folyamatosan, kicsit lassabban.",230);
    cp.add(new JScrollPane(writer2));
    show();
  }

  public static void main(String[] args) {
    new LassitottIras();
  }
}
