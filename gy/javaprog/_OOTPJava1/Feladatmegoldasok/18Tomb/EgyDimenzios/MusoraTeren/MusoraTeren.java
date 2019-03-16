/*
 * Feladatmegoldások/18. fejezet
 * MusoraTeren.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

// Ember osztály a 17.1. feladatból:
class Ember {
  private double x, y;
  private double iranySzog;  // fokban

  public Ember(double x, double y, double iranySzog) {
    this.x = x;
    this.y = y;
    this.iranySzog = iranySzog;
  }

  public Ember(double x, double y) {
    this(x,y,0);
  }

  public Ember() {
    this(0,0,0);
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getIranySzog() {
    return iranySzog;
  }

  public void setIranySzog(double szog) {
    iranySzog = szog%360;
  }

  public void elmegy(double x, double y) {
    odaFordul(x,y);
    this.x = x;
    this.y = y;
  }

  public void megy(double tav) {
    x += tav*cos(iranySzog);
    y += tav*sin(iranySzog);
  }

  public void fordul(double szog) {
    iranySzog = (iranySzog+szog)%360;
  }

  public void megFordul() {
    fordul(180);
  }

  public void odaFordul(double celX, double celY) {
    if (celX-x==0) { // 0-val nem lehet osztani
      if (celY-y>0)
        iranySzog = 90;  // függõlegesen felfelé megy
      else
        iranySzog = -90; // függõlegesen lefelé megy
    }
    else {
      if (celX-x>0)
        iranySzog = atan((celY-y)/(celX-x));
      else
        iranySzog = atan((celY-y)/(celX-x))+180;
      iranySzog = iranySzog%360;
    }
  }

  public String toString() {
    return "x= "+Format.right(x,3,0) +
      "  y= "+Format.right(y,3,0) +
      "  irány= "+Format.right(iranySzog,4,0);
  }

  // A Math osztályban a szögfüggvények radiánban mûködnek, ezért megírjuk ezeket fokra:
  private static double sin(double fok) {
    return Math.sin(fok*2*Math.PI/360);
  }

  private static double cos(double fok) {
    return Math.cos(fok*2*Math.PI/360);
  }
  // A szöggel szemközti oldal/szög melletti oldal arányából megadja a szöget:
  private static double atan(double arany) {
    return Math.atan(arany)*180/Math.PI;
  }
} // Ember

// MusoraTeren ------------------------------------------------------------------
public class MusoraTeren {
  private Ember[] emberek;  // emberek a téren

  public MusoraTeren() {
    emberek = new Ember[5];
    emberek[0] = new Ember(5,3);
    emberek[1] = new Ember(15,10,30);
    emberek[2] = new Ember(0,5,90);
    emberek[3] = new Ember(20,10);
    emberek[4] = new Ember(20,20,60);
  }

  void helyzetKep() {
    System.out.println("Helyzetkép:");
    for (int  i=0; i<emberek.length; i++)
      System.out.println(emberek[i]);
  }

  void mennek(double tav) {
    for (int  i=0; i<emberek.length; i++)
      emberek[i].megy(tav);
  }

  void mennek(double tav, double irany1, double irany2) {
    for (int  i=0; i<emberek.length; i++) {
      if (emberek[i].getIranySzog()>=irany1 && emberek[i].getIranySzog()<=irany2)
        emberek[i].megy(tav);
    }
  }

  void fordulnak(double iranySzog) {
    for (int  i=0; i<emberek.length; i++)
      emberek[i].fordul(iranySzog);
  }

  void megFordulnak(double tav) {
    for (int  i=0; i<emberek.length; i++) {
      double x = emberek[i].getX();
      double y = emberek[i].getY();
      double dTav = Math.sqrt(x*x+y*y);
      if (dTav > tav)
        emberek[i].megFordul();
    }
  }

  void run() {
    // a:
    mennek(1); helyzetKep();
    // b:
    mennek(2,0,90); helyzetKep();
    // c:
    fordulnak(30); helyzetKep();
    // d:
    megFordulnak(20); helyzetKep();
  }

  public static void main(String[] args) {
    MusoraTeren musor= new MusoraTeren();
    musor.run();
  }
}
