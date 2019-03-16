/*
 * Feladatmegold�sok/17. fejezet
 * BorFesztival.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class Hordo {
  private double kapacitas, mennyiseg;

  public Hordo(double kapacitas) {
    this.kapacitas = kapacitas;
    mennyiseg = kapacitas;
  }

  public boolean van(double menny) {
    return mennyiseg >= menny;
  }

  public boolean kitolt(double menny) {
    boolean ok;
    if (ok = van(menny))
      mennyiseg -= menny;
    return ok;
  }

  public String toString() {
    return "Kapacit�s:"+Format.right(kapacitas,5,2)+
      "  Mennyis�g:"+Format.right(mennyiseg,5,2);
  }
}

public class BorFesztival {
  private Hordo hordo;

  public BorFesztival() {
    hordo = new Hordo(100);
    osztogat();
  }

  public void oszt() {
    System.out.println(hordo);
    double menny = Console.readDouble("Mennyit? ");
    if (!hordo.kitolt(menny))
      System.out.println("Sajn�lom, nincs annyi!");
  }

  public void osztogat() {
    do {
      oszt();
    } while (hordo.van(0.1));
    System.out.println("Elfogyott!");
  }

  public static void main(String[] args) {
    new BorFesztival();
  }
}
