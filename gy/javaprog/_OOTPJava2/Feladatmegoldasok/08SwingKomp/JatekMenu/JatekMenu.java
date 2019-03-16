/*
 * Feladatmegoldások/8. fejezet
 * JatekMenu.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Felasat (A): Készítse el a számítógépén található valamely
 * játékprogram menüjét! Például:
 *
 * Játék
 *    Új játék
 *    -------
 *    >Kezdõ
 *     Haladó
 *     Mester
 *    -------
 *    Kilépés
 * Súgó
 *    Tartalom
 *    Témakörök...
 *    A nap tippje
 *    -------
 *    Névjegy
 */

import javax.swing.*;
import java.awt.*;

public class JatekMenu extends JFrame {

  private JMenuBar mb = new JMenuBar();
  private JMenu mJatek = new JMenu("Játék");
  private JMenuItem miUjJatek = new JMenuItem("Új játék");
  private JRadioButtonMenuItem miKezdo = new JRadioButtonMenuItem("Kezdõ",true);
  private JRadioButtonMenuItem miHalado = new JRadioButtonMenuItem("Haladó");
  private JRadioButtonMenuItem miMester = new JRadioButtonMenuItem("Mester");
  private ButtonGroup bgSzint = new ButtonGroup();
  private JMenuItem miKilep = new JMenuItem("Kilép");

  private JMenu mSugo = new JMenu("Súgó");
  private JMenuItem miTartalom = new JMenuItem("Tartalom");
  private JMenuItem miTemakorok = new JMenuItem("Témakörök...");
  private JMenuItem miNapTipp = new JMenuItem("A nap tippje");
  private JMenuItem miNevjegy = new JMenuItem("Névjegy");

  public JatekMenu() {
    setBounds(100,100,300,300);
    setTitle("Játék");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // Fõmenü:
    setJMenuBar(mb);
    mb.add(mJatek);
    mb.add(mSugo);

    // Játék menü:
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

    // Súgó menü:
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
