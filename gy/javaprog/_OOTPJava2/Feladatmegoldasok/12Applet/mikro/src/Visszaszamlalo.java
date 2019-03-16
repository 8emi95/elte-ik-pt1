/*
 * Feladatmegold�sok/12. fejezet
 * Projekt: mikro
 * Visszaszamlalo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import javax.swing.Timer;
import java.awt.event.*;

public class Visszaszamlalo implements ActionListener {
  /** A h�tral�v� id� m�sodpercben. */
  private int idoMpben;

  /** Id�z�t�, mely m�sodpercenk�nt cs�kkenti az id�t.*/
  private Timer timer;

  /** Ismeri a mikrovez�rl�t, �s �rtes�ti, ha letelt egy m�sodperc vagy lej�rt az id�.*/
  private MikroVezerlo mikroVezerlo;

  public Visszaszamlalo(MikroVezerlo mikroVezerlo) {
    this.mikroVezerlo = mikroVezerlo;
    idoMpben = 0;
    timer = new Timer(1000,this);
  }

  /** 60 mp-cel megn�veli a h�tralev� id�t. Elind�tja az id�z�t�t, ha m�g nem m�k�d�tt.*/
  public void plusz60mp() {
    idoMpben += 60;
    indit();
  }

  /** Id� t�rl�se, id�z�t� le�ll�t�sa.*/
  public void torol() {
    idoMpben = 0;
    timer.stop();
  }

  /** Az id�z�t� �jraindul onnan, ahol volt:*/
  public void indit() {
    if (!timer.isRunning())
      timer.start();
  }

  /** Id�z�t� le�ll�t�sa az id� t�rl�se n�lk�l.*/
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

  /** A sz�mot �talak�tja k�tkarakteres sz�vegg�. Balr�l kieg�sz�ti null�val.*/
  private String formazott(int szam) {
    String str = "0"+szam;
    int n = str.length();
    return str.substring(n-2,n);
  }

  public String toString() {
    return formazott(getPerc())+":"+formazott(getMp());
  }

  /** Letelt egy m�sodperc.*/
  public void actionPerformed(ActionEvent e) {
    idoMpben--;
    mikroVezerlo.mpLetelt();
    if (idoMpben == 0) {
      timer.stop();
      mikroVezerlo.idoLetelt();
    }
  }

}
