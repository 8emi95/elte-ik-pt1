/*
 * Feladatmegoldások/1. fejezet
 * Projekt: RaktarProgram
 * Aru.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

class Aru {                                           //1
  private String nev;                                 //2
  private double egysegar;                            //3
  private double menny;                               //4

  public Aru(String aNev, double aEgysegar) {         //5
    nev = aNev;
    egysegar = aEgysegar;
    menny = 0;
  }

  public String getNev() {                            //6
    return nev;
  }

  public double getEgysegar() {                       //7
    return egysegar;
  }

  public void setEgysegar(double aEgysegar) {         //8
    if (aEgysegar >= 0)
      egysegar = aEgysegar;
  }

  public double getMenny() {                          //9
    return menny;
  }

  public double getAr() {                             //10
    return menny*egysegar;
  }

  public void hozzatesz(double aMenny) {              //11
    if (aMenny>0)
      menny += aMenny;
  }

  public void elvesz(double aMenny) {                 //12
    if (aMenny>0 && aMenny<=menny)
      menny -= aMenny;
  }

  public String toString() {                          //13
    return nev+"\t Egysegar: "+egysegar+
      "\tMenny: "+menny+"\tAr: "+getAr();
  }
}
