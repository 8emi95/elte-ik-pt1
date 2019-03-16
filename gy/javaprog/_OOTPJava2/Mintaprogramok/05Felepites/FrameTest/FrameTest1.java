/*
 * Mintaprogramok/5. fejezet
 * FrameTest1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * A keret ily m�don val� �sszerak�sa nem k�vetend� p�lda.
 * A keretet a program le�ll�t�s�val lehet becsukni. Lehet�s�gek:
 * - A konzol ablak becsuk�sa;
 * - A konzol ablakon a Ctrl-C le�t�se;
 * - Az oper�ci�s rendszer feladatkezel�j�ben a program bez�r�sa;
 * - A Java k�rnyezetnek van erre egy men�pontja;
 */

import javax.swing.*;
import java.awt.*;

public class FrameTest1 {
  public static void main (String args[]) {
    // Komponensek deklar�l�sa:
    JFrame fr;
    JLabel lbInfo;
    JButton btOk, btNemOk;

    // A csupasz keret l�trehoz�sa:
    fr = new JFrame();

    // C�m, poz�ci� �s m�ret megad�sa:
    fr.setTitle("Frame-teszt");
    fr.setBounds(100,50,300,100);

    // Tartalompanel kik�r�se:
    Container cp = fr.getContentPane();
    // Tartalompanel elrendez�smenedzser�nek be�ll�t�sa:
    cp.setLayout(new FlowLayout());

    // Komponensek l�trehoz�sa:
    lbInfo = new JLabel("D�ntsd el:");
    btOk = new JButton("OK");
    btNemOk = new JButton("Nem OK");

    // Komponensek beilleszt�se a tartalompanelbe:
    cp.add(lbInfo);
    cp.add(btOk);
    cp.add(btNemOk);

    // A keret l�that�v� t�tele:
    fr.setVisible(true);
  } // main
} // FrameTest1
