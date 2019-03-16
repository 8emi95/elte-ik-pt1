/*
 * Feladatmegoldások/17. fejezet
 * Dialogusok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Jelenítse meg következõ dialógusokat, felhasználva a Java beépített lehetõségeit!
 *
 * a) Hibakijelzés. Cím: nincs; Megjelenõ szöveg: "Nem süt a nap!"; Gomb: OK.
 * b) Kérdés. Cím: nincs; Megjelenõ kérdés: "Ön a tengerparton van?";
 *    Gomb: Yes, No. Ha a Yes-t ütik le, akkor
 * c) Információ. Cím: "Csak hogy tudja..."; Megjelenõ szöveg: "Én is megyek.";
 *    Gomb: OK.
 * d) Kérdés. Cím: "Diszkréció"; Megjelenõ kérdés: "Mennyit keres havonta EURO-ban?";
 *    Gomb: OK. Ha 100000 nél kevesebbet vagy hibás adatot ír be, akkor
 * e) Figyelmeztetés. Cím: "Csalódás"; Megjelenõ szöveg: "Mégsem megyek";
 *    Gomb: Rendben. (Magyar feliratú gomb!)
 *
 * A dialógusok a fõ keret közepén jelenjenek meg, kivéve az utolsó kettõt,
 * melyek a keret közepén jelenjenek meg!
 */

import javax.swing.*;
import java.awt.*;

public class Dialogusok extends JFrame {
  public Dialogusok() {
    setTitle("Dialógusok");
    setBounds(200,100,400,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    show();
    // a)
    JOptionPane.showMessageDialog(this,"Nem süt a nap!","",JOptionPane.ERROR_MESSAGE);
    // b)
    if (JOptionPane.showConfirmDialog(this,"Ön a tengerparton van?","",
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
    // c)
      JOptionPane.showMessageDialog(this,"Én is megyek.","Csak hogy tudja...",
          JOptionPane.PLAIN_MESSAGE);
    // d)
    String osszegStr = JOptionPane.showInputDialog(null,
        "Mennyit keres havonta EURO-ban?","Diszkréció",
        JOptionPane.QUESTION_MESSAGE);
    // e)
    try {
      int osszeg = Integer.parseInt(osszegStr);
      if (osszeg<100000)
        throw new Exception();
    }
    catch (Exception ex) {
      String[] opciok = {"Rendben"};
      JOptionPane.showOptionDialog(null,"Mégsem megyek.",
          "Csalódás",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,
          new ImageIcon("icons/fox.gif"),opciok,opciok[0]);
    }
  }

  public static void main(String[] args) {
    new Dialogusok();
  }
}
