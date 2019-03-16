/*
 * FeladatMegold�sok/18. fejezet
 * RaktarProgram2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

class Aru {
  private String nev;
  private double egysegar;
  private double menny;

  public Aru(String aNev, double aEgysegar) {
    nev = aNev;
    egysegar = aEgysegar;
    menny = 0;
  }

  public String getNev() {
    return nev;
  }

  public double getEgysegar() {
    return egysegar;
  }

  public void setEgysegar(double aEgysegar) {
    if (aEgysegar >= 0)
      egysegar = aEgysegar;
  }

  public double getMenny() {
    return menny;
  }

  public double getAr() {
    return menny*egysegar;
  }

  public void hozzatesz(double aMenny) {
    if (aMenny>0)
      menny += aMenny;
  }

  public void elvesz(double aMenny) {
    if (aMenny>0 && aMenny<=menny)
      menny -= aMenny;
  }

  public String toString() {
    return Format.left(nev,20)+"\tEgys�g�r: "+egysegar+
      "\tMenny: "+menny+"\t�r: "+getAr();
  }
}

public class RaktarProgram2 {
  private Aru paradicsom, paprika;

  public RaktarProgram2() {
    paradicsom = new Aru("Paradicsom",300);
    paprika = new Aru("Paprika",200);
  }

  public void akciok() {
    paradicsom.hozzatesz(125);
    System.out.println(paradicsom);
    paradicsom.elvesz(25);
    System.out.println(paradicsom);
    paradicsom.setEgysegar(210);
    System.out.println(paradicsom);

    paprika.hozzatesz(250);
    System.out.println(paprika);
    paprika.elvesz(50);
    System.out.println(paprika);
    paprika.setEgysegar(150);
    System.out.println(paprika);
  }

  public static void main(String[] args) {
    RaktarProgram2 program = new RaktarProgram2();
    program.akciok();
  }
}
