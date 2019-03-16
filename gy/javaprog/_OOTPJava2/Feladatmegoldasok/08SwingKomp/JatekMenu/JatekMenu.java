/*
 * Feladatmegold�sok/8. fejezet
 * JatekMenu.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Felasat (A): K�sz�tse el a sz�m�t�g�p�n tal�lhat� valamely
 * j�t�kprogram men�j�t! P�ld�ul:
 *
 * J�t�k
 *    �j j�t�k
 *    -------
 *    >Kezd�
 *     Halad�
 *     Mester
 *    -------
 *    Kil�p�s
 * S�g�
 *    Tartalom
 *    T�mak�r�k...
 *    A nap tippje
 *    -------
 *    N�vjegy
 */

import javax.swing.*;
import java.awt.*;

public class JatekMenu extends JFrame {

  private JMenuBar mb = new JMenuBar();
  private JMenu mJatek = new JMenu("J�t�k");
  private JMenuItem miUjJatek = new JMenuItem("�j j�t�k");
  private JRadioButtonMenuItem miKezdo = new JRadioButtonMenuItem("Kezd�",true);
  private JRadioButtonMenuItem miHalado = new JRadioButtonMenuItem("Halad�");
  private JRadioButtonMenuItem miMester = new JRadioButtonMenuItem("Mester");
  private ButtonGroup bgSzint = new ButtonGroup();
  private JMenuItem miKilep = new JMenuItem("Kil�p");

  private JMenu mSugo = new JMenu("S�g�");
  private JMenuItem miTartalom = new JMenuItem("Tartalom");
  private JMenuItem miTemakorok = new JMenuItem("T�mak�r�k...");
  private JMenuItem miNapTipp = new JMenuItem("A nap tippje");
  private JMenuItem miNevjegy = new JMenuItem("N�vjegy");

  public JatekMenu() {
    setBounds(100,100,300,300);
    setTitle("J�t�k");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // F�men�:
    setJMenuBar(mb);
    mb.add(mJatek);
    mb.add(mSugo);

    // J�t�k men�:
    mJatek.add(miUjJatek);
    mJatek.addSeparator();
    mJatek.add(miKezdo);
    mJatek.add(miHalado);
    mJatek.add(miMester);
    mJatek.addSeparator();
    mJatek.add(miKilep);

    bgSzint.add(miKezdo);
    bgSzint.add(miHalado);
    bgSzint.add(miMester);

    // S�g� men�:
    mSugo.add(miTartalom);
    mSugo.add(miTemakorok);
    mSugo.add(miNapTipp);
    mSugo.addSeparator();
    mSugo.add(miNevjegy);

    show();
  }

  public static void main(String[] args) {
    new JatekMenu();
  }
}
