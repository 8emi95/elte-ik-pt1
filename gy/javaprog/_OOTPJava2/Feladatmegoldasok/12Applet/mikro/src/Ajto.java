/*
 * Feladatmegoldások/12. fejezet
 * Projekt: mikro
 * Ajto.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Be lehet csukni és ki lehet nyitni.
 * Hangot ad: csukáskor "ajtocsuk.wav", nyitáskor "ajtonyit.wav".
 * Más a kinézete a becsukott és a nyitott ajtónak.
 *
 * Egyelõre az ételt az ajtóra tesszük.
 * Majd egy továbbfejlesztett változatban másképp lesz...
 *
 * @author Angster Erzsébet
 * @version 1.0
 */

public class Ajto extends JLabel {
  private boolean nyitva = false;
  private Hang ajtonyit;
  private Hang ajtocsuk;

  /** Létrehozza az ajtót. */
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

  /** Kinyitja az ajtót, feltéve, hogy az ajtó csukva volt.
   *  Megszólal egy ajtónyitás hang, megváltozik az ajtó kinézete.
   */
  public void kinyit() {
    if (nyitva)
      return;
    nyitva = true;

    // Nyitási hang:
    ajtonyit.lejatszik();

    // Keret kinézete:
    kinezet();
  }

  /** Becsukja az ajtót, feltéve, hogy az ajtó nyitva volt.
   *  Megszólal egy ajtócsukás hang, megváltozik az ajtó kinézete.
   */
  public void becsuk() {
    if (! nyitva)
      return;
    nyitva = false;

    // Becsukási hang:
    ajtocsuk.lejatszik();

    // Keret kinézete:
    kinezet();

  }

  protected void kinezet() {
    if (nyitva) {
      setBackground(new Color(190,190,190));
      setText("Ajtó nyitva");
    }
    else {
      setBackground(Color.black);
      setText("Ajtó csukva");
    }
  }

  /** Megmondja, hogy az ajtó nyitva van-e */
  public boolean isNyitva() {
    return nyitva;
  }
}
