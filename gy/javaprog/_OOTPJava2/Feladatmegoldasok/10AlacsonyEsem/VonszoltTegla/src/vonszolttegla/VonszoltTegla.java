/*
 * Feladatmegoldások/10. fejezet
 * Projekt: VonszoltTegla
 * Csomag: vonszolttegla
 * VonszoltTegla.java (fõprogram)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package vonszolttegla;
import figures.*;

import javax.swing.*;
import java.awt.*;

public class VonszoltTegla extends JFrame {
  public VonszoltTegla() {
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setTitle("Téglalap rajzolása vonszolással");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new DrawPanel());
    show();
  }

  public static void main(String[] args) {
    new VonszoltTegla();
  }
}
