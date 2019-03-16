/*
 * FeladatMegold�sok/18. fejezet
 * KetRaktarProgram.java
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

  public boolean van(double aMenny) {
    return aMenny>0 && aMenny<=menny;
  }

  public void hozzatesz(double aMenny) {
    if (aMenny>0)
      menny += aMenny;
  }

  public void elvesz(double aMenny) {
    if (van(aMenny))
      menny -= aMenny;
  }

  public static boolean egyenloNev(String aNev1, String aNev2) {
    return aNev1.trim().equalsIgnoreCase(aNev2.trim());
  }

  public String toString() {
    return Format.left(nev,20)+"\tEgys�g�r: "+egysegar+
      "\tMenny: "+menny+"\t�r: "+getAr();
  }
}

class Raktar {
  private String nev;
  private Aru paradicsom, paprika;

  public Raktar(String nev) {
    this.nev = nev;
    paradicsom = new Aru("Paradicsom",300);
    paradicsom.hozzatesz(150);
    paprika = new Aru("Paprika",200);
    paprika.hozzatesz(100);
  }

  public String getNev() {
    return nev;
  }

  public void setEgysegar(String aNev, double aEgysegar) {
    if (Aru.egyenloNev(aNev,paradicsom.getNev()))
      paradicsom.setEgysegar(aEgysegar);
    else if (Aru.egyenloNev(aNev,paprika.getNev()))
      paprika.setEgysegar(aEgysegar);
  }

  public boolean van(String aNev, double aMenny) {
    if (Aru.egyenloNev(aNev,paradicsom.getNev()))
      return paradicsom.van(aMenny);
    else if (Aru.egyenloNev(aNev,paprika.getNev()))
      return paprika.van(aMenny);
    else
      return false;
  }

  public void hozzatesz(String aNev, double aMenny) {
    if (Aru.egyenloNev(aNev,paradicsom.getNev()))
      paradicsom.hozzatesz(aMenny);
    else if (Aru.egyenloNev(aNev,paprika.getNev()))
      paprika.hozzatesz(aMenny);
  }

  public void elvesz(String aNev, double aMenny) {
    if (Aru.egyenloNev(aNev,paradicsom.getNev()))
      paradicsom.elvesz(aMenny);
    else if (Aru.egyenloNev(aNev,paprika.getNev()))
      paprika.elvesz(aMenny);
  }

  public String toString() {
    return nev+" �rui:\n"+paradicsom+"\n"+paprika+"\n";
  }
}

public class KetRaktarProgram {
  private Raktar raktar1, raktar2;

  public KetRaktarProgram() {
    raktar1 = new Raktar("Rakt�r1");
    raktar2 = new Raktar("Rakt�r2");
  }

  void attesz(Raktar honnet, Raktar hova, String aNev) {
    double aMenny = Console.readDouble("Mennyi "+aNev+"-t kiv�n �tteni "+honnet.getNev()+"-b�l "+hova.getNev()+"-be? ");
    if (honnet.van(aNev,aMenny)) {
      honnet.elvesz(aNev,aMenny);
      hova.hozzatesz(aNev,aMenny);
      System.out.println(honnet.getNev()+"-b�l �ttettem "+aMenny+" "+aNev+"-t "+hova.getNev()+"-be.");
    }
    else
      System.out.println(honnet.getNev()+"-ben nincs "+aMenny+" "+aNev+"!!!");
    System.out.println();
  }

  void setEgysegar(String aNev, double aEgysegar) {
    raktar1.setEgysegar(aNev,aEgysegar);
    raktar2.setEgysegar(aNev,aEgysegar);
  }

  void menu() {
    char valasz;
    do {
      System.out.println(raktar1);
      System.out.println(raktar2);

      System.out.println("1. "+raktar1.getNev()+"-b�l paradicsom �tt�tele "+raktar2.getNev()+"-be.");
      System.out.println("2. "+raktar1.getNev()+"-b�l paprika �tt�tele "+raktar2.getNev()+"-be.");
      System.out.println("3. "+raktar2.getNev()+"-b�l paradicsom �tt�tele "+raktar1.getNev()+"-be.");
      System.out.println("4. "+raktar2.getNev()+"-b�l paprika �tt�tele "+raktar1.getNev()+"-be.");
      System.out.println("5. Paradicsom egys�g�r�nak v�ltoztat�sa");
      System.out.println("6. Paprika egys�g�r�nak v�ltoztat�sa");
      System.out.println("K  Kil�p�s");
      valasz = Character.toUpperCase(Console.readChar("Melyik men�pontot v�lasztja? "));
      switch (valasz) {
        case '1': {
          attesz(raktar1,raktar2,"paradicsom");
          break;
        }
        case '2': {
          attesz(raktar1,raktar2,"paprika");
          break;
        }
        case '3': {
          attesz(raktar2,raktar1,"paradicsom");
          break;
        }
        case '4': {
          attesz(raktar2,raktar1,"paprika");
          break;
        }
        case '5': {
          setEgysegar("paradicsom",Console.readDouble("�j egys�g�r: "));
          break;
        }
        case '6': {
          setEgysegar("paprika",Console.readDouble("�j egys�g�r: "));
          break;
        }
      } // switch
    } while (valasz!='K');
  }

  public static void main(String[] args) {
    KetRaktarProgram program = new KetRaktarProgram();
    program.menu();
  }
}
