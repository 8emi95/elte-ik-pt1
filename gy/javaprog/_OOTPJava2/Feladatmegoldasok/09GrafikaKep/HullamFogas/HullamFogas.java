/*
 * Feladatmegoldások/9. fejezet
 * HullamFogas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Készítünk egy közös õs PeriodusosKor osztályt. A leszármazottban csak az
 * absztrakt amplitudo függvényt kell megírni, amely a körre 'ráülõ' periódusos
 * függvény: megadja a fokhoz tartozó amplitúdót 0 és 360 között:
 * - double amplitudo(fok)
 *
 * A HullamosKor osztály amplitúdófüggvénye a sin;
 * A FogasKerek osztályé pedig 180 fok alatt -1, 180 és 360 fok között 1.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class PeriodusosKor extends JPanel {
  private int r;  // a periódusos kör középsugara
  private int db; // a körön elhelyezkedõ periódusok száma
  private int magassag; // a periódus (kiemelkedés) magassága
  private Color fillColor; // a kitöltés színe
  private Color edgeColor; // a körvonal színe

  public PeriodusosKor(int r, int db, int magassag,
    Color fillColor, Color edgeColor) {
    this.r = r;
    this.db = db;
    this.magassag = magassag;
    this.fillColor = fillColor;
    this.edgeColor = edgeColor;
  }

  /* Saját sin és cos függvény, melyek paraméterei fokokban várják a szöget.
     Erre többször is szükségünk lesz a paint metódusban, így az olvashatóbb lesz.
   */
  protected double sin(double fok) {
    return Math.sin(Math.toRadians(fok));
  }

  protected double cos(double fok) {
    return Math.cos(Math.toRadians(fok));
  }

  /* Periódusfüggvény. A fok értéke 0 és 360 között megy,
     a visszatérési érték -1 és 1 közötti:
   */
  protected abstract double amplitudo(int fok);

  /*
   A kirajzolás lényege: Az egész hullámos kört 1 fokos cikkekre osztjuk.
   A kirajzolandó cikkeket kis háromszögeknek tekintjük, melyek állandó csúcsa a (0,0).
   Fokonként lépegetve minden ciklusban elmentjük az elõzõ csúcsot, és kiszámoljuk
   a következõt. Az új csúcs koordinátáinak kiszámításához meghatározzuk a csúcs
   középponttól mért távolságát (tav), ami a kör átlagos sugara (r), plusz a szinusz
   érték magassag-szorosa. Ha a szöget db-vel megszorozzuk, akkor db darab szinusz
   hullám kerül a körre. Ügyelünk arra, hogy a számításoknál minél kevesebb legyen a
   kerekítés, hogy a hullámba ne kerüljenek göcsörtök.
   */
  public void paintComponent(Graphics g) {
    g.translate(getWidth()/2,getHeight()/2);
    // A következõ kitöltendõ háromszög pontjai:
    int[] xPoints = {0,r,0}, yPoints = {0,0,0};

    for (int szog=0; szog<=360; szog++) {
      // A határvonal következõ pontjának sugara:
      double tav = r+amplitudo(db*szog)*magassag;
      xPoints[2] = (int)(tav*cos(szog));
      yPoints[2] = (int)(tav*sin(szog));
      g.setColor(fillColor);
      g.fillPolygon(xPoints,yPoints,3);

      // Határvonal következõ szakaszának kirajzolása:
      g.setColor(edgeColor);
      g.drawLine(xPoints[1],yPoints[1],xPoints[2],yPoints[2]);

      // A következõ szakasz kezdõpontja az elõzõ szakasz végpontja lesz:
      xPoints[1] = xPoints[2];
      yPoints[1] = yPoints[2];

    }
  }
}

class HullamosKor extends PeriodusosKor {
  public HullamosKor(int r, int db, int magassag,Color fillColor, Color edgeColor) {
    super(r,db,magassag,fillColor,edgeColor);
  }

  // A periódusfüggvény - visszatérési értéke -1 és 1 közötti:
  protected double amplitudo(int fok) {
    return sin(fok);
  }
}

class FogasKerek extends PeriodusosKor {
  public FogasKerek(int r, int db, int magassag,Color fillColor, Color edgeColor) {
    super(r,db,magassag,fillColor,edgeColor);
  }

  // A periódusfüggvény - visszatérési értéke -1 és 1 közötti:
  protected double amplitudo(int fok) {
    if (fok%360<180)
      return -1;
    else
      return 1;
  }
}

public class HullamFogas extends JFrame {
  public HullamFogas() {
    setBounds(100,100,800,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(1,4));
    cp.setBackground(Color.lightGray);

    Color zold = new Color(120,140,120);
    Color kek = new Color(120,120,140);
    // Paraméterek: sugár, db, kiemelkedés magassága, kitöltés- és szélszín
    cp.add(new HullamosKor(80,15,6,zold,Color.black));
    cp.add(new HullamosKor(40,6,4,kek,Color.yellow));
    cp.add(new FogasKerek(80,20,10,zold,Color.white));
    cp.add(new FogasKerek(40,6,4,kek,Color.white));

    show();
  }

  public static void main (String args[]) {
    new HullamFogas();
  }
}
