/*
 * Feladatmegoldások/17. fejezet
 * Projekt: LassitottIras
 * LassitottIras.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
    writer1 = new Writer("Ez az elsõ szöveg. A szövegterület ezt fogja nyomatni, aránylag gyorsan.",80);
    cp.add(new JScrollPane(writer1));
    writer2 = new Writer("Ez a második szöveg. Ez a második területen jelenik meg folyamatosan, kicsit lassabban.",230);
    cp.add(new JScrollPane(writer2));
    show();
  }

  public static void main(String[] args) {
    new LassitottIras();
  }
}
