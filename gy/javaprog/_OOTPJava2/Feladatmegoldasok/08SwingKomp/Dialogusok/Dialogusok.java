/*
 * Feladatmegold�sok/17. fejezet
 * Dialogusok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Jelen�tse meg k�vetkez� dial�gusokat, felhaszn�lva a Java be�p�tett lehet�s�geit!
 *
 * a) Hibakijelz�s. C�m: nincs; Megjelen� sz�veg: "Nem s�t a nap!"; Gomb: OK.
 * b) K�rd�s. C�m: nincs; Megjelen� k�rd�s: "�n a tengerparton van?";
 *    Gomb: Yes, No. Ha a Yes-t �tik le, akkor
 * c) Inform�ci�. C�m: "Csak hogy tudja..."; Megjelen� sz�veg: "�n is megyek.";
 *    Gomb: OK.
 * d) K�rd�s. C�m: "Diszkr�ci�"; Megjelen� k�rd�s: "Mennyit keres havonta EURO-ban?";
 *    Gomb: OK. Ha 100000 n�l kevesebbet vagy hib�s adatot �r be, akkor
 * e) Figyelmeztet�s. C�m: "Csal�d�s"; Megjelen� sz�veg: "M�gsem megyek";
 *    Gomb: Rendben. (Magyar felirat� gomb!)
 *
 * A dial�gusok a f� keret k�zep�n jelenjenek meg, kiv�ve az utols� kett�t,
 * melyek a keret k�zep�n jelenjenek meg!
 */

import javax.swing.*;
import java.awt.*;

public class Dialogusok extends JFrame {
  public Dialogusok() {
    setTitle("Dial�gusok");
    setBounds(200,100,400,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    show();
    // a)
    JOptionPane.showMessageDialog(this,"Nem s�t a nap!","",JOptionPane.ERROR_MESSAGE);
    // b)
    if (JOptionPane.showConfirmDialog(this,"�n a tengerparton van?","",
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
    // c)
      JOptionPane.showMessageDialog(this,"�n is megyek.","Csak hogy tudja...",
          JOptionPane.PLAIN_MESSAGE);
    // d)
    String osszegStr = JOptionPane.showInputDialog(null,
        "Mennyit keres havonta EURO-ban?","Diszkr�ci�",
        JOptionPane.QUESTION_MESSAGE);
    // e)
    try {
      int osszeg = Integer.parseInt(osszegStr);
      if (osszeg<100000)
        throw new Exception();
    }
    catch (Exception ex) {
      String[] opciok = {"Rendben"};
      JOptionPane.showOptionDialog(null,"M�gsem megyek.",
          "Csal�d�s",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,
          new ImageIcon("icons/fox.gif"),opciok,opciok[0]);
    }
  }

  public static void main(String[] args) {
    new Dialogusok();
  }
}
