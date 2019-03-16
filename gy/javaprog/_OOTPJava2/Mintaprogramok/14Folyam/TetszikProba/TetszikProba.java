/*
 * Mintaprogramok/14. fejezet
 * TetszikProba.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;
import java.util.Vector;

class Ember implements Serializable {
  private String nev;
  private Vector tetszok;

  public Ember(String nev) {
    this.nev = nev;
    tetszok = new Vector();
  }

  public String getNev() {
    return nev;
  }

  public String toString() {
    return getNev() + ". Tetszik neki: " + getTetszok() + "\n";
  }

  public void tetszik(Ember ember) {
    tetszok.add(ember);
  }

  public String getTetszok() {
    StringBuffer sb = new StringBuffer("");
    Ember ember;
    int n = tetszok.size();
    for (int i=0; i<n; i++) {
      ember = (Ember)(tetszok.get(i));
      if (i<n-1)
        sb.append(ember.getNev()+", ");
      else
        sb.append(ember.getNev());
    }
    return sb.toString();
  }
}

class Hallgato extends Ember implements Serializable {
  private int evfolyam;

  public Hallgato(String nev, int evfolyam) {
    super(nev);
    this.evfolyam = evfolyam;
  }

  public String toString() {
    return evfolyam+". éves "+super.toString();
  }
}

public class TetszikProba {
  private Vector emberek = new Vector();

  public TetszikProba() {
    // Az emberek vektor összeállítása:
    Ember peter;
    Hallgato aniko, timi, tibi;
    peter = new Ember("Peter");
    emberek.add(peter);
    emberek.add(aniko = new Hallgato("Aniko",2));
    emberek.add(timi = new Hallgato("Timi",3));
    emberek.add(tibi = new Hallgato("Tibi",2));
    aniko.tetszik(peter);
    peter.tetszik(aniko);
    tibi.tetszik(timi);
    tibi.tetszik(aniko);
    peter.tetszik(tibi);
  }

  // emberek vektor kiírása:
  public void kiir() {
    try {
      ObjectOutputStream os = new ObjectOutputStream(
                         new FileOutputStream("work/emberek.dat"));
      os.writeObject(emberek);
      os.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  // Az emberek vektor visszaolvasása:
  public void betolt() {
    try {
      ObjectInputStream os = new ObjectInputStream(
                          new FileInputStream("work/emberek.dat"));
      System.out.println(os.readObject());
      os.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    TetszikProba tp = new TetszikProba();
    tp.kiir();
    tp.betolt();
  }
}
