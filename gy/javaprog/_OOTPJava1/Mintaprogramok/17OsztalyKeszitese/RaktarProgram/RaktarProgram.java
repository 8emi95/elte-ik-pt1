/*
 * Mintaprogramok/17. fejezet
 * RaktarProgram.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
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
    return nev+"\tEgységár: "+egysegar+
      "\tMenny: "+menny+"\tÁr: "+getAr();
  }
}

public class RaktarProgram {                          //14
  private Aru aru;                                    //15

  public RaktarProgram() {                            //16
    aru = new Aru("Paradicsom",300);                  //17
  }

  public void akciok() {                              //18
    aru.hozzatesz(125);                               //19
    System.out.println(aru);                          //20
    aru.elvesz(25);                                   //21
    System.out.println(aru);                          //22
    aru.setEgysegar(210);                             //23
    System.out.println(aru);                          //24
  }

  public static void main(String[] args) {            //25
    RaktarProgram program = new RaktarProgram();      //26
    program.akciok();                                 //27
  }
}
