/*
 * Mintaprogramok/17. fejezet
 * Projekt: TermelFogyaszt
 * Raktar.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

public class Raktar {
  private int kapacitas;
  private int keszlet;

  public Raktar(int kapacitas) {
    this.kapacitas = kapacitas;
    keszlet = 0;
  }

  public synchronized void kivesz(int mennyiseg) {
    // Ha van elegend� �ru, kiszolg�ljuk:
    if (mennyiseg <= keszlet) {
      keszlet -= mennyiseg;
      System.out.println("Kivettek, k�szlet: " + keszlet);
    }
    else {
      System.out.println("Sajnos nem tudunk adni!");
      // V�r, am�g lesz ennyi. Addig nem szolg�l ki m�st:
      try {
        while (keszlet < mennyiseg)
          wait();
      }
      catch (InterruptedException ie) {
      }
    }
    // �rtes�ti a sz�lakat, h�tha v�r r� valaki:
    notifyAll();
  }

  public synchronized void betesz(int mennyiseg) {
    // Ha van elegend� hely, betessz�k:
    if (keszlet + mennyiseg <= kapacitas) {
      keszlet += mennyiseg;
      System.out.println("Betettek, k�szlet: " + keszlet);
    }
    else {
      System.out.println("Nem f�r be, v�rni kell!");
      // V�r, am�g lesz annyi hely:
      try {
        while (keszlet + mennyiseg <= kapacitas)
          wait();
      }
      catch (InterruptedException ie) {
      }
    }
    notifyAll();
  }
}
