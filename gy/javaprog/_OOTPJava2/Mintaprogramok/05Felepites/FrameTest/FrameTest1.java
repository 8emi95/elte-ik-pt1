/*
 * Mintaprogramok/5. fejezet
 * FrameTest1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * A keret ily módon való összerakása nem követendõ példa.
 * A keretet a program leállításával lehet becsukni. Lehetõségek:
 * - A konzol ablak becsukása;
 * - A konzol ablakon a Ctrl-C leütése;
 * - Az operációs rendszer feladatkezelõjében a program bezárása;
 * - A Java környezetnek van erre egy menüpontja;
 */

import javax.swing.*;
import java.awt.*;

public class FrameTest1 {
  public static void main (String args[]) {
    // Komponensek deklarálása:
    JFrame fr;
    JLabel lbInfo;
    JButton btOk, btNemOk;

    // A csupasz keret létrehozása:
    fr = new JFrame();

    // Cím, pozíció és méret megadása:
    fr.setTitle("Frame-teszt");
    fr.setBounds(100,50,300,100);

    // Tartalompanel kikérése:
    Container cp = fr.getContentPane();
    // Tartalompanel elrendezésmenedzserének beállítása:
    cp.setLayout(new FlowLayout());

    // Komponensek létrehozása:
    lbInfo = new JLabel("Döntsd el:");
    btOk = new JButton("OK");
    btNemOk = new JButton("Nem OK");

    // Komponensek beillesztése a tartalompanelbe:
    cp.add(lbInfo);
    cp.add(btOk);
    cp.add(btNemOk);

    // A keret láthatóvá tétele:
    fr.setVisible(true);
  } // main
} // FrameTest1
