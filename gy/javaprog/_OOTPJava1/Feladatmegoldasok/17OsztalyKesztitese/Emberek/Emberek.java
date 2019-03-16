/*
 * Feladatmegoldások/17. fejezet
 * Emberek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

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

  public void megy(double tav) {
    x += tav*Math2.cos(iranySzog);
    y += tav*Math2.sin(iranySzog);
  }

  public void elmegy(double x, double y) {
    odaFordul(x,y);
    this.x = x;
    this.y = y;
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
        iranySzog = Math2.atan((celY-y)/(celX-x));
      else
        iranySzog = Math2.atan((celY-y)/(celX-x))+180;
      iranySzog = iranySzog%360;
    }
  }

  public String toString() {
    return "x="+Format.right(x,5,1) +
      "  y="+Format.right(y,5,1) +
      "  irány="+Format.right(iranySzog,5,1);
  }
} // Ember

// Emberek ------------------------------------------------------------------
public class Emberek {
  // Az 5. fejezet Jánosának ellenõrzése:
  void aFeladat() {
    Ember janos = new Ember(20,10);
    System.out.println();
    info("János most született:",janos);
    janos.fordul(30);
    info("fordul 30:",janos);
    janos.fordul(60);
    info("fordul 60:",janos);
    janos.megy(6);
    info("megy 6:",janos);
    janos.elmegy(5,16);
    info("elmegy 5,16:",janos);
    janos.megy(5);
    info("megy 5:",janos);
    janos.fordul(-150);
    info("fordul -150:",janos);
  }


  // Gergõ:
  void bFeladat() {
    Ember gergo = new Ember(30,5,120);
    System.out.println();
    info("Gergõ most született:",gergo);
    gergo.megy(10);
    info("megy 10:",gergo);
    gergo.fordul(120);
    info("fordul 120:",gergo);
    gergo.megy(13);
    info("megy 13:",gergo);
    gergo.elmegy(0,0);
    info("elmegy 0,0:",gergo);
  }

  // Gergõ és Anna:
  void cFeladat() {
    Ember gergo = new Ember(6,0);
    Ember anna = new Ember(0,6,90);
    System.out.println();
    info("Gergõ most született:",gergo);
    info("Anna most született:",anna);

    gergo.megFordul();
    anna.megFordul();
    info("Gergõ megfordult:",gergo);
    info("Anna megfordult:",anna);

    gergo.odaFordul(0,0);
    gergo.megy(3);
    anna.odaFordul(0,0);
    anna.megy(3);
    info("Gergõ ment 0 irányban 3-at:",gergo);
    info("Anna ment 0 irányban 3-at:",anna);

    gergo.odaFordul(anna.getX(),anna.getY());
    anna.odaFordul(gergo.getX(),gergo.getY());
    info("Gergõ Anna felé fordult:",gergo);
    info("Anna Gergõ felé fordult:",anna);
  }

  private void info(String info, Ember ember) {
    System.out.println(Format.left(info,30)+" "+ember);
  }

  public static void main(String[] args) {
    Emberek emberek = new Emberek();
    emberek.aFeladat();
    emberek.bFeladat();
    emberek.cFeladat();
  }
}

// Ezek a metódusok nincsenek benne a Math osztályban:
class Math2 {
  // A Math osztályban a szögfüggvények radiánban mûködnek, ezért megírjuk ezeket fokra:
  public static double sin(double fok) {
    return Math.sin(fok*2*Math.PI/360);
  }

  public static double cos(double fok) {
    return Math.cos(fok*2*Math.PI/360);
  }
  // A szöggel szemközti oldal és a szög melletti oldal arányából megadja a szöget:
  public static double atan(double arany) {
    return Math.atan(arany)*180/Math.PI;
  }
}
