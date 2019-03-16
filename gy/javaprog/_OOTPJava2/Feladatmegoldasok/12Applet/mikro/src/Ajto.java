/*
 * Feladatmegold�sok/12. fejezet
 * Projekt: mikro
 * Ajto.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Be lehet csukni �s ki lehet nyitni.
 * Hangot ad: csuk�skor "ajtocsuk.wav", nyit�skor "ajtonyit.wav".
 * M�s a kin�zete a becsukott �s a nyitott ajt�nak.
 *
 * Egyel�re az �telt az ajt�ra tessz�k.
 * Majd egy tov�bbfejlesztett v�ltozatban m�sk�pp lesz...
 *
 * @author Angster Erzs�bet
 * @version 1.0
 */

public class Ajto extends JLabel {
  private boolean nyitva = false;
  private Hang ajtonyit;
  private Hang ajtocsuk;

  /** L�trehozza az ajt�t. */
  public Ajto() {
    try {
      ajtonyit = new Hang(getClass().getResource("sound/ajtonyit.wav"));
      ajtocsuk = new Hang(getClass().getResource("sound/ajtocsuk.wav"));
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    setFont(new java.awt.Font("Dialog", 1, 16));
    setHorizontalAlignment(SwingConstants.CENTER);
    setOpaque(true);
    setForeground(Color.gray);
    kinezet();
  }

  /** Kinyitja az ajt�t, felt�ve, hogy az ajt� csukva volt.
   *  Megsz�lal egy ajt�nyit�s hang, megv�ltozik az ajt� kin�zete.
   */
  public void kinyit() {
    if (nyitva)
      return;
    nyitva = true;

    // Nyit�si hang:
    ajtonyit.lejatszik();

    // Keret kin�zete:
    kinezet();
  }

  /** Becsukja az ajt�t, felt�ve, hogy az ajt� nyitva volt.
   *  Megsz�lal egy ajt�csuk�s hang, megv�ltozik az ajt� kin�zete.
   */
  public void becsuk() {
    if (! nyitva)
      return;
    nyitva = false;

    // Becsuk�si hang:
    ajtocsuk.lejatszik();

    // Keret kin�zete:
    kinezet();

  }

  protected void kinezet() {
    if (nyitva) {
      setBackground(new Color(190,190,190));
      setText("Ajt� nyitva");
    }
    else {
      setBackground(Color.black);
      setText("Ajt� csukva");
    }
  }

  /** Megmondja, hogy az ajt� nyitva van-e */
  public boolean isNyitva() {
    return nyitva;
  }
}
