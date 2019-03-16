/*
 * FeladatMegold�sok/20. fejezet
 * RaktarProgram3.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;
import java.util.Vector;

class Aru {
  private String nev;
  private double egysegar;
  private double menny;

  public Aru(String aNev, double aEgysegar, double aMenny) {
    nev = aNev;
    egysegar = aEgysegar;
    menny = aMenny;
  }

  public Aru(String aNev, double aEgysegar) {
    this(aNev,aEgysegar,0);
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

  // A vektorban val� keres�s n�v szerint t�rt�nik:
  public boolean equals(Object obj) {
    return egyenloNev(nev,((Aru)obj).getNev());
  }

  public String toString() {
    return Format.left(nev,20)+"\tEgys�g�r: "+egysegar+
      "\tMenny: "+menny+"\t�r: "+getAr();
  }
}

class Raktar {
  private String nev;
  private Vector aruk;

  public Raktar(String nev) {
    this.nev = nev;
    aruk=new Vector();
  }

  public String getNev() {
    return nev;
  }

  public int indexOf(String aNev) {
    return aruk.indexOf(new Aru(aNev,0));
  }

  public boolean hozzatesz(int index, double aMenny) {
    if (index<0 || index>=aruk.size() || aMenny<=0)
      return false;
    Aru aru = (Aru)aruk.get(index);
    aru.hozzatesz(aMenny);
    aruk.set(index,aru);
    return true;
  }

  public boolean elvesz(int index, double aMenny) {
    if (index<0 || index>=aruk.size() || aMenny<=0)
      return false;
    Aru aru = (Aru)aruk.get(index);
    if (aru.getMenny()<aMenny)
      return false;
    aru.elvesz(aMenny);
    aruk.set(index,aru);
    return true;
  }

  public void ujAru(Aru aru) {
    aruk.add(aru);
  }

  public String toString() {
    if (aruk.size()==0)
      return "A "+nev+" rakt�r �res!";
    StringBuffer sb=new StringBuffer(nev+" �rui:\n");
    for (int i=0; i<aruk.size(); i++)
      sb.append(aruk.get(i)+"\n");
    return sb.toString();
  }
}

public class RaktarProgram3 {
  private Raktar raktar=new Raktar(Console.readLine("Adja meg a rakt�r nev�t: "));

  void betesz() {
    String nev = Console.readLine("�ru neve: ");
    int poz = raktar.indexOf(nev);
    if (poz>=0) {
      System.out.println("L�tez� �ru.");
      double menny = Console.readDouble("Betenni k�v�nt mennyis�g: ");
      raktar.hozzatesz(poz,menny);
    }
    else {
      System.out.println("�j �ru.");
      double eAr = Console.readDouble("�ru egys�g�ra: ");
      double menny = Console.readDouble("Betenni k�v�nt mennyis�g: ");
      raktar.ujAru(new Aru(nev,eAr,menny));
    }
  }

  void kivesz() {
    String nev = Console.readLine("�ru neve: ");
    int poz = raktar.indexOf(nev);
    if (poz>=0) {
      double menny = Console.readDouble("Kivenni k�v�nt mennyis�g: ");
      if (!raktar.elvesz(poz,menny))
        System.out.println("Nincs ennyi az adott �rub�l!");
    }
    else {
      System.out.println("Nincs ilyen nev� �ru!");
    }
  }

  private boolean benne(char kar,String s) {
    kar = Character.toUpperCase(kar);
    return (s.indexOf(kar)>=0);
  }

  void menu() {
    char valasz;
    do {
      System.out.println("\n"+raktar);

      System.out.println("B Betesz");
      System.out.println("K Kivesz");
      System.out.println("V V�ge");
      do
        valasz = Character.toUpperCase(Console.readChar());
      while (!benne(valasz,"BKV"));
      System.out.println();
      switch (valasz) {
        case 'B':
          betesz();
          break;
        case 'K':
          kivesz();
          break;
      }
    } while (valasz != 'V');
  }

  public static void main(String[] args) {
    RaktarProgram3 program = new RaktarProgram3();
    program.menu();
  }
}
