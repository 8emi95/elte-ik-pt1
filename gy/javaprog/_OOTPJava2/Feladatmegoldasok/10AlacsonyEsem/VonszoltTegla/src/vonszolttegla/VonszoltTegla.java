/*
 * Feladatmegold�sok/10. fejezet
 * Projekt: VonszoltTegla
 * Csomag: vonszolttegla
 * VonszoltTegla.java (f�program)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package vonszolttegla;
import figures.*;

import javax.swing.*;
import java.awt.*;

public class VonszoltTegla extends JFrame {
  public VonszoltTegla() {
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setTitle("T�glalap rajzol�sa vonszol�ssal");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new DrawPanel());
    show();
  }

  public static void main(String[] args) {
    new VonszoltTegla();
  }
}
