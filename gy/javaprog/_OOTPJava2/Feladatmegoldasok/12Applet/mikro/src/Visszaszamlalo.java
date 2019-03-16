/*
 * Feladatmegoldások/12. fejezet
 * Projekt: mikro
 * Visszaszamlalo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.Timer;
import java.awt.event.*;

public class Visszaszamlalo implements ActionListener {
  /** A hátralévõ idõ másodpercben. */
  private int idoMpben;

  /** Idõzítõ, mely másodpercenként csökkenti az idõt.*/
  private Timer timer;

  /** Ismeri a mikrovezérlõt, és értesíti, ha letelt egy másodperc vagy lejárt az idõ.*/
  private MikroVezerlo mikroVezerlo;

  public Visszaszamlalo(MikroVezerlo mikroVezerlo) {
    this.mikroVezerlo = mikroVezerlo;
    idoMpben = 0;
    timer = new Timer(1000,this);
  }

  /** 60 mp-cel megnöveli a hátralevõ idõt. Elindítja az idõzítõt, ha még nem mûködött.*/
  public void plusz60mp() {
    idoMpben += 60;
    indit();
  }

  /** Idõ törlése, idõzítõ leállítása.*/
  public void torol() {
    idoMpben = 0;
    timer.stop();
  }

  /** Az idõzítõ újraindul onnan, ahol volt:*/
  public void indit() {
    if (!timer.isRunning())
      timer.start();
  }

  /** Idõzítõ leállítása az idõ törlése nélkül.*/
  public void megallit() {
    timer.stop();
  }

  public int getPerc() {
    return idoMpben / 60;
  }

  public int getMp() {
    return idoMpben % 60;
  }

  public boolean nulla() {
    return idoMpben == 0;
  }

  /** A számot átalakítja kétkarakteres szöveggé. Balról kiegészíti nullával.*/
  private String formazott(int szam) {
    String str = "0"+szam;
    int n = str.length();
    return str.substring(n-2,n);
  }

  public String toString() {
    return formazott(getPerc())+":"+formazott(getMp());
  }

  /** Letelt egy másodperc.*/
  public void actionPerformed(ActionEvent e) {
    idoMpben--;
    mikroVezerlo.mpLetelt();
    if (idoMpben == 0) {
      timer.stop();
      mikroVezerlo.idoLetelt();
    }
  }

}
