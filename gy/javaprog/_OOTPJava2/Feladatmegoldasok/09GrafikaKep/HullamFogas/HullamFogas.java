/*
 * Feladatmegold�sok/9. fejezet
 * HullamFogas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * K�sz�t�nk egy k�z�s �s PeriodusosKor oszt�lyt. A lesz�rmazottban csak az
 * absztrakt amplitudo f�ggv�nyt kell meg�rni, amely a k�rre 'r��l�' peri�dusos
 * f�ggv�ny: megadja a fokhoz tartoz� amplit�d�t 0 �s 360 k�z�tt:
 * - double amplitudo(fok)
 *
 * A HullamosKor oszt�ly amplit�d�f�ggv�nye a sin;
 * A FogasKerek oszt�ly� pedig 180 fok alatt -1, 180 �s 360 fok k�z�tt 1.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class PeriodusosKor extends JPanel {
  private int r;  // a peri�dusos k�r k�z�psugara
  private int db; // a k�r�n elhelyezked� peri�dusok sz�ma
  private int magassag; // a peri�dus (kiemelked�s) magass�ga
  private Color fillColor; // a kit�lt�s sz�ne
  private Color edgeColor; // a k�rvonal sz�ne

  public PeriodusosKor(int r, int db, int magassag,
    Color fillColor, Color edgeColor) {
    this.r = r;
    this.db = db;
    this.magassag = magassag;
    this.fillColor = fillColor;
    this.edgeColor = edgeColor;
  }

  /* Saj�t sin �s cos f�ggv�ny, melyek param�terei fokokban v�rj�k a sz�get.
     Erre t�bbsz�r is sz�ks�g�nk lesz a paint met�dusban, �gy az olvashat�bb lesz.
   */
  protected double sin(double fok) {
    return Math.sin(Math.toRadians(fok));
  }

  protected double cos(double fok) {
    return Math.cos(Math.toRadians(fok));
  }

  /* Peri�dusf�ggv�ny. A fok �rt�ke 0 �s 360 k�z�tt megy,
     a visszat�r�si �rt�k -1 �s 1 k�z�tti:
   */
  protected abstract double amplitudo(int fok);

  /*
   A kirajzol�s l�nyege: Az eg�sz hull�mos k�rt 1 fokos cikkekre osztjuk.
   A kirajzoland� cikkeket kis h�romsz�geknek tekintj�k, melyek �lland� cs�csa a (0,0).
   Fokonk�nt l�pegetve minden ciklusban elmentj�k az el�z� cs�csot, �s kisz�moljuk
   a k�vetkez�t. Az �j cs�cs koordin�t�inak kisz�m�t�s�hoz meghat�rozzuk a cs�cs
   k�z�ppontt�l m�rt t�vols�g�t (tav), ami a k�r �tlagos sugara (r), plusz a szinusz
   �rt�k magassag-szorosa. Ha a sz�get db-vel megszorozzuk, akkor db darab szinusz
   hull�m ker�l a k�rre. �gyel�nk arra, hogy a sz�m�t�sokn�l min�l kevesebb legyen a
   kerek�t�s, hogy a hull�mba ne ker�ljenek g�cs�rt�k.
   */
  public void paintComponent(Graphics g) {
    g.translate(getWidth()/2,getHeight()/2);
    // A k�vetkez� kit�ltend� h�romsz�g pontjai:
    int[] xPoints = {0,r,0}, yPoints = {0,0,0};

    for (int szog=0; szog<=360; szog++) {
      // A hat�rvonal k�vetkez� pontj�nak sugara:
      double tav = r+amplitudo(db*szog)*magassag;
      xPoints[2] = (int)(tav*cos(szog));
      yPoints[2] = (int)(tav*sin(szog));
      g.setColor(fillColor);
      g.fillPolygon(xPoints,yPoints,3);

      // Hat�rvonal k�vetkez� szakasz�nak kirajzol�sa:
      g.setColor(edgeColor);
      g.drawLine(xPoints[1],yPoints[1],xPoints[2],yPoints[2]);

      // A k�vetkez� szakasz kezd�pontja az el�z� szakasz v�gpontja lesz:
      xPoints[1] = xPoints[2];
      yPoints[1] = yPoints[2];

    }
  }
}

class HullamosKor extends PeriodusosKor {
  public HullamosKor(int r, int db, int magassag,Color fillColor, Color edgeColor) {
    super(r,db,magassag,fillColor,edgeColor);
  }

  // A peri�dusf�ggv�ny - visszat�r�si �rt�ke -1 �s 1 k�z�tti:
  protected double amplitudo(int fok) {
    return sin(fok);
  }
}

class FogasKerek extends PeriodusosKor {
  public FogasKerek(int r, int db, int magassag,Color fillColor, Color edgeColor) {
    super(r,db,magassag,fillColor,edgeColor);
  }

  // A peri�dusf�ggv�ny - visszat�r�si �rt�ke -1 �s 1 k�z�tti:
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
    // Param�terek: sug�r, db, kiemelked�s magass�ga, kit�lt�s- �s sz�lsz�n
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
